package com.webschool.service;

import java.util.List;

import com.webschool.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public User getUserByUserId(String userId);
	public Integer save(User user);
	public void delete(User user);
	public void update(User user);
}
