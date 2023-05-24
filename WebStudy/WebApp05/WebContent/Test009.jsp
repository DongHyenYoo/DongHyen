<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsampleJsp.jsp</title>

<link rel = "stylesheet" type="text/css" href="css/main.css">


<%

int a=0;

for(int i=1; i<=100;i++)
{
	a += i;
}

%>



</head>
<body>


	<div>
		<h1>스크립릿 / 표현식 실습</h1>
		<hr>
	</div>


	<div>
		<h2>문제 해결</h2>
		<p>1부터 100까지 정수의 합을 계산하여 출력하는 JSP 페이지를 작성한다.</p>
		<p>while 반복문을 활용한다.</p>
		<form>
		<h3>1부터 100까지의 합 : <%=a %></h3>
		</form>

	</div>

</body>
</html>