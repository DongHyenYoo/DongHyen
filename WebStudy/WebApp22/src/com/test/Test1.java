package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
//		pw.println("<html><body><h1>name : 조현하</h1><h1>age : 12<h1></body></html");
		
//		String name = "조현하";
//		String age = "13";
//		
//		pw.println("<html>");
//		pw.println("<body>");
//		pw.println("<h1>name : " + name + "</h1>");
//		pw.println("<h1>age : " + age + "</h1>");
//		pw.println("</body>");
//		pw.println("</html>");
//		
		/* 서블릿컨테이너가 이 서블릿의 인스턴스를 생성하고 이를 기반으로 doGet or doPost메소드를 호출하게 만드는 것 */
	
		
		
		//③이제 이름과 나이를 web.xml에서 삽입하게 하고싶음
//		String name = web.xml에서 처리한 이름;
//		String age = web.xml에서 처리한 나이;
		
		// 『ServletConfig』
		//컨테이너가 서블릿을 초기화할 때
		// 서블릿 당 하나씩 ServletConfig을 생성하게 된다.
		// 『web.xml』에 <init-param>추가후
//		ServletConfig config = getServletConfig();
//		
//		String name = config.getInitParameter("name");
//		String age = config.getInitParameter("age");
//		
//		pw.println("<html>");
//		pw.println("<body>");
//		pw.println("<h1>name : " + name + "</h1>");
//		pw.println("<h1>age : " + age + "세</h1>");
//		pw.println("</body>");
//		pw.println("</html>");
		
		
		
		 // ④ 『web.xml』에 『<context-param>』 추가 후
        
	      ServletConfig config = getServletConfig();
	      
	      String name = config.getInitParameter("name");
	      String age = config.getInitParameter("age");
	      
	      ServletContext context = getServletContext();
	      
	      String type = context.getInitParameter("type");
	      
	      pw.println("<html>");
	      pw.println("<body>");
	      
	      pw.println("<h1>name : " + name + "</h1>");
	      pw.println("<h1>age : " + age + "세</h1>");

	      pw.println("<h1>type : " + type + "</h1>");
	      
	      pw.println("</body>");
	      pw.println("</html>");

		
		
		
		
		
		
	}
	
}
