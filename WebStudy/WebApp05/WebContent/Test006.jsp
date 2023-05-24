<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test006.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

<%


/*
String str = "<ul>";

for(int i=1; i<=10;i++)
{
	str += String.format("<li>%d</li>",i);
}

str += "</ul>";
*/


StringBuffer sb = new StringBuffer();

sb.append("<ul>");

for(int i=1; i<=10; i++)
{
	sb.append(String.format("<li>%d</li>",i));
}

sb.append("</ul>");

%>

</head>
<body>


	<div>
		<h1>스크립릿 / 표현식 실습</h1>
		<hr>
	</div>


	<div>
		<h2>작은주제</h2>
		<hr>

		<form action="/Test006.jsp">
		
		<%=sb.toString() %>
		
		
		</form>

	</div>

</body>
</html>