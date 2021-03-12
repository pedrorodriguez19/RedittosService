package com.redittos.socialmedia.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redittos.socialmedia.dao.PostDAO;
import com.redittos.socialmedia.model.Post;
import com.redittos.socialmedia.model.SearchCriteria;
import com.redittos.socialmedia.service.DataException;

public class PostDAOImpl implements PostDAO {

	private Logger log = LogManager.getLogger();

	@Override
	public void createPost(Post post) throws DataException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "INSERT INTO USERS(TITLE, TXT, USER_ID, TOPIC_ID, DATE, LANG_ID) VALUES(?,?,?,?,?,?)";

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			int i = 1;
			statement.setString(i++, post.getPostTitle());
			statement.setString(i++, post.getPostTxt());
			statement.setLong(i++, post.getUserId());
			statement.setLong(i++, post.getTopicId());
			statement.setDate(i++, DBUtils.getDate(post.getPublished()));
			statement.setLong(i++, post.getLanguage());

			statement.executeUpdate();

		} catch (SQLException sq) {
			log.error("Error al crear el post: ", sql, sq);
		} catch (ClassNotFoundException nf) {
			log.error(nf);
		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtils.close(statement);
			DBUtils.closeConnection(connection);
			log.info("Connection closed");
		}
	}

	@Override
	public void deletePost(Long id) throws DataException {
		StringBuilder str = new StringBuilder();
		Connection connection = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			Statement statement = connection.createStatement();

			sql = "DELETE ID, TITLE, TXT, USER_ID, TOPIC_ID, PUBLISHED, LANGUAGE FROM POST WHERE ID = ";
			str.append(sql);
			str.append(id);

			statement.executeUpdate(str.toString());

		} catch (SQLException sq) {
			log.error("Error al eliminar el post: ", sql, sq);
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
	public boolean modifyPost(Post post) throws DataException {
		StringBuilder str = new StringBuilder();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			Statement statement = connection.createStatement();
			sql = "UPDATE USER SET ?,?,?,?,?,?,? WHERE ID = ";
			str.append(sql);
			str.append(post.getId());
			statement.executeUpdate(sql);

			preparedStatement = connection.prepareStatement(str.toString());

			int i = 1;

			preparedStatement.setLong(i++, post.getId());
			preparedStatement.setString(i++, post.getPostTitle());
			preparedStatement.setString(i++, post.getPostTxt());
			preparedStatement.setLong(i++, post.getUserId());
			preparedStatement.setLong(i++, post.getTopicId());
			preparedStatement.setDate(i++, DBUtils.getDate(post.getPublished()));
			preparedStatement.setLong(i++, post.getLanguage());

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
	public Post findById(Long id) throws DataException {
		StringBuilder str = new StringBuilder();
		Post result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,?,?,?,? FROM POST WHERE id = ";
			str.append(sql);
			str.append(id);
			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new Post();

			while (rs.next()) {
				result = new Post();
				result = loadNext(rs);
			}
			rs.close();
			ps.close();
			connection.close();
			log.info("Hola Mundo");
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
	public List<Post> findByDate(Date from, Date to) {
		// TODO
		return null;
	}

	@Override
	public List<Post> findByUserId(Long id) throws DataException {
		StringBuilder str = new StringBuilder();
		Post result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,?,?,?,? FROM POST WHERE USER_ID = ";
			str.append(sql);
			str.append(id);

			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new Post();

			while (rs.next()) {
				result = new Post();
				result = loadNext(rs);
				posts.add(result);
			}
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
		return posts;
	}

	@Override
	public List<Post> findByTopicId(Long id) throws DataException {
		StringBuilder str = new StringBuilder();

		Post result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,?,?,?,? FROM POST WHERE TOPIC_ID = ";

			str.append(sql);
			str.append(id);

			ps = connection.prepareStatement(str.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new Post();

			while (rs.next()) {
				result = new Post();
				result = loadNext(rs);
				posts.add(result);
			}
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
		return posts;
	}

	@Override
	public List<Post> findByLanguage(Long id) throws DataException {
		StringBuilder str = new StringBuilder();

		Post result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,?,?,?,? FROM POST WHERE LANG_ID = ";

			str.append(sql);
			str.append(id);

			ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new Post();

			while (rs.next()) {
				result = new Post();
				result = loadNext(rs);
				posts.add(result);
			}
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
		return posts;
	}

	@Override
	public List<Post> findByState(Character state, Long topic) throws DataException {
		StringBuilder str = new StringBuilder();

		Post result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = DBUtils.getConnection();

			sql = "SELECT ?,?,?,?,?,? FROM POST WHERE STATE = ";

			str.append(state);

			str.append("AND TOPIC_ID = ");

			str.append(topic);

			ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			result = new Post();

			while (rs.next()) {
				result = new Post();
				result = loadNext(rs);
				posts.add(result);
			}
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
		return posts;
	}

	@Override
	public List<Post> findByCriteria(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post loadNext(ResultSet rs) throws SQLException {
		int i = 1;
		Post post = new Post();

		post.setPostTitle(rs.getString(i++));
		post.setPostTxt(rs.getString(i++));
		post.setUserId(rs.getLong(i++));
		post.setTopicId(rs.getLong(i++));
		post.setPublished(rs.getDate(i++));
		post.setLanguage(rs.getLong(i++));

		return post;
	}

}
