<%@ page contentType="text/html; charset=UTF-8"%>

<% 
	//자바 코드 수행 영역
String str = "Hello JSP"; 

String date = String.format("%tF", java.util.Calendar.getInstance());



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<h1><%=str %></h1>
</div>


<!-- 흠 -->

<%-- 야야야야야 --%> <!-- 이건 JSP 문법의 주석이 된다. -->


<%=date %>


</body>
</html>