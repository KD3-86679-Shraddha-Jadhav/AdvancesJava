package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/announce")
public class AnnouncementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String announcement = req.getParameter("ann");
    	//get servlet context (application) obj and store announ in it
    	ServletContext ctx = this.getServletContext();
    	ctx.setAttribute("announcement", announcement);
    	//go to result
    	resp.sendRedirect("result");
  
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req,resp);
    }
}
