package com.vtech.http.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerservlet")
public class HeaderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>2. Request Headers</h1>");
		out.println("<p>Metadata send by the client, like browser type, cookies, languages etc </p> <br>");

//		1. getHeader(String)
		out.println("<h2>1. getHeader(String)</h2>");

		String userAgent = req.getHeader("user-agent");
		String acceptlanguage = req.getHeader("accept-language");
		
		out.println("<p> User Agent: "+userAgent+"</p> <br>");
		out.println("<p> Accept Lanaguage: "+acceptlanguage+"</p> <br>");
		
//		2. getHeaderNames()
		out.println("<h2>2. getHeaderNames()</h2>");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headername = headerNames.nextElement();
			out.println("Header Name: "+headername +"<br>");
		}
		
		
		out.println("<h1>3. Request Attributes</h1>");
		out.println("<h2>1. setAttribute(String, Object)</h2>");
		

		req.setAttribute("message", "Request Attribute setted!!!");
//		RequestDispatcher  rd = req.getRequestDispatcher("welcome.jsp");
//		rd.forward(req, resp);
		
		out.println("<h2>2. getAttribute(String)</h2>");
		Object messageObj = req.getAttribute("message");
		String msg = (String) messageObj;
		out.println("<p>Message from request attribute: "+msg+"</p>");
		
		out.println("<h2>3. removeAttribute(String)</h2>");
		req.removeAttribute("message");
		Object messageObj1 = req.getAttribute("message");
		String msg1 = (String) messageObj1;
		out.println("<p>You can see message is remove from request attribute: "+msg1+"</p>");
		
		
		out.println("<h1>4. Request Metadata</h1>");
		out.println("<h2>1. getRemoteAddr() - it returns client's IP address</h2>");
		String IpAddress = req.getRemoteAddr();
		out.println("<p>Ip address of the client: "+IpAddress+"</p>");
		
		out.println("<h2>2. getMethod() - it returns http methods</h2>");
		String httpMethod = req.getMethod();
		out.println("<p>Http method: "+httpMethod+"</p>");
		
		out.println("<h2>3. getRequestURI() - it returns URL path</h2>");
		String uri = req.getRequestURI();
		out.println("<p>URL path: "+uri+"</p>");


		
		
	}
}
