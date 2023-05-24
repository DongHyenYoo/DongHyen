/*
 * 
 * MVCBegin
 * 
 */

package com.test.svt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCBegin  extends HttpServlet
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
		
		//서블릿 관련 코딩
		
		//변수 선언 및 데이터 구성
		String message = "ㅎㅇ MVC패턴이다.";
		
		
		//VIEW역할을 수행하는 JSP 페이지에 전달할 데이터 구성
		request.setAttribute("message", message);
		
		//제어권(제어 흐름)도 JSP(View)에 전달해야한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/MVCBegin.jsp");
		//원래 WEB-INF안에는 클라이언트가 접근할수 없으나 컨트롤러에서 이렇게 경로를 지정하면 접근할수 있다.
		
		dispatcher.forward(request, response);
		// 『javax.servlet.RequestDispathcer』 클래스는
		//현재 클라이언트의 요청을 다른 서블릿 / JSP 페이지로 전달하거나
		// 현재 서블릿 / JSP 페이지의 결과를 현재 위치에 포함시키고자
		// 할때 사용된다.
		
		
		//『RequestDispathcer』 객체는
		// 이와같은 기능을 제공하기 위해
		// 『forward()』 메소드와 『include()』 메소드를 제공하고 있으며
		// 이 두메소드는 JSP의 『<jsp:forward>』 액션태그
		//『<jsp:include>』액션 태그와 동일한 기능을 제공한다.
		// 위의 경우는 현재 요청을 『MVCBegin.jsp』로 보내고자 하는 경우이다.
		
		
		//=>웹 기본 모델2(MVC) 구조는
		// 바로 이 『RequestDispatcher 객체의 forward()메소드』를 통해 구현된다.
		
		
		
		
	}
	
}
