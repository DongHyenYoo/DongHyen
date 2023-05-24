<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test005.jsp</title>

<link rel="stylesheet" type="text/css"  href="css/main.css">

</head>
<body>

	<div>
		<h1>JSP와 Servlet 관찰하기</h1>
		<hr>
	</div>

	<div>
		<h2>HttpServlet 관련 실습</h2>
<!-- 
		from 태그의 action은 데이터전송+ (페이지요청)의 기능을 
		해야하는 대상 페이지를 등록하는 기능을 수행한다.
		(생략시 데이터 전송 및 요청 페이지는 자기 자신 페이지가 된다.) -
		
		form 태그의 method 속성에는 get 또는 post를 등록
		(생략 시 get 방식으로 처리
		이는 데이터 전송및 페이지 요청 방식에 해당한다.)
		
		-->
	<!-- 	<form action="" method="get"> 
		<form action="Test006.jsp" method="get"> 
		<form action="/WebApp04/Test005.jsp" method="get"> --> 
		<form action="/WebApp04/test005" method="get"> 
	
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId" size="10" maxlength="10"
						class="txt"></td>
				</tr>

				<tr>
					<th>패스워드</th>
					<td><input type="password" name=userPwd " size="10"
						class="txt"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="로그인" class="btn"> <input type="reset" value="다시입력"
						class="btn"></td>
				</tr>

			</table>
		</form>


	</div>

<!-- <button> </button> 이렇게 type을 생략시 type=submit으로 자동 추가됨 -->
<!-- <input type="text" name=""> name은 넘길 속성명을 의미함 -->
</body>
</html>