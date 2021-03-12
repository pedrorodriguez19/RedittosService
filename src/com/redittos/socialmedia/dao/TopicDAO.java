package com.redittos.socialmedia.dao;

import java.util.List;

import com.redittos.socialmedia.model.Topic;
import com.redittos.socialmedia.service.DataException;

public interface TopicDAO {

	public void createTopic(Topic topic) throws DataException;

	public void deleteTopic(Long id) throws DataException;

	public void modifyTopic(Topic topic) throws DataException;

	public Topic findById(Long id) throws DataException;

	public Topic findByCreatorId(Long id) throws DataException;

	public List<Topic> findByName(String name) throws DataException;

	public List<Long> findByBanned(Topic topic) throws DataException;

}
