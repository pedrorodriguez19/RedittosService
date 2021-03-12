package com.redittos.socialmedia.dao;

import java.util.Date;
import java.util.List;

import com.redittos.socialmedia.model.Message;

public interface MessageDAO {

	public void createMessage(Message msg) throws Exception;

	public void deleteMessage(Long id) throws Exception;

	public void modifyMessage(Message msg) throws Exception;

	public Message findById(Long id) throws Exception;

	public List<Message> findByIssuerId(Long id) throws Exception;

	public List<Message> findByReceiverId(Long id) throws Exception;

	public List<Message> findByDate(Date from, Date to) throws Exception;
}
