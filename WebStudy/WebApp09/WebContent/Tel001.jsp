<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String result ="";
	
	try
	{
		Connection conn = DBConn.getConnection();
		if(conn != null)
			result += "데이터 베이스 연결 성공~!!!";
	}
	catch(Exception e)
	{
		result += e.toString();
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터베이스 연결 테스트 및 실습</h1>
</div>

<%= result %>

</body>
</html>