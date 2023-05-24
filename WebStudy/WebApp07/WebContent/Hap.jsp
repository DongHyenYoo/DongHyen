<%@ page contentType="text/html; charset=UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hap.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<div>
		<h1>큰주제</h1>
		<hr>
	</div>


	<div>
		<h2>Hap.jsp -> Hap_ok.jsp</h2>
		
		
		<!-- action 속성 : Hap_ok.jsp로 지정해도 되고 \Webapp07\Hap_ok.jsp 형태로 지정해도 된다. -->
		<form action="Hap_ok.jsp">
		정수 1 : <input type="text" name="su1" class="txt"><br>
		정수 1 : <input type="text" name="su2" class="txt"><br>
		
		<input type="submit" value="결과 확인" class="btn">
		
		</form>

	</div>

</body>
</html>