<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberSelect.css">

<script type="text/javascript">

function memberSubmit()
{
	//alert("왜");
	
	//스크립트에서 form자체를 데려온다.
	//var memberForm = document.getElementById("memberForm");
	
	//var uName = document.getElementById("uName");
	//var nameMsg = document.getElementById("nameMsg");
	
	nameMsg.style.display = "none";
	
	if(uName.value == "")
		{
		nameMsg.style.display="inline";
		uName.focus();
		return;
		}
	
	//form을 직접 지정하여 submit 액션 수행
	memberForm.submit();

}


function memberReset()
{
	var memberForm = document.getElementById("memberForm");
	
	memberForm.reset();
	
	var nameMsg = document.getElementById("nameMsg");
	
	nameMsg.style.display = "none";
	
	var uName = document.getElementById("uName");
	
	uName.focus();
	
	
	
}

</script>

</head>
<body>

<div>
		<h1>회원 명단 관리 및 입력페이지</h1>
		<hr>
	</div>

	<div>
		 <a href="MemberSelect.jsp"><button type="button" class="btn">회원 명단 관리</button></a>
	</div>
	<br>
	
	<div>
	<!-- 회원 데이터 입력 폼 구성 -->
	
	<form action="MemberInsert.jsp" method="post" id="memberForm">
		<table class="table">
		<tr>
		<th>이름(*)</th>
		<td><input type="text" id="uName" name="uName"> </td>
		<td><span class="errMsg" id="nameMsg">이름을 입력해야 합니다.</span> </td>
		</tr>
		
		<tr>
		<th>전화번호</th>
		<td><input type="tel" id="uTel" name="uTel"></td>
		<td>
		</td>
		</tr>
		
		</table>
	
	<br>
	
	<a href="javascript:memberSubmit()"><button type="button">입력하기</button></a>
	<a href="javascript:memberReset()"><button type="button">취소하기</button></a>
	<a href="MemberSelect.jsp"><button type="button">목록으로</button></a>
	
	
	</form>
	
	</div>

</body>
</html>