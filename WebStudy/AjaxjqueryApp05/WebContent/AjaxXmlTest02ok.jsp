<%@ page contentType="text/html; charset=UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String hobby = request.getParameter("hobby");
	
	String count = request.getParameter("count");
	
	int num = Integer.parseInt(count);
	response.setContentType("text/xml");
	
%><?xml version="1.0" encoding="UTF-8"?>
<list>
	<%-- <count>${param.count }</count> --%>
	<%
	for(int i=1; i<=num;i++)
	{
	%>
	
	<item id="<%=i %>">
		<name>${param.name}<%=i %></name>
		<age><%=age+i %></age>
		<hobby><%=hobby+i %></hobby>
	</item>
	<%
	}
	
	%>
	
	</list>
	
