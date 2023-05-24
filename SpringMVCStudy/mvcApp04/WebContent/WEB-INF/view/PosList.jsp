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
<title>PosList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
</head>
<body>

<div>
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	
	<div id="content">
	
		<h1>[직위 정보] > [직위 리스트]</h1>
		<hr>
	<div>
	</div>
	<br><br>
	
	
	  <!--------------------------------------------------------
       POSITIONID POSITIONNAME
       ---------------------------------------------------------->
      <table id="customers" class="table">
         <tr>
            <th>번호</th>
            <th>직위 이름</th>
         </tr>
  
         <c:forEach var = "position" items="${posList}">
         <tr>
             <td>${position.positionId }</td>
             <td>${position.positionName }</td>
             
           
         </tr>
         
         </c:forEach>
         
         
      </table>  
	
	
	
	</div>
	
	
	
</div>


</body>
</html>