<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
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
	<h1>JSP를 이용한 데이터 송수신 관찰</h1>
</div>


<div>

	<h2>gugudan.jsp -> gugudan_ok.jsp</h2>
</div>


<form action="Gugudan_ok.jsp">

<input type="text" name="dan" class="txt">

<input type="submit" value="결과확인" class="btn" style="width: 100%;">
</form>


</body>
</html>