<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsampleJsp.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<div>
		<h1>JSP를 이용한 데이터 송수신 추가 관찰</h1>
		<hr>
	</div>


	<div>
		<form action="Table_ok.jsp" method="post">
		
		<table class="table">
		<tr>
		<th>가로</th>
		<td><input type="text"  name="su1" class="txt"></td>
		</tr>
		
		<tr>
		<th>세로</th>
		<td><input type="text"  name="su2" class="txt"></td>
		</tr>
		
		<tr>
		<td colspan="2"><input type="submit"  class="btn" value="전송"></td>
		</tr>
		
		
		
		</table>
		
		
		</form>

	</div>

</body>
</html>