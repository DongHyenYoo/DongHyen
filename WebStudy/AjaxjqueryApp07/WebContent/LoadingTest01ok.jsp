<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//LoadingTest01ok.jsp
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	try
	{
		//로딩이 완료되는데 걸리는 시간 강제지연
		Thread.sleep(5000); //5초의 지연을 강제한다.
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
	
	
%>

이름 : <%=name%>
<br>
내용 : <%=content%>
<br>