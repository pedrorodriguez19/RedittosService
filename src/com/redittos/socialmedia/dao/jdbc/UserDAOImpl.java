package com.redittos.socialmedia.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redittos.socialmedia.dao.UserDAO;
import com.redittos.socialmedia.model.User;
import com.redittos.socialmedia.service.DataException;

public class UserDAOImpl implements UserDAO {

	private Logger log = LogManager.getLogger();

	@Override
	public void createUser(User user) throws DataException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "INSERT INTO USERS(name, email, password) VALUES(?,?,?)";

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			int i = 1;
			statement.setString(i++, user.getName());
			statement.setString(i++, user.getEmail());
			statement.setString(i++, user.getPassword());

			statement.executeUpdate();

		} catch (SQLException sq) {
			log.error("Error al modificar el post: ", sql, sq);
		} catch (ClassNotFoundException nf) {
			log.error(nf);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.close(statement);
			DBUtils.closeConnection(connection);
			System.out.println("Connection closed");
		}
	}

	@Override
	public void deleteUser(Long id) throws DataException {
		StringBuilder str = new StringBuilder();
		Connection connection = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			Statement statement = connection.createStatement();

			sql = "DELETE FROM USERS WHERE ID = ";
			str.append(sql);
			str.append(id);

			statement.executeUpdate(str.toString());

		} catch (SQLException sq) {
			log.error("Error al modificar el post: ", sql, sq);
		} catch (ClassNotFoundException nf) {
			log.error(nf);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}

	}

	@Override
	public boolean modifyUser(User user) throws DataException {
		StringBuilder str = new StringBuilder();

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			Statement statement = connection.createStatement();
			sql = "UPDATE ?,? SET NAME WHERE ID = ";

			str.append(sql);
			str.append(user.getId());

			statement.executeUpdate(str.toString());

			preparedStatement = connection.prepareStatement(sql);

			int i = 1;

			preparedStatement.setString(i++, user.getName());
			preparedStatement.setString(i++, user.getEmail());

			int updated = preparedStatement.executeUpdate();

			if (updated != 1) {
				throw new Exception("Usuario erroneo");
			}

		} catch (SQLException sq) {
			log.error("Error al modificar el post: ", sql, sq);
		} catch (ClassNotFoundException nf) {
			log.error(nf);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}
		return true;
	}

	@Override
	public User findById(Long id) throws DataException {
		StringBuilder str = new StringBuilder();
		User result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,? FROM USER WHERE id = ";

			str.append(sql);
			str.append(id);
			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new User();

			while (rs.next()) {
				result = new User();
				result = loadNext(rs);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException sq) {
			log.error("Error al encontrar el post: ", sql, sq);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}
		return result;
	}

	@Override
	public User findByEmail(String email) throws DataException {
		StringBuilder str = new StringBuilder();
		User result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,? FROM USER WHERE UPPER(EMAIL) LIKE ";

			str.append(sql);
			str.append(email);
			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			int i = 1;

			ps.setString(i++, email.toUpperCase());

			rs = ps.executeQuery();

			result = new User();

			while (rs.next()) {
				result = new User();
				result = loadNext(rs);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException sq) {
			log.error("Error al encontrar el post: ", sql, sq);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}
		return result;
	}

	@Override
	public List<User> findByName(String name) throws DataException {
		StringBuilder str = new StringBuilder();
		User result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,? FROM USER WHERE UPPER(NAME) LIKE ";

			str.append(sql);
			str.append(name);

			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			int i = 1;

			ps.setString(i++, name.toUpperCase());

			rs = ps.executeQuery();

			result = new User();

			while (rs.next()) {
				result = new User();
				result = loadNext(rs);
				users.add(result);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException sq) {
			log.error("Error al encontrar el post: ", sql, sq);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}
		return users;
	}

	private User loadNext(ResultSet resultSet) throws SQLException {
		int i = 1;
		User User = new User();
		User.setId(resultSet.getLong(i++));
		User.setName(resultSet.getString(i++));
		User.setEmail(resultSet.getString(i++));
		User.setPassword(resultSet.getString(i++));

		return User;

	}

}
