<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send02.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<!-- ○데이터 송수신 관련 실습 02

- 이름과 국어점수, 영어점수, 수학점수를 서버로 전송하여
(Send02.jsp)

총점 평균에 대한 결과를 받을 수 있는 JSP페이지를 구현한다.
(Receive02.jsp)

- 페이지 레이아웃
-----------------------------------------------

이름		[	]
국어점수	[	]
영어점수	[	]
수학점수	[	]

<회원가입>


----------------------------------------------

-성적처리 버튼 클릭 시
『홍길동님, 성적처리가 완료되었습니다.
 회원님의 점수는 국어:xx점 영어xx점, 수학 xx점입니다.
 총점은 xxx점, 평균은 xx.x점 입니다.』
 라는 내용을 출력하는 JSP 페이지를 작성한다.
 (Receive02.jsp)
 
 - 사용자의 최초 요청 페이지는
 http://localhost:8090/WebApp06/Send02.jsp 로 한다. -->


	<!-- 1. 사전에 동적으로 준비해야할 그 무엇이 전혀 없는 상태이므로 .html이어도 무방한 상황
 - 사용자 요청페이지가 제공되는 과정에서 이보다 먼저 서버측에서 처리해야 할 업무가 있다면
 .html 형식이로는 처리할 수 없다.
  -->

	<!-- 2. 클라이언트 측에서 서버 측에 데이터 전송을 수행하기 위해 form 태그 필요
 3. 서버 측에 전송해야 할 이름과 전화번호는 form 태그 내부에 구성되어 있어야 함
 4. 전송 액션을 수행할 준비가 되어 있어야 함. -> submit -> 스크립트로 처리가능
 5. form의 action속성은 데이터를 전송하며 요청하는 페이지를 지정해야 함
   -> 생략 시 자기 자신 페이지 요청
 6. form의 method 속성은 데이터 전송 및 페이지 요청 방식 지정(get 또는 post)
 	-> 생략 시 get
   
  -->
	<div>
		<h1>데이터 송수신 관련 실습02</h1>
		<hr>
	</div>

	<form action="Receive02.jsp" method="post">
		<table>
		<tr>
			<th>이름</th>
			<td><input type="text" id= "name" name="username" class="txt"></td>
		</tr>
		
		<tr>
			<th>국어</th>
			<td><input type="text" id= "kor" name="userkor" class="txt"></td>
		</tr>
		
		<tr>
			<th>수학</th>
			<td><input type="text" id= "mat" name="usermat" class="txt"></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><input type="text" id= "eng" name="usereng" class="txt"></td>
		</tr>
		
		<tr>
		<td colspan="2"><button>전송</button> </td>
		</tr>
			
		</table>

	</form>

	</div>

</body>
</html>