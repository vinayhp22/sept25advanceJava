package com.vtech.http.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paramservlet")
public class ParamSerlvelt extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1><b>HttpServletRequest<h1><b>");
		
		out.println("<h1>1. Request Parameters</h1>");
		out.println("<h2>HttpServletRequest parameter methods</h2>");
		
//		1. getParameter(String name) - single value for a parameter
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		
		out.println("<h3>getParameter()</h3>");
		out.println("Name: "+name + "<br>");
		out.println("Mobile: "+mobile + "<br>");
		
//		2. getParameterValues(String name) - multiple values for same parameter
		
		String[] skills = req.getParameterValues("skill");
		out.println("<h3>getParameterValues()</h3>");
		if(skills!=null) {
			out.println("Skills: "+Arrays.toString(skills));
		} else {
			out.println("No Skills selected");
		}
		
		
//		3. getParameterName() - all parameter names
		Enumeration<String> parameterNames = req.getParameterNames();
		out.println("<h3>getParameterNames()</h3>");
		while(parameterNames.hasMoreElements()) {
			String paramname = parameterNames.nextElement();
			out.println("Parameter Name: "+paramname +"<br>");
		}
		
//		4. getParameterMap() - all parameters along values
		Map<String, String[]> paramMap = req.getParameterMap();
		out.println("<h3>getParameterMap()</h3>");
		for(Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			out.println(entry.getKey()+" = "+Arrays.toString(entry.getValue()));
		}


	}
}
//
//HttpServletRequest
//Data send by the client(form data, query strings)
//Methods
//String : getParameter(String name) - single parameter
//String[] : getParameterValues(String name) - multiple values for same parameter
//Enumeration<String> : getParameterName() - all parameter names
//Map<String, String> - getParameterMap() - all parameters
