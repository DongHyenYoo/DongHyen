<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send03.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


<!-- ○데이터 송수신 관련 실습 03

- 두개의 정수와 선택한 연산자를 서버로 전송하여
send03.jsp

해당 연산에 대한 결과를 받을 수 있는 jsp 페이지
Receive03.jsp

작성


 -->


	<div>
				

		<form action="Receive03.jsp" method="post">
		1번째 정수입력 <input type="text" id="firnum" name="firstNum" class="txt"><br>
		2번째 정수입력 <input type="text" id="secnum" name="secNum" class="txt"><br>
		<!-- 연산자 입력 <input type="text" id="sign" name="numSign" class="txt"><br> -->
		
		<select name="op">
			<option value="add">더하기</option>
			<option value="sub">빼기</option>
			<option value="mul">곱하기</option>
			<option value="div">나누기</option>
		
		</select>
		
		
		<button>전송</button>
		
		</form>

	</div>

</body>
</html>