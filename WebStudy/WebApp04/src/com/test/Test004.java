/*=========================
 Test004.java
 서블릿(Servlet) 관련 실습 
 *
 */

//현재 자바의 기본 클래스인 Test004이다
// 이를 서블릿(Servlet)으로 구성하는 방법

//GenericServlet 을 상속받는 클래스로 설계 -> Servlet



/*웹 기반 애플리케이션

1.Servlet 인터페이스
2. GenericServlet 클래스  Servlet 상속
3. HttpServlet 클래스  GenericServlet 상속

class aaa extends HttpServlet  즉 이로써 Servlet가 된다.




*/

package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test004 extends GenericServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		//오버라이드 함으로써 에러가 사라졌으므로 GenericServlet는 추상클래스고
		//이를 상속받은 Test004가 Servlet으로 동작하기 위해서는 추상메소드인 service를 오버라이드해야한다.
		
		// TODO Auto-generated method stub
		
		//서블릿컨테이너에서 service 메소드를 호출하게 하는것 
		//우리가 main을 메소드를 만들지 않는다.
		
		//client에서 request객체를 채워(즉 서버에게 요청을함) 서버에게 넘기면  request객체 안에 담겨있는 
		//client가 원하는 부분을 확인한다. 
		
		
		response.setContentType("text/html; charset=UTF-8"); //html 방식으로 UTF-8방식으로 응답할것이다.
														//서블릿이 렌더링할때 <%@ page contentType="text/html; charset=UTF-8"%>
														//이 형식으로 렌더링 해달라는것
		
		try
		{
			
			PrintWriter out = response.getWriter(); //내장객체 PrintWriter을 사용해서 아래와 같은 내용을 그린다.
												    //출력스트림 out을 이용
			
			out.print("<html>");
			
			out.print("<head>");
			out.print("<title>");
			out.print("Test004.java");
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
			out.print("GenericServlet 클래스를 이용한 서블릿 테스트");
			out.print("</h2>");
			
			out.print("<p>");
			//out.print("유동현");
			String name = "유동현"; //얘를가지고 새로 컴파일하고 새로 등록해야하므로 저장시 서버 리스타트
			out.print(name);
			
			//웹페이지에서의 소스코드는 <p>유동현</p>로 똑같이 나온다.
			// 이유 이건 서블릿이 컴파일해서 만든것이므로
			
			out.print("</p>");
			out.print("</div>");
			
			out.print("</body>");
			
			out.print("</html>");
		
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
			
			//이 java파일을 불러봤자 404에러가 난다.
			//서블릿 강의를 생각해보면 jsp파일을 서블릿에 꽃아 .java->.class로 변환되고 이 컴파일 결과가 html형태로 나오는것
			//즉 java를 불러봤자 안된다.
			
		}
		
		
		
	}
	
	

}
