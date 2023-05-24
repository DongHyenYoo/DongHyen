package com.test.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloReceive02 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		
		//서블릿 관련코딩
		
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String title = "결과 수신페이지";
		
		String subTitle = "HelloReceive02.java";
		
		String docType="<!DOCTYPE html>";
		
		out.print(docType+"\n");
		out.print("<html>\n");
		out.print("<head>\n");
		out.print("<title>\n");
		out.print(title+"\n");
		out.print("</title>\n");
		out.print("</head>\n");
		out.print("<body bgcolor=\"f0f0f0\">\n");
		out.print("<div>\n");
		out.print("<h1>\n");
		out.print(title+"\n");
		out.print("</h1>\n");
		out.print("<p>\n");
		out.print(subTitle+"\n");
		out.print("</p>\n");
		out.print("<hr>\n");
		out.print("</div>\n");
		
		out.print("<div>\n");
		out.print("<ul>\n");
		out.print("<li>\n");
		out.print("<b>\n");
		out.print("First Name : ");
		out.print("</b>");
		out.print(request.getParameter("firstName")+"\n");
		out.print("</li>");
		out.print("<li>");
		out.print("<b>\n");
		out.print("last Name : ");
		out.print("</b>");
		out.print(request.getParameter("lastName")+"\n");
		out.print("</li>");
		
		out.print("</ul>");
		out.print("</div");
		
		out.print("</body>\n");
		out.print("</html>\n");
	
	}
	
	
	

}
