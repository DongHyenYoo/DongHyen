<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//forward10.jsp로부터의 데이터 result
	
	int firstNum = Integer.parseInt(request.getParameter("firstNum"));
	int secNum = Integer.parseInt(request.getParameter("secondNum"));
	
	String result = (String)request.getAttribute("result");
	
	//String str = String.format("%1$d %4$s %2$d = %3$d", firstNum,secNum,result,sign);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive10.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<%=result %>


</body>
</html>