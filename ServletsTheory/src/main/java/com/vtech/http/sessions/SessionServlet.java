package com.vtech.http.sessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionservlet")
public class SessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. Creating or Retriving the session object
		HttpSession session = req.getSession();
//		or
		HttpSession session1= req.getSession(true); //not created, because its alredy there
		
		//2.Storing data in the session object
		session.setAttribute("name", "Vtech");
		session.setAttribute("course", "JFS");
		session1.setAttribute("name", "Vtech Integrated Solution"); // not applied because this(session1) session object not created
		
		
		//3. Retriving data from the session
		String name = (String)session.getAttribute("name");
		String course = (String)session.getAttribute("course");
		resp.getWriter().println("Name: "+name); //Name: Vtech
		resp.getWriter().println("Course: "+course); //Course: JFS
		
		//4. Invalidating Session
		//session.invalidate();
		
		name = (String)session.getAttribute("name");
		course = (String)session.getAttribute("course");
		resp.getWriter().println("After invalidating Name: "+name); //Name: null
		resp.getWriter().println("After invalidating Course: "+course); //Course: null
		
		//5. Session Tiomeout
		session.setMaxInactiveInterval(15); //15 seconds
		
		resp.sendRedirect("sessionexample.jsp");
	}
}
