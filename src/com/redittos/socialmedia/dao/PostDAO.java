package com.redittos.socialmedia.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.redittos.socialmedia.model.Post;
import com.redittos.socialmedia.model.SearchCriteria;
import com.redittos.socialmedia.service.DataException;

public interface PostDAO {
	public void createPost(Post post) throws SQLException, ClassNotFoundException, DataException;

	public void deletePost(Long id) throws SQLException, ClassNotFoundException, DataException;

	public boolean modifyPost(Post post) throws SQLException, ClassNotFoundException, DataException;

	public Post findById(Long id) throws SQLException, DataException;

	public List<Post> findByDate(Date from, Date to) throws SQLException;

	public List<Post> findByUserId(Long id) throws SQLException, DataException;

	public List<Post> findByTopicId(Long id) throws SQLException, DataException;

	public List<Post> findByLanguage(Long id) throws SQLException, DataException;

	public List<Post> findByState(Character state, Long topic) throws DataException;

	public List<Post> findByCriteria(SearchCriteria criteria) throws SQLException;

}
