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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">

$(function()
{
	
	$("#regionName").keyup(function()
			{
				$("#err").css("display","none");
				ajaxCheck();
				
			});
	
	$("#updateBtn").click(function()
	{
		if($("#regionName").val().replace(" ","")=="")
			{
			$("#err").html("입력항목 누락").css("display","inline");
			return;
			}
		
		
		if(!/^[가-힣]{1,}$/.test($("#regionName").val()) )
		{
		$("#err").html("입력항목 누락");
		$("#err").css("display","inline");
		return;
		}
		
		
		if($("#err").html().trim()=="이미 사용중인 이름이 존재합니다.")
			{
			$("#err").html("사용중인 이름은 등록불가");
			$("#err").css("display","inline");
			return;
			}
		
		$("#regionForm").submit();
		
		
		
	});
	
});

function ajaxCheck()
{
	 $.ajax(
				{
					type:"post"
					, url:"regionajax.action"
					, data : {regionName:$("#regionName").val()}
					, success:function(args)
					{
						
						$("#err").css("display","inline");
						$("#err").html($.trim(args));
					}
					, error: function(e)
					{
						alert(e.responseText);
					}
					
			
		}); 
}

</script>

</head>
<body>

<!-------------------
#42. RegionUpdateForm.jsp
지역 수정 폼
수정할 지역의 정보 들고오기
---------------------->
	<!-- 메뉴 영역 -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>

	<label style="text-align: left;">지역 관리 > 지역 정보 입력</label>
	
	<!-- 콘텐츠 영역 -->
	<div align="center">
	
	<div id="content" align="left">
	
		<form action="regionupate.action" method="post" id="regionForm">
			
			<div class="form-group">
				
				<div class="input-group">
					
					<div class="input-group-addon">지역번호</div>
					<input type="text" readonly="readonly" id="regionId" name="regionId" class="form-control" value="${region.regionId }"/>
				
				</div>
				
				
				
				<div class="input-group">
					
					<div class="input-group-addon">지역명</div>
					<input type="text" id="regionName" name="regionName" class="form-control" value="${region.regionName }"/>
				
				</div>
			
			<span id="err" style="color:red; font-weight: bold; display: none;" ></span>
			<!-- 겹치는 지역이름이 있다고 알려주기  -->
			<br><br>
			
			<div class="input-group">
				<div align="center">
				
				<br><br>
				
				<button type="button" class="btn btn-primary lg" id="updateBtn" style="width: 45%;">지역 수정</button>
				<button type="button" class="btn btn-primary lg" id="listBtn"
					style="width: 48%;" onclick="location.href='regionlist.action'">지역
					리스트</button>
	
				
				</div>
			
			
			
			</div>			
			
			
			
			
			</div>
			
		
		
		</form>
	
	
	</div>
	
	
	
	</div>



</body>
</html>