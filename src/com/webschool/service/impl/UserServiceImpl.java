package com.webschool.service.impl;

import java.util.List;

import com.webschool.dao.UserDao;
import com.webschool.model.User;
import com.webschool.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	};
	
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	public User getUserByUserId(String userId) {
		List<User> listUser = userDao.getUserByUserId(userId);
		User user = null;
		if(listUser.size()>0) {
			user = listUser.get(0);
		}
		return user;
	};
	
	public Integer save(User user) {
		return userDao.save(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
}
