<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
#body {
	background-color: rgb(228, 225, 223);
}

.title {
	display: flex;
	align-items: center;
	background-color: teal;
	color: white;
}

.right-item {
	margin-left: auto;
}

.btn-primary {
	background-color: teal;
	font-size: 20px;
	font-weight: bold;
}

.btn-success {
	background-color: teal;
	font-size: 15px;
}

table {
	width: 100%
}

th, td, .updateBtn {
	text-align: center;
	font-size: 15px;
}
 #content
   {
      border: 1px solid #ccc;
      border-radius: 5px;
      width: 500px;
      padding: 15px;
      margin: 30px;
   }
   
   .input-group
   {
      margin: 10px;
   }
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">


$(function()
{
	
	$("#id").keyup(function()
	{
		memberIdAjax();
		
	});
	

	$("#insertBtn").click(function()
	{
		if ($("#id").val() == "" ||
			$("#pw").val() == "" ||
			$("#name").val() == "" || 
			$("#tel1").val() == "" || $("#tel2").val() == "" || $("#tel3").val() == "" ||
			$("#email").val() == "" 
		   )
		{
			$("#err").html("입력 항목이 누락되었습니다.");
			$("#err").css("display","inline");
			return;
		}
		
		if (!/^[a-zA-Z0-9]+$/.test($("#id").val()) )
		{
			$("#err").html("입력 항목이 잘못되었습니다.");
			$("#err").css("display", "inline");
			return;		
		}

		
		if ( $("#err").html().trim() == "이미 사용중인 아이디입니다."
			|| $("#err").html().trim() == "사용중인 아이디는 등록할 수 없습니다."
			|| $("#err").html().trim() == "입력 항목이 누락되었습니다."
			|| $("#err").html().trim() == "입력 항목이 잘못되었습니다.")
		{
			$("#err").html("사용중인 아이디는 등록할 수 없습니다.");
			$("#err").css("display", "inline");
			return;		
		}
				
		if ( $("#err").html().trim() == "이미 등록된 전화번호입니다. 아이디/비밀번호 찾기를 이용해주세요"
			|| $("#err").html().trim() == "입력 항목이 누락되었습니다."
			|| $("#err").html().trim() == "입력 항목이 잘못되었습니다.")
		{
			$("#err").html("사용중인 전화번호는 등록할 수 없습니다.");
			$("#err").css("display", "inline");
			return;		
		}
		
		$("#memberForm").submit();
	});
	
	
    $("#checkTel").click(function()
	{
		telAjax();
	});
	
	
	
});




function memberIdAjax()
{
	$.post("memberajax.action", {id:$("#id").val()}
	, function(data)
	{
		$("#err").html(data).css("display","inline");
	});
	
}

function telAjax()
{
	var tel = $("#tel1").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val()
	$.post("telajax.action",{tel:tel}, function(data)
	{
		$("#err").html(data).css("display","inline");
	});
	
}

</script>

</head>
<body>

	<div>
		<c:import url="MemberMenu.jsp"></c:import>
	</div>


	<h1>학생 추가 입력</h1>

	<div align="center">

		<div id="content" align="left">
			<form action="memberinsert.action" method="post" id="memberForm">

				<div class="form-group">

					<div class="input-group">
						<div class="input-group-addon">아이디</div>
						<input type="text" id="id" name="id" placeholder="아이디 입력">
					</div>

					<div class="input-group">
						<div class="input-group-addon">비밀번호</div>
						<input type="password" id="pw" name="pw" placeholder="****">

					</div>
					
					<div class="input-group">
						<div class="input-group-addon">이름</div>
						<input type="text" id="name" name="name">

					</div>

					<div class="input-group">
						<div class="input-group-addon">전화번호</div>
						<input type="text" id="tel1" name="tel1" placeholder="ex)010" style="width: 20%">
						- <input type="text" id="tel2" name="tel2"  style="width: 20%">
						- <input type="text" id="tel3" name="tel3"  style="width: 20%">
						<button type="button" id="checkTel">중복확인</button>
					</div>

					<div class="input-group">
						<div class="input-group-addon">이메일</div>
						<input type="text" id="email" name="email"> @ <select
							id="eAddress" name="eAddress">
							<option value="gmail.com">gmail.com</option>
							<option value="test.com">test.com</option>
							<option value="sist.com">sist.com</option>
						</select>

					</div>
					<span id="err" style="margin-left: 10px; color: red; font-size: 14px; display: none;">
						
					</span>
				
					<div class="input-group">
						<input type="button" id="insertBtn" class="insertBtn" value="입력완료" />
						<input type="button" id="listBtn" class="listBtn" value="목록으로" onclick="location.href='memberlist.action'">
					</div>



				</div>


			</form>


		</div>

	</div>





</body>
</html>