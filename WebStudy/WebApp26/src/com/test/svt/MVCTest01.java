package com.test.svt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class MVCTest01 extends HttpServlet
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
		
		
		//호출할것 : http://localhost:8090/WebApp26/mvctest1
		
		
		//1부터 100까지의 수를 객체(컬렉션)에 저장하는 과정
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i <= 100; i++)
		{
			list.add(String.valueOf(i));
			
		}
		
		//1 부터 100 까지의 수가 저장된 객체(컬렉션)를
		//뷰(View) 페이지로 넘겨주기 위한 준비
		
		request.setAttribute("list", list);
		
		//포워드~!!!
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/MVCTest01.jsp");
		dispatcher.forward(request, response);
	
	}
	
	
	

}
