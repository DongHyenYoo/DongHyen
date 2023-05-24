<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="ob" class="com.test.Calc" scope="page"></jsp:useBean>
<!-- ob라는 이름으로 Calc.java 객체 생성 -->
<!-- 서블릿 컨테이너가 com.test.Calc를 보고 ob라는 이름으로 해당위치에 있는 클래스의 객체를 생성해주는것 -->
<!-- 그리고 DTO 쓸때처럼 안에 변수를 채워넣어 주는것 -->
<%-- <jsp:setProperty property="su1" name="ob"/>
<jsp:setProperty property="su2" name="ob"/>
<jsp:setProperty property="op" name="ob"/> --%>
<!-- setProperty에서 변수의 자료형에 맞게 알아서 판단해서 집어넣는다. String 이면 String int면 int -->
 <!-- 모든 property를 부르는 방법 → property="*" -->
<jsp:setProperty property="*"  name="ob"/>


<!-- *로 하면 모든 변수를 채워넣는다 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calc_ok3.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>첫 번째 방법의 처리 결과</h1>
	<hr>
</div>


<div>
	<h2><%=ob.result() %></h2>
</div>

</body>
</html>