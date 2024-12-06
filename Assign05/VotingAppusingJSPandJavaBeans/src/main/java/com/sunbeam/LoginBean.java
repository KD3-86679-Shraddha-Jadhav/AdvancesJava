package com.sunbeam;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {

	 private String email;
	 private String passwd;
	private User user;
	


	public LoginBean() {
		
	}
	 

	public LoginBean(String email, String passwd) {
		
		this.email = email;
		this.passwd = passwd;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	 
	public void Login(){
		
		try (UserDao userDao = new UserDaoImpl()) {
		  User u = userDao.findByEmail(this.email);
		  if(u != null && u.getPassword().equals(this.passwd)) 
			 this.user = u;
		   else 
				 this.user = null;
		  
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
	 
	 
	}
}