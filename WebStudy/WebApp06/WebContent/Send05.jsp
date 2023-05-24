<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send05.jsp</title>

<script type="text/javascript">

//매개변수로 전달받은 obj 변수에는  form 객체가 저장되어 있다.
// 필요에 따라 전송하기 전에 검증 절차를 추가하는 것이 가능하며
// 이 form을 필요에 따라 submit할 수 있다.
obj.submit();
//--form의 submit()을 통해
// form 객체의 데이터를 서버로 전송하는것이 가능하다.S


</script>

</head>
<body>


	<!-- 
	○ 데이터 송수신 실습 05
	   - 구구단 결과를 출력하는 JSP 페이지를 구성한다.
	   - 원하는 단수를 입력받아 결과를 화면에 출력해주는 형태의 페이지로 구성
	   
	   - 단 submit 버튼 없이 이벤트 처리할 수 있도록한다.
	   
	   - 페이지 레이아웃
	    ----------------------------------- 
	     단 수 선택 [1단] select
	     
	     ---------------------------------
	     
	     - 원하는 단을 선택 시
	     구구단이 나올수 있도록
	     와 같은 내용을 출력하는 jsp페이지를 작성한다.
	     
	   - 사용자의 최초 요청 주소는
	     『http://localhost:8090/WebApp07/Send04.html』
	     로 한다.

 -->

<div>
 <form action="Receive05.jsp" method="post" onchange="this.submit()">
<!-- <form action="Receive05.jsp" method="post" "> -->
단 수 선택 
<!-- <select id="dan" name="dan" onchange="formChange(this.form)">  his.form = 이 객체(select) 가 포함된 form -->
<select id="dan" name="dan"">  <!-- his.form = 이 객체(select) 가 포함된 form -->
<option selected="selected">=선택=</option>
<option value="1" >1단</option>
<option value="2">2단</option>
<option value="3">3단</option>
<option value="4">4단</option>
<option value="5">5단</option>
<option value="6">6단</option>
<option value="7">7단</option>
<option value="8">8단</option>
<option value="9">9단</option>

</select>
</form>

</div>




</body>
</html>