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
</head>
<body>

<div>
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	
	<div id="content">
	
		<h1>[부서 정보] > [부서 리스트]</h1>
		<hr>
	<div>
	</div>
	<br><br>
	
	
	  <!--------------------------------------------------------
       DEPARTMENTID DEPARTMENTNAME
       ---------------------------------------------------------->
      <table id="customers" class="table">
         <tr>
            <th>번호</th>
            <th>부서 이름</th>
         </tr>
  
         <c:forEach var = "department" items="${depList}">
         <tr>
             <td>${department.departmentId }</td>
             <td>${department.departmentName }</td>
             
           
         </tr>
         
         </c:forEach>
         
         
      </table>  
	
	
	
	</div>
	
	
	
</div>


</body>
</html>