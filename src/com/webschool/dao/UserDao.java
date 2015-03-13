package com.webschool.dao;

import java.util.List;

import com.webschool.model.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public List<User> getUserByUserId(String userId);
	public Integer save(User user);
	public void delete(User user);
	public void update(User user);
}
