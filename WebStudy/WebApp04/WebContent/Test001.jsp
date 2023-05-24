<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 페이지 디렉티브 -->

<%
	// 스크립릿 영역

String name = "최동현";

int result = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test001.jsp</title>
</head>
<body>

	<div>
		<h1>JSP 관찰하기</h1>
		<hr>
	</div>

	<%=name%>
	<%=result %>

</body>
</html>

<!-- http://localhost:8090/WebApp04/Test001.jsp
---------------------
웹서버 주소

					 ---------
					 프로젝트
					 		  -----------
					 		  사용자의 요청

이후 사용자는 서블릿에 의해 출력되어 나온다. -->

					 		  