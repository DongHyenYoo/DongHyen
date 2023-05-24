<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>include 디렉티브 관찰 및 실습</h1>
</div>

<%@ include file="Directive03.jsp" %><!--  페이지에 페이지를 내부적으로 병합되게 하는 기능 include -->
<br><br>

<div>
	<%=str %><br>
	<%=content %><br>

</div>

</body>
</html>