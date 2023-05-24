<%@page import="com.sun.org.apache.bcel.internal.generic.SWITCH"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive03.jsp</title>

<%
request.setCharacterEncoding("UTF-8");

int firstNum = Integer.parseInt(request.getParameter("firstNum"));
int secNum = Integer.parseInt(request.getParameter("secNum"));

int result = 0;

String sign = request.getParameter("op");

switch(sign)
{
case "mul" : result = firstNum * secNum; break; 
case "div" : result = firstNum / secNum; break; 
case "add" : result = firstNum + secNum; break; 
case "sub" : result = firstNum - secNum; break; 
default :  break;


}

%>

</head>
<body>

<div>
입력한 연산결과는 <%=result %>

</div>

</body>
</html>