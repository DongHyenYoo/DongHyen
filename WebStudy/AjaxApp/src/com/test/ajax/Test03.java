package com.test.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test03 extends HttpServlet
{

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
		
		//클라이언트로부터 들어온 데이터 n1 n2 
		
		String Strnum1 = request.getParameter("n1");
		String Strnum2 = request.getParameter("n2");
		String eq = request.getParameter("eq");
		
		int num1 = Integer.parseInt(Strnum1);
		int num2 = Integer.parseInt(Strnum2);
		
		String result="";
		
		switch (eq)
		{
		case "add" : result =  String.format("%d",num1+num2);  break;
		case "sub" : result =  String.format("%d",num1-num2); break;
		case "mul" : result =  String.format("%d",num1*num2); break;
		case "div" : result =  String.format("%.1f",num1/(float)num2); break;

		default:
			break;
		}
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Test03Ok.jsp");
		
		dispatcher.forward(request, response);
		
		
	}
	
}
