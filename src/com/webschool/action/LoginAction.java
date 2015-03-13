package com.webschool.action;

import javax.servlet.http.Cookie;

import com.opensymphony.xwork2.Action;
import com.webschool.model.User;
import com.webschool.service.UserService;

public class LoginAction extends BaseAction {
	
	private String userId;
	private String password;
	private String loginErrorMessage;
	private UserService userService;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}
	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() {
		
		if(this.getMe()!=null) {
			return Action.SUCCESS;
		}
		
		if(userId==null || userId.equals("")) {
			setLoginErrorMessage("please input user id");
			return Action.ERROR;
		}
		if(password==null || password.equals("")) {
			setLoginErrorMessage("please input password");
			return Action.ERROR;
		}
		
		User user = this.getUserService().getUserByUserId(userId);
		
		if(user==null) {
			setLoginErrorMessage("user id error!");
			return Action.ERROR;
		}
		
		if(!password.equals(user.getPassword())) {
			setLoginErrorMessage("password error!");
			return Action.ERROR;
		}
		
		rememberMe(user);
		
		return Action.SUCCESS;
	}
	
	public void rememberMe(User user) {
		this.setMe(user);
		getSession().setAttribute("user", user);
		Cookie cookie = new Cookie("id",user.getUserId());
		cookie.setMaxAge(1000000000);
		getHttpServletResponse().addCookie(cookie);
	}
	
	public String logout() {
		this.setMe(null);
		getSession().setAttribute("user", null);
		return Action.SUCCESS;
	}
}
