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
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">

$(function()
{
//	alert();
 	
	$("#regionName").keyup(function()
	{
		$("#err").css("display","none");
		ajaxCheck();
		
	});
	
	
	
	$("#submitBtn").click(function()
	{
	// 1.데이터 검사
	
	
	// 1-①. 입력항목 누락여부 확인 →작성된건지...
	if($("#regionName").val().replace(" ","")=="")
		{
		$("#err").html("입력항목 누락");
		$("#err").css("display","inline");
		return;
		}
	
	// 1-②. 입력항목 유형 확인 → 한글 완성형인지...
	if(!/^[가-힣]{1,}$/.test($("#regionName").val()) )
		{
		$("#err").html("입력항목 누락");
		$("#err").css("display","inline");
		return;
		}
	
	// 2.중복환인 유효성 검사 → 중복된 값임을 확인했는데 추가했는지...
	if($("#err").html().trim()=="이미 사용중인 이름이 존재합니다.")
		{
		$("#err").html("사용중인 이름은 등록할수 없습니다.").
		$("#err").css("display","inline");
		return;
		}
	//위의 모든 확인 과정 통과 했으면
	//submit 액션 처리 수행
	
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
/* 
	$.post("regionajax.action",{regionName : $("#regionName").val()}, 
	      function(data)
	      {
	         $("#err").html(data).css("display", "inline");
	      });
	   
 */	
	
}


</script>

</head>
<body>



	<!--------------------------------------------------
    #36. RegionInsertForm.jsp.jsp
   -지역 데이터 입력 폼 페이지
    -관리자가 접근하는 지역 데이터 입력 폼 페이지
---------------------------------------------------->

	<!-- 메뉴 영역 -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>

	<label style="text-align: left;">지역 관리 > 지역 정보 입력</label>

	<!-- 콘텐츠 영역 -->
	<div align="center">

		<div id="content" align="left">

			<form action="regioninsert.action" method="post" id="regionForm">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">지역명</div>
						<input type="text" id="regionName" name="regionName"
							class="form-control" placeholder="지역명" />
					</div>

					<span id="err" style="color: red; font-weight: bold; display: none;"></span>
					<!-- 이미 사용중인 이름이 존재합니다. -->
					<!-- 사용중인 이름은 등록할 수 없습니다. -->
					<!-- →입력 내용이 있을 때 확인~!!! -->
					<br />
					<br />


					<div class="input-group">
						<div align="center">
							<br />
							<br />

							<button type="button" class="btn btn-primary lg" id="submitBtn"
								style="width: 45%;">지역 추가</button>
							<button type="button" class="btn btn-primary lg" id="listBtn"
								style="width: 45%;" onclick="location.href='regionlist.action'">지역
								리스트</button>
							<br />
							<br />


						</div>
					</div>

				</div>
			</form>


		</div>
		<!-- 회사 소개 및 어플리케이션 소개 영역 -->
		<div id="footer"></div>

	</div>

</body>
</html>