package com.redittos.socialmedia.dao;

import java.util.List;

import com.redittos.socialmedia.model.Post;
import com.redittos.socialmedia.model.Topic;
import com.redittos.socialmedia.model.User;

public interface ModeratorDAO {

	public void addModerator(Long userId, Long topicId) throws Exception;

	public void deleteModerator(Long id) throws Exception;

	public Post changeState(User user, Post post) throws Exception;

	public List<Topic> findByModerator(Long id) throws Exception;

}
