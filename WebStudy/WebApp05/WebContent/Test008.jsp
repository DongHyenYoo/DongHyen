<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test008.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">


<%

String str="";

int money = 990;
int origin = money;
int obac, bac, osib, sib;


obac = money / 500;

money = money % 500;

bac = money / 100;

money = money % 100;

osib = money / 50;

money = money % 50;

sib = money / 10;

money = money % 10;

str += String.format("<h3>대상금액 : %d원</h3><br> " 
                    + "<h3>화폐 단위</h3><br>"
                    + "<h3>- 오백원 : %d개</h3><br>"
                    + "<h3>- 백원 : %d개</h3><br>"
                    + "<h3>- 오십원: %d개</h3><br>"
                    + "<h3>- 십원: %d개</h3><br>",origin,obac,bac,osib,sib);



%>



</head>
<body>


	<div>
		<h1>스크립릿 / 표현식 실습</h1>
		<hr>
	</div>


	<div>
		<h2>문제해결</h2>
		<p>990원을 화폐 단위로 구분하여 출력하는 JSP 페이지를 작성한다.</p>

		<form>
		<!-- <h3>대상급액 : xxx 원</h3>
		<h3>화폐 단위</h3>
		<h3>- 오백원 : xx개</h3>
		<h3>- 백원 : x개</h3>
		<h3>- 오십원 : x개</h3>
		<h3>- 십원 : x개</h3> -->
		<%-- <%=str %> --%>
		
	 <h3>대상 금액 : <%=origin %> 원</h3>
      <h3>화폐 단위</h3>
      <h4>- 오백원 : <%=obac %> 개</h4>
      <h4>- 백원   : <%=bac %> 개</h4>
      <h4>- 오십원 : <%=osib %> 개</h4>
      <h4>- 십원   : <%=sib %> 개</h4>
      
		
		</form>

	</div>

</body>
</html>