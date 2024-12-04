package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	processRequest(req, resp);
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	processRequest(req, resp);
}

protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//registeration page
	String firstname = req.getParameter("firstname");
	String lastname = req.getParameter("lastname");
	String email = req.getParameter("email");
	String password = req.getParameter("passwd");
	String Dob = req.getParameter("dob");
	String status = req.getParameter("status");
	String r= "voter";
	
	try {
		User u= new User();
		Date d= Date.valueOf(Dob);
	u.setFirstName(firstname);
	u.setLastName(lastname);
	u.setEmail(email);
	u.setPassword(password);
	u.setBirth(d);
	u.setRole(r);
	u.setStatus(0);
	
	UserDaoImpl u1 = new UserDaoImpl();
	u1.save(u);
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Login</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h2>Data saved successfully</h2>");
	
	out.println("<p><a href='index.html'>Login Again</a></p>");
	out.println("</body>");
	out.println("</html>");	
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
}
