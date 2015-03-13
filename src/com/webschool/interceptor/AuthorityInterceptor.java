package com.webschool.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.webschool.model.User;

public class AuthorityInterceptor extends MethodFilterInterceptor {
	
	public void destroy() {
		System.out.println("destroy interceptor!");
		super.destroy();
	}

	public void init() {
		System.out.println("init interceptor!");
		super.init();
	}

	public String doIntercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		if(user==null) {
			return Action.LOGIN;
		} else {
			return actionInvocation.invoke();
		}
	}
	
}
