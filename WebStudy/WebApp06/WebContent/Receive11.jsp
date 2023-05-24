<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//forward10.jsp로부터의 데이터 result
	
	String num1 = request.getParameter("num1");
	String num2= request.getParameter("num2");
	
	String sign = request.getParameter("sign");
	String result = request.getParameter("result");
	
	
	if(sign.equals("1"))
	{
		sign = "*";
	}
	else if(sign.equals("2"))
	{
		sign = "/";
	}
	
	else if(sign.equals("3"))
	{
		sign = "+";
	}
	
	else if(sign.equals("4"))
	{
		sign = "-";
	}
	
	
	
	String str = String.format("%1$s %4$s %2$s = %3$s", num1,num2,result,sign);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive11.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<%=str %>


</body>
</html>