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
<title>DepartmentInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">

$(function()
{
//	alert();
 	
	$("#departmentName").keyup(function()
	{
		$("#err").css("display","none");
		ajaxCheck();
		
	});
	
	
	
	$("#submitBtn").click(function()
	{
	// 1.데이터 검사
	
	
	// 1-①. 입력항목 누락여부 확인 →작성된건지...
	if($("#departmentName").val().replace(" ","")=="")
		{
		$("#err").html("입력항목 누락");
		$("#err").css("display","inline");
		return;
		}
	
	// 1-②. 입력항목 유형 확인 → 한글 완성형인지...
	if(!/^[가-힣]{1,}$/.test($("#departmentName").val()) )
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
	
	$("#departmentForm").submit();
	
	
	});
	
});


function ajaxCheck()
{
	 $.ajax(
			{
				type:"post"
				, url:"departmentajax.action"
				, data : {departmentName:$("#departmentName").val()}
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



	<!--------------------------------------------------
    #48. DepartmentInsertForm.jsp
   -부서 데이터 입력 폼 페이지
    -관리자가 접근하는 부서 데이터 입력 폼 페이지
---------------------------------------------------->

	<!-- 메뉴 영역 -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>

	<label style="text-align: left;">부서 관리 > 부서 정보 수정</label>

	<!-- 콘텐츠 영역 -->
	<div align="center">

		<div id="content" align="left">

			<form action="departmentupdate.action" method="post" id="departmentForm">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">부서번호</div>
						<input type="text" id="departmentId" name="departmentId"
							class="form-control" value="${department.departmentId }"  readonly="readonly"/>
					</div>
					
					
					<div class="input-group">
						<div class="input-group-addon">부서명</div>
						<input type="text" id="departmentName" name="departmentName"
							class="form-control" value="${department.departmentName }" />
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
								style="width: 45%;">부서 수정</button>
							<button type="button" class="btn btn-primary lg" id="listBtn"
								style="width: 45%;" onclick="location.href='departmentlist.action'">부서 리스트
								</button>
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