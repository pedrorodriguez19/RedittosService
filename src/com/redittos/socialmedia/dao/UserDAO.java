package com.redittos.socialmedia.dao;

import java.sql.SQLException;
import java.util.List;

import com.redittos.socialmedia.model.User;
import com.redittos.socialmedia.service.DataException;

public interface UserDAO {

	public void createUser(User user) throws SQLException, ClassNotFoundException, DataException;

	public void deleteUser(Long id) throws SQLException, ClassNotFoundException, DataException;

	public boolean modifyUser(User user) throws SQLException, ClassNotFoundException, DataException;

	public User findById(Long id) throws SQLException, DataException;

	public User findByEmail(String email) throws SQLException, DataException;

	public List<User> findByName(String name) throws SQLException, DataException;

}
