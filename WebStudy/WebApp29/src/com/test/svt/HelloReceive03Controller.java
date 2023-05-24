package com.test.svt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.logic.HelloReceive03Model;

public class HelloReceive03Controller extends HttpServlet
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
		request.setCharacterEncoding("UTF-8");
		
	    // Model 객체 연결 → 업무 로직 수행 → View 정보 얻어내기
		HelloReceive03Model model = new HelloReceive03Model();
		
		String viewAdvice =  model.process(request, response);
		//view에 대한 조언은 model로부터 받음
		
		//view객체 연결
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewAdvice);
		dispatcher.forward(request, response);
		
		
		
		
	}
}