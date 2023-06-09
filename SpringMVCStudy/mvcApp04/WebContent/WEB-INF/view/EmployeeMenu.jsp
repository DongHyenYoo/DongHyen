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
<title>EmployeeMenu.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/mainStyle.css">
<style type="text/css">

   .btn-group{width: 100%;}
   .menubtn {width: 20%; font-weight: bold;}
</style>


</head>
<body>

<!--------------------------------------------------
    #13. EmployeeMenu.jsp
   -메인 메뉴 페이지 구성
    -로그아웃 기능(버튼) 추가 구성
---------------------------------------------------->

<%-- <span>${sessionScope.admin==null ? "normal" : "admin" }</span> --%> <!-- sessionScope의 admin값이 null인지 아닌지 -->

<%-- 
<div class="btn-group" role="group">
   <a href="employeelist.action" role="button" class="menubtn btn btn-success btn-lg">${session.Scope.admin==null ? "직원 조회" : "직원 관리" }</a>
   <a href="regionlist.action" role="button" class="menubtn btn btn-success btn-lg">${session.Scope.admin==null ? "지역 조회" : "지역 관리" }</a>
   <a href="department.action" role="button" class="menubtn btn btn-success btn-lg">${session.Scope.admin==null ? "부서 조회" : "부서 관리" }</a>
   <a href="position.action" role="button" class="menubtn btn btn-success btn-lg">${session.Scope.admin==null ? "직위 조회" : "직위 관리" }</a>
   
   <a href="logout.action" class="menubtn btn btn-success btn-lg">로그 아웃</a>
   
</div> --%>


<%--<div class="btn-group" role="group">
<c:choose>
      <c:when test="${sessionScope.admin==null}">
         <a href =" employeelist.action" role="button" class="menubtn btn btn-success btn-lg" >직원 정보</a>
      </c:when>
      <c:otherwise>
         <a href =" emplist.action" role="button" class="menubtn btn btn-success btn-lg" >직원 관리</a>
         
      </c:otherwise>
   </c:choose>
   <c:choose>
      <c:when test="${sessionScope.admin==null}">
         <a href =" posotionlist.action" role="button" class="menubtn btn btn-success btn-lg" >지역 정보</a>
      </c:when>
      <c:otherwise>
         <a href =" poslist.action" role="button" class="menubtn btn btn-success btn-lg" >지역 관리</a>
         
      </c:otherwise>
   </c:choose>
   <c:choose>
      <c:when test="${sessionScope.admin==null}">
         <a href =" departmentlist.action" role="button" class="menubtn btn btn-success btn-lg" >부서 정보</a>
      </c:when>
      <c:otherwise>
         <a href =" deptlist.action" role="button" class="menubtn btn btn-success btn-lg" >부서 관리</a>
         
      </c:otherwise>
   </c:choose>
   <c:choose>
      <c:when test="${sessionScope.admin==null}">
         <a href =" regionlist.action" role="button" class="menubtn btn btn-success btn-lg" >직위 정보</a>
      </c:when>
      <c:otherwise>
         <a href =" reglist.action" role="button" class="menubtn btn btn-success btn-lg" >직위 관리</a>
         
      </c:otherwise>
   </c:choose>
    <a href="logout.action" class="menubtn btn btn-success btn-lg">로그 아웃</a>
</div>  --%>


<c:choose>
   <c:when test = "${sessionScope.admin == null }">
      <div class="btn-group" role="group">
         <a href="emplist.action" role="button" class="menubtn btn btn-success btn-lg">직원 정보</a>
         <a href="reglist.action" role="button" class="menubtn btn btn-success btn-lg">지역 정보</a>
         <a href="deplist.action" role="button" class="menubtn btn btn-success btn-lg">부서 정보</a>
         <a href="poslist.action" role="button" class="menubtn btn btn-success btn-lg">직위 정보</a>
         
         <a href="logout.action" class="menubtn btn btn-success btn-lg">로그 아웃</a>
      </div>
   </c:when>
   <c:otherwise>
      <div class="btn-group" role="group">
         <a href="employeelist.action" role="button" class="menubtn btn btn-success btn-lg">직원 관리</a>
         <a href="regionlist.action" role="button" class="menubtn btn btn-success btn-lg">지역 관리</a>
         <a href="departmentlist.action" role="button" class="menubtn btn btn-success btn-lg">부서 관리</a>
         <a href="positionlist.action" role="button" class="menubtn btn btn-success btn-lg">직위 관리</a>
         
         <a href="logout.action" class="menubtn btn btn-success btn-lg">로그 아웃</a>
      </div>
   </c:otherwise>
</c:choose>

</body>
</html>