<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test010.jsp</title>

<link rel = "stylesheet" type="text/css" href="css/main.css">

<% 

int n=0;
String str="";

while(n<=100)
{
	n++;
	
	if(n%4 ==0)
	{
		str += String.format("%d&nbsp;&nbsp;",n);
	}
	if(n%(4*5)==0)
	{
		str += "<br>";
	}
	
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
		<p>- 1부터 100까지의 정수 중에서
		4의 배수만 출력하는 JSP 페이지를 작성한다.</p>
		
		<p>- 한 줄에 5개씩만 출력할 수 있도록 한다.</p>
		<p>- 빈 줄 바꿈은 『br』을 활용한다.</p>
		<p>-  for 반복문 활용</p>
		
		<form>
		<%=str %>
		</form>

	</div>

</body>
</html>