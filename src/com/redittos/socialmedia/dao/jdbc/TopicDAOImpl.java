package com.redittos.socialmedia.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.redittos.socialmedia.dao.TopicDAO;
import com.redittos.socialmedia.model.Topic;
import com.redittos.socialmedia.service.DataException;

public class TopicDAOImpl implements TopicDAO {

	@Override
	public void createTopic(Topic topic) throws DataException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtils.getConnection();

			String sql = "INSERT INTO TOPIC(ID, NAME, CREATOR_ID) VALUES(?,?,?)";

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			int i = 1;
			statement.setString(i++, topic.getName());
			statement.setLong(i++, topic.getCreatorId());

			statement.executeUpdate();

		} catch (SQLException sq) {
			sq.printStackTrace();
		} catch (ClassNotFoundException nf) {
			nf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(statement);
			DBUtils.closeConnection(connection);
			System.out.println("Connection closed");
		}

	}

	@Override
	public void deleteTopic(Long id) throws DataException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyTopic(Topic topic) throws DataException {
		// TODO Auto-generated method stub

	}

	@Override
	public Topic findById(Long id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic findByCreatorId(Long id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findByName(String name) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findByBanned(Topic topic) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

}
