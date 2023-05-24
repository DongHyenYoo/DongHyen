<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page buffer="8kb" autoFlush="true" %>
<%-- <%@ page buffer="1kb" autoFlush="false" %> 
<%@ page buffer="10kb" autoFlush="false" %>
이때 JSP 버퍼 오버플로우에러발생 
buffer는  서블릿컨테이너에게 jsp를 만들어 던지면 서블릿컨테이너는 우리가 작성한것을
하나하나 옮겨적을때 buffer에 담아 빈도화지에 옮겨적는(flush하는걸 )반복함
  --%>
<%
	
	request.setCharacterEncoding("UTF-8");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsampleJsp.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<div>
		<h1>page 디렉티브 추가 관찰</h1>
		<hr>
	</div>


	<div>
		<h2>buffer 및 autoFlush 속성</h2>
		
		<h3>반복문 구성</h3>
		
		<%
		
		for(int i=1; i<=1000;i++)
		{
		%>
		
		1234
		
		<%
		}
		
		%>
		

	</div>

</body>
</html>