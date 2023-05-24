/*=====================

 	Test005.java
 	- Servlet 관련 실습
 
 */

// 현재... 자바 기본 클래스 Test005
// 이를... 서블릿으로 구성하는 ㅂ방법

//HttpServlet 을 상속받는 클래스로 설계 -> Servlet


package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test005 extends HttpServlet  //HttpServlet 는 추상클래스긴하지만 전부 오버라이딩했기에 오버라이딩 하지 않아도된다.
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//get 방식의 요청에 대해 호출되어 실행되는 메소드
		doGetPost(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//post 방식의 요청에 대해서 호출되어 실행되는 메소드
		doGetPost(request, response);
	
	}  
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//get 방식의 요청이든 post 방식의 요청이던
		//모두 처리할 수 있는 사용자 정의 메소드
		
		
		//이전 페이지(Test005.jsp)로부터 데이터 수신 userId/userPwd
		String userId = request.getParameter("userId"); //Test005.jsp에서의 input의 name
		String userPwd = request.getParameter("userPwd");
		
		response.setContentType("text/html; charset=UTF-8");
		
		String str = "아이디 : " + userId + ", 패스워드 : " + userPwd;
		
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		
		out.print("<head>");
		out.print("<title>");
		out.print("Test005.java");
		out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		out.print("<div>");
		out.print("<h1>");
		out.print("서블릿 관련 실습");
		out.print("</h1>");
		out.print("<hr>");
		out.print("</div>");

		out.print("<div>");
		out.print("<h2>");
		out.print("HttpServlet 클래스를 활용한 서블릿 테스트");
		out.print("</h2>");
		
		out.print("<p>");
		out.print(str);
		out.print("</p>");
		
		out.print("</div>");
		
		out.print("</body>");
		
		out.print("</html>");
	}  
	/*
	 * 1. 여기서 우리가 지금 할 처리는, JSP파일에서 데이터를 넘기는 것 
	 * 2. 지금 우리가 만든 Test005.java 파일은 서블릿이니까
	 * jsp에서 서블릿컨테이너로 넘겨서 찍어줄거임... 
	 * 3. 그러려면 web.xml에서 servlet 정보를 등록시켜주고 , (
	 * <servlet> <servlet-name>test005</servlet-name>
	 * <servlet-class>com.test.Test005</servlet-class> </servlet>) (
	 * <servlet-mapping> <servlet-name>test005</servlet-name>
	 * <url-pattern>/test005</url-pattern> </servlet-mapping>) 메핑 시켜줌
	 *  4. 그러고,
	 * Test005.jsp파일에서 action에 우리가 만나게 해줄 url추가해줌 <form
	 * action="http://localhost:8090/WebApp04/test005" method="get">
	 */
	

}
