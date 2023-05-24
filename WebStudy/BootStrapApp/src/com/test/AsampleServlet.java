package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsampleServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	/* 사용자 요청이 GET 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되는 메소드 */
		
		doGetPost(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*사용자 요청이 POST 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되는 메소드*/
		doGetPost(request, response);
		
	}
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*사용자 요청이 GET or POST 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되게 구성한 사용자 정의 메소드 */
		
		
		
	}
	
}
