/**
 * 
 */
package com.lott_sys.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.lott_sys.dao.UsersDAO;
import com.lott_sys.vo.Users;

/**
 * @author caozx10172
 *
 */
public class UsersAction implements ServletRequestAware{

	private UsersDAO usersdao;
	private Users user;
	private HttpSession session;
	private HttpServletRequest request;
	
	public String regist(){
		user = new Users();
		user.setUserName("aa");
		user.setUserPwd("bb");
		
		usersdao.save(user);
		return "success";
	}
	
	public String login(){
		String result = "login";
		Users u = (Users)usersdao.findByUserName(user.getUserName()).get(0);
		if(u.getUserPwd() == user.getUserPwd()){
			result = "success";
		}
		return result;
	}
	
	public UsersDAO getUsersdao() {
		return usersdao;
	}

	public void setUsersdao(UsersDAO usersdao) {
		this.usersdao = usersdao;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();
	}

	
}
