<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send10.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<!-- ○포워드 / 리다이렉트에서 포워드와 관련한 중요한 실습

1. 사칙연산 수행을 위한 정수 입력 페이지를 구성한다.
2.연산자를 함께 입력받을 수 있도록 페이지 구성
send10.jsp

3. 사용자의 최초 요청 페이지
-> send10

4. 연산 전용 페이지 구성 -> 나중에는 java파일로 구성할거임 : 즉 Servlet으로 쓰겠다는것
(Forward10.jsp)
5.최종 결과 출력 페이지 구성
Receive10.jsp
 -->

<div>
<form action="" method="post">
<h1>사칙연산</h1>

첫번째 숫자 입력 : 
<input type="text" class="txt" name="firstNum"  style="width:50px;"> <br>

두번째 숫자 입력 : 
<input type="text" class="txt" name="secondNum"  style="width:50px;"> <br>

<select name="sign">
<option value="*">곱하기</option>
<option value="/">나누기</option>
<option value="+">더하기</option>
<option value="-">빼기</option>
</select>

<button type="submit" onclick="this.form.action='Forward10_01.jsp'">포워드</button>

</form>

</div>




</body>
</html>