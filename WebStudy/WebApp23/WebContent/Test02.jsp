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
<title>Test02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>


<div>
	<h1>JSTL 코어(Core) if문 실습</h1>
	<hr>
</div>

<div>
	<!-- form 태그의 action 속성 생략 -> 전송데이터 및 요청 페이지는 자기 자신 -->
	<form method="post">
		정수 : <input type="text" name="su" class="txt">
		<br><br>
		
		<button type="submit" class="btn" style="width: 120px; font-size: 16pt;">결과 확인</button>
	</form>
</div>
<br><br>

<div>

<%-- <h2>${param.su }</h2> --%>
	<%-- <c:if test=""></c:if> : JSTL Core if문 --%>
	<!-- test="" : if문에서 조건식을 지정하는 영역 -->
	<!-- param.su : EL을 이용한 폼 전송 데이터를 수신하는 부분 -->
	<c:if test="${!empty param.su }">
	
	<%-- <h2>메롱~!!!</h2> --%>
	
	<%-- JSTL Core if 문에 else는 없다. --%>
	<c:if test="${param.su % 2 == 0}">
	
		${param.su}은 짝수이다.
	</c:if>
	
	<c:if test="${param.su % 2 != 0}">
	
		${param.su}은 홀수이다.
	</c:if>
		
		
		
	
	</c:if>

</div>
<br><br>

</body>
</html>