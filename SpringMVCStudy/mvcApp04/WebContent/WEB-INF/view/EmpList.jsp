<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 이렇게 구성하면 JSTL c: 처럼 core의 포맷을 사용할  수 있다.  -->
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/mainStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>


</head>
<body>

<!--------------------------------------------------
    #33. EmpList.jsp
   -직원 리스트 출력 페이지
    -관리자가 접근하는 직원 리스트 출력 페이지
    (일반 직원이 접근하는 직원 리스트 출력 페이지는 EmpList.jsp 로 구성할 예정)
---------------------------------------------------->

<div>
	<!--메뉴 영역  -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	
	<!--콘텐츠 영역  -->
	<div id="content">
	
		<h1>[직원 정보] > [직원 리스트]</h1>
		<hr>
	<div>
	</div>
	<br><br>
	
	
	  <!--------------------------------------------------------
       EMPLOYEEID    NAME SSN BIRTHDAY LUNAR  LUNARNAME   TELEPHONE 
       DEPARTMENTNAME  POSITIONNAME REGIONNAME      
       ---------------------------------------------------------->
      <table id="customers" class="table">
         <tr>
            <th>번호</th>
            <th>이름</th>
            <th>주민번호</th>
            <th>양/음력</th>
            <th>전화번호</th>
            <th>지역</th>
            <th>부서</th>
            <th>직위</th>
         </tr>
  
         <c:forEach var = "employee" items="${employeeList}">
         <tr>
             <td>${employee.employeeId }</td>
             <td>${employee.name }</td>
             <td>${employee.ssn1 }-*******</td>
             <td>${employee.lunarName }</td>
             <td>${employee.telephone }</td>
             <td>${employee.regionName }</td>
             <td>${employee.departmentName }</td>
             <td>${employee.positionName }</td>
             
           
         </tr>
         
         </c:forEach>
         
         
      </table>  
	
	
	
	</div>
	
<!-- 회사 소개 및 어플리케이션 소개 영역 -->
   <div id="footer">
   </div>
	
	
</div>


</body>
</html>