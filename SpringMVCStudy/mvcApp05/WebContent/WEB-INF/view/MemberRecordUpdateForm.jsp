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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	
<script type="text/javascript">

	$(function()
	{
		$("#err").css("display","none");
		
		
		$("#id").keyup(function()
		{
			
			memberAjaxRequest(); //DB에 입력된 학생인지 확인
		});	
		
		
		
		$("#insertBtn").click(function()
		{
			if ($("#id").val() == "" ||
				$("#kor").val() == "" ||
				$("#eng").val() == "" || 
				$("#mat").val() == "" 
			   )
			{
				$("#err").html("입력 항목이 누락되었습니다.");
				$("#err").css("display","inline");
				return;
			}

			$("#memberForm").submit();
		});
		
	});
	
	
	function memberAjaxRequest()
	{
		$.post("memberrecordajax.action"
			  , { id : $("#id").val() }
			  , function(data)
			  {
				  $("#err").html(data).css("display", "inline");
		});
		
	};
	

</script>
</head>
<body>

	<div>
		<c:import url="MemberMenu.jsp"></c:import>
	</div>


	<h1>성적 추가 입력</h1>

	<div align="center">

		<div id="content" align="left">
			<form action="memberrecordupdate.action" method="post" id="memberForm">

				<div class="form-group">
					
					<div class="input-group">
						<div class="input-group-addon">성적번호</div>
						<input type="text" id="scoreId" name="scoreId" value="${memberRecord.scoreId }" readonly="readonly">
					</div>
					
					<div class="input-group">
						<div class="input-group-addon">아이디</div>
						<input type="text" id="id" name="id" value="${memberRecord.id }" readonly="readonly">
					</div>

		
					
					<div class="input-group">
						<div class="input-group-addon">국어</div>
						<input type="text" id="kor" name="kor" value="${memberRecord.kor }">

					</div>
					
					<div class="input-group">
						<div class="input-group-addon">영어</div>
						<input type="text" id="eng" name="eng" value="${memberRecord.eng }">

					</div>
					
					<div class="input-group">
						<div class="input-group-addon">수학</div>
						<input type="text" id="mat" name="mat" value="${memberRecord.mat }">

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