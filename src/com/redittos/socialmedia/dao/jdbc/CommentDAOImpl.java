package com.redittos.socialmedia.dao.jdbc;

import java.util.Date;
import java.util.List;

import com.redittos.socialmedia.dao.CommentDAO;
import com.redittos.socialmedia.model.Comment;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public Comment findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByUserId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByPostId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByDate(Date from, Date to) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub

	}

}
