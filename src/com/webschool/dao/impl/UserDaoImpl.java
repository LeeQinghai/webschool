package com.webschool.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.webschool.dao.UserDao;
import com.webschool.model.User;

public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<User> getAllUsers() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	};
	
	public User getUserById(Integer id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
	
	public List<User> getUserByUserId(String userId) {
		return (List<User>) this.getHibernateTemplate().find("from User where user_id = ?", userId);
	};
	
	public Integer save(User user) {
		return (Integer) this.getHibernateTemplate().save(user);
		
	}
	
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}
	
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}
}
