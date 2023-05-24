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
<style type="text/css">

.disabled 
	{
		color:grey;
	}

</style>
<script type="text/javascript">

$(function()
{
	
	$(".btnUpdate").click(function()
	{
		//수정버튼 클릭 확인
		//alert($(this).val());
		
		$(location).attr("href","departmentupdateform.action?departmentId="+$(this).val());
		
	});
	
	$(".btnDelete").click(function()
	{
		
		$(location).attr("href","departmentdelete.action?departmentId="+$(this).val());
	});
	
});


</script>
</head>
<body>

<!--
#46. DepartmentList.jsp

  -->

<div>
	
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	
	<div id="content">
	
	
		<div>
			<form action="">
			<input type="button" value="부서 추가" class="btn btn-primary" onclick="location.href='departmentinsertform.action'" />
			</form>
		</div>
		<br><br>
	
	<!--
	DEPARTMENTID DEPARTMENTNAME DELCHECK  
	 -->
	 
	 <table id="customers" class="table">
	 
	 <tr>
	 	<th>번호</th>
	 	<th style="width: 200px;">지역명</th>
	 	<th>수정</th>
	 	<th>삭제</th>
	 </tr>
	 
	 <c:forEach var="department" items="${departmentList }">
	 
	 <tr>
	 	<td>${department.departmentId }</td>
	 	<td>${department.departmentName }</td>
	 	<td><button type="button" class="btn btn-primary btnUpdate" value="${department.departmentId }">수정</button></td>
			
	 	<td> <button type="button" value="${department.departmentId }" ${department.delCheck == 0 ? "class=\"btn btn-danger btnDelete\"" : "class=\"disabled\"" } ${department.delCheck == 0 ? "":  "disabled=\"disabled\""} >삭제</button> </td>
	</tr>
		 
	 </c:forEach>
	 
	 
	 </table>
	
	
	</div>
	
</div>

  

</body>
</html>