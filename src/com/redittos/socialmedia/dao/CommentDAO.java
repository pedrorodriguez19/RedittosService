package com.redittos.socialmedia.dao;

import java.util.Date;
import java.util.List;

import com.redittos.socialmedia.model.Comment;

public interface CommentDAO {

	public Comment findById(Long id) throws Exception;

	public List<Comment> findByUserId(Long id) throws Exception;

	public List<Comment> findByPostId(Long id) throws Exception;

	public List<Comment> findByDate(Date from, Date to) throws Exception;

	public void createComment(Comment comment) throws Exception;

	public void deleteComment(Long id) throws Exception;

	public void modifyComment(Comment comment) throws Exception;

}
