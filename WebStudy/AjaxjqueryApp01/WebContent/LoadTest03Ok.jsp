<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%
	//LoadTest03Ok.jsp
	String strNum1 = request.getParameter("su1");
	int num1 = Integer.parseInt(strNum1);
	String strNum2 = request.getParameter("su2");
	int num2 = Integer.parseInt(strNum2);
	String oper = request.getParameter("oper");
	
	
	String result="";
	
	switch(oper)
	{
	case "add" : result= String.format("%d+%d = %d",num1,num2, num1+num2 ); break;
	case "sub" : result= String.format("%d-%d = %d",num1,num2,num1-num2); break;
	case "mul" : result= String.format("%d*%d = %d",num1,num2,num1*num2); break;
	case "div" : result= String.format("%d/%d = %.1f",num1,num2, num1/(double)num2); break;
	default : break;
	
	}
	
%>
<%=result %>