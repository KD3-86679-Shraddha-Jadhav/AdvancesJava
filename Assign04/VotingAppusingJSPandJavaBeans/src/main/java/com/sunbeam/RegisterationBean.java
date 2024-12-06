package com.sunbeam;


import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

public class RegisterationBean {
  private String firstname;
  private String lastname;
  private String email;
  private String passwd;
  private String dob;
  private int status;
  String role="voter";
  private int count;
  
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public RegisterationBean() {
	
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
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
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}



public void Register() {
	Date d= Date.valueOf(dob);
	try (UserDao userDao = new UserDaoImpl()) {
		User u= new User(0,firstname,lastname,email,passwd,d,0,role);
		 count = userDao.save(u);
		//String msg = "User Registered" + count;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

  
}
