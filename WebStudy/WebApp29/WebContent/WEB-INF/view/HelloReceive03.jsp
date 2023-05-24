<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloReceive03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	결과수신페이지
	<p>HelloReceive03.jsp</p>
</div>

<div>
	<ul>
	<li><b>First Name : </b> ${firstName }</li>
	<li><b>last Name : </b> ${lastName }</li>
	
	</ul>
	</div>

</body>
</html>