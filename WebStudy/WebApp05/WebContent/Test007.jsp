<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test007.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">


<% 
/*
String str="";

for(int i=1; i<=5; i++)
{
	str += "<div>";
	str += String.format("<br><br>%d단" ,i);
	for(int j=1; j<=9; j++)
	{
		str += String.format("<br>%d * %d = %d",i,j,(i*j));
	}
	
	str +="</div>";
}
*/

StringBuffer sb = new StringBuffer();

for(int i=1; i<=5; i++)
{
	sb.append("<div>");
	sb.append(String.format("<br><br>&nbsp;&nbsp;&nbsp;%d단" ,i));
	for(int j=1; j<=9; j++)
	{
		sb.append(String.format("<br>%d * %d = %d",i,j,(i*j)));
	}
	
	sb.append("</div>");
}



%>


</head>
<body>


	<div>
		<h1>스크립릿 표현식 실습</h1>
		<hr>
	</div>


	<div>
		<h2>문제해결</h2>
		<p>스크립릿과 표현식을 이용하여 구구단 5단을 구성하여 출력하는 JSP 페이지를 작성한다.</p>

		<form>
		<%=sb.toString() %>
		</form>

	</div>

</body>
</html>