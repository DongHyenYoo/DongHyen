package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

public class Test2 extends HttpServlet
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
		
		//Test2.jsp(이전페이지)로부터 데이터를 수신받는다.
		//수신받을 데이터는 name, age
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		//처리 및 가공
		String str = "이름 : " + name + "님, 나이 : " + age + "세";
		
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter(); //서블릿으로 직접 응답하려면 필요함
//		
//		pw.println(str);
//		
		
		//포워딩하는 페이지에 값을 넘겨주기 위한 준비(설정)
		request.setAttribute("result", str);
		
		//포워딩 
		//리다이렉트시 받은 변수를 다시 클라이언트에게 넘겨주게됨
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Test2_result.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
}
