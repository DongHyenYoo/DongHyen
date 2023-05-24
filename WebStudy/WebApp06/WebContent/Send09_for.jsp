<%@ page contentType="text/html; charset=UTF-8"%>
<%
//이전페이지 (Send09.jsp) 에서 데이터 수신

//수신 데이터 : userName

request.setCharacterEncoding("UTF-8");

String userName = request.getParameter("userName");

//데이터 추가

request.setAttribute("message", "반갑습니다.");

//request 객체의 key(message)의 값 안에
/// "반갑습니다."를 value로 넣는 작업 수행



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send09_for.jsp</title>
</head>
<body>



<div>
	<h1>데이터 송수신 관련 실습</h1>
	<h2>포워드</h2>

</div>

<div>
	<p>이름 : <%=userName %></p>
	<jsp:forward page="Receive09.jsp"></jsp:forward>
	<!-- jsp문법에 의거해서 추가된 jsp action태그
	이 Receive09.jsp라는 페이지를 찾으라는 명령은 서블릿 컨테이너에게 전달된다. -->
</div>


</body>
</html>