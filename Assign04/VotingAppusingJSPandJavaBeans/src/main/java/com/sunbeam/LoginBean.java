package com.sunbeam;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {

	 private String email;
	 private String passwd;
	 int count;
	
	 public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public LoginBean() {
		
	}
	 

	public LoginBean(String email, String passwd) {
		
		this.email = email;
		this.passwd = passwd;
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
	 
	public void Login() {
		
		try (UserDao userDao = new UserDaoImpl()) {
		  User u = userDao.findByEmail(email);
		  if(u != null && u.getPassword().equals(passwd)) {
			  count++;
		  } else 
				  count--;
		  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	 
	}
}
