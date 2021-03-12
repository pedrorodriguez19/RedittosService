package com.redittos.socialmedia.dao.jdbc;

import java.util.List;

import com.redittos.socialmedia.dao.ModeratorDAO;
import com.redittos.socialmedia.model.Post;
import com.redittos.socialmedia.model.Topic;
import com.redittos.socialmedia.model.User;

public class ModeratorDAOImpl implements ModeratorDAO {

	@Override
	public void addModerator(Long userId, Long topicId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteModerator(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Post changeState(User user, Post post) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findByModerator(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
