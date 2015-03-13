package com.webschool.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.webschool.model.User;
import com.webschool.service.UserService;

public class UserAction extends BaseAction {
	
	private List<User> userList;
	private UserService userService;
	
	//user register
	private Integer id;
	private String userId;
	private String userName;
	private String password;
	private String password2;
	private String phone;
	private String email;
	private Integer state;
	private String register;
	private String registerErrorMessage;
	
	//edit user
	private User user;
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegisterErrorMessage() {
		return registerErrorMessage;
	}
	public void setRegisterErrorMessage(String registerErrorMessage) {
		this.registerErrorMessage = registerErrorMessage;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String userList() {
		userList = userService.getAllUsers();
		return Action.SUCCESS;
	}
	
	public String userRegister() {
		
		if(register==null) {
			return Action.INPUT;
		}
		
		if(userId==null || userId.equals("")) {
			registerErrorMessage = "please input id";
			return Action.ERROR;
		}
		if(userName==null || userName.equals("")) {
			registerErrorMessage = "please input name";
			return Action.ERROR;
		}
		if(password==null || password.equals("")) {
			registerErrorMessage = "please input password";
			return Action.ERROR;
		}
		if(password2==null || password2.equals("")) {
			registerErrorMessage = "please input confirm password";
			return Action.ERROR;
		}
		if(!password.equals(password2)) {
			registerErrorMessage = "confirm password error";
			return Action.ERROR;
		}
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setState(1);
		user.setCreateDt(new Date());
		user.setCreateUserId(this.getMe().getUserId());
		user.setUpdateDt(new Date());
		user.setUpdateUserId(this.getMe().getUserId());
		
		Integer id = userService.save(user);
		if(id==null) {
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	
	public String userDelete() {
		User user = userService.getUserById(id);
		if(user!=null) {
			userService.delete(user);
		}
		return Action.SUCCESS;
	}
	
	public String userEdit() {
		User user = userService.getUserById(id);
		setUserId(user.getUserId());
		setUserName(user.getUserName());
		setPassword(user.getPassword());
		setPhone(user.getPhone());
		setEmail(user.getEmail());
		setState(1);
		return Action.SUCCESS;
	}
	
	public String userEditSave() {
		user = userService.getUserById(id);
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setState(1);
		user.setUpdateDt(new Date());
		user.setUpdateUserId(this.getMe().getUserId());
		userService.update(user);
		return Action.SUCCESS;
	}
}
