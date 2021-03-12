package com.redittos.socialmedia.dao.jdbc;

import java.util.Date;
import java.util.List;

import com.redittos.socialmedia.dao.MessageDAO;
import com.redittos.socialmedia.model.Message;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public void createMessage(Message msg) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyMessage(Message msg) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Message findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByIssuerId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByReceiverId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByDate(Date from, Date to) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
