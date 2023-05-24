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

//※리다이렉트
response.sendRedirect("Receive09.jsp");  //클라이언트에게
									//Receive09.jsp를 찾으러 다시 가라고 응답으로써 전달하겠다는것



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send09_re.jsp</title>
</head>
<body>



<div>
	<h1>데이터 송수신 관련 실습</h1>
	<h2>리다이렉트</h2>

</div>

<div>
	<p>이름 : <%=userName %></p>

</div>


</body>
</html>