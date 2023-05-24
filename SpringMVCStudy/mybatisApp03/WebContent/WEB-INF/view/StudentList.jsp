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
<!-- 뷰포트 메타엘리먼트로 구성 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StudentList.jsp</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript">

$(function()
{
	$(".updateBtn").click(function()
	{
		$(location).attr("href","studentupdateform.action?sid="+$(this).val());

	});
	
	$(".deleteBtn").click(function()
	{
		$(location).attr("href","studentdelete.action?sid="+$(this).val());

	});
});

</script>

</head>
<body>

<div>
   <h1>성적 관리(SpringMVC + Annotation + mybatis 버전)</h1>
   <hr />
</div>

<!-- 메인 메뉴 영역 -->
<nav class="navbar navbar-default">
   <div class="container-fluid">
   
      <div class="navbar-header">
         <a class="navbar-brand" href="#">Home</a>
      </div>
      
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li class="active">
               <a href="studentlist.action">학생 관리 <span class="sr-only">(current)</span></a>
            </li>
            <li>
               <a href="gradelist.action">성적 관리</a>
            </li>
         </ul>
      </div>
      
   </div>
</nav>


<div class="container">
   <div class="panel-group">
      <div class="panel panel-default">
      
         <div class="panel-heading row">
            <span style="font-size: 17pt; font-weight: bold;" class="col-md-3">
               학생 리스트 출력
            </span>
            <span class="col-md-9">
               <a href="studentinsertform.action" role="button"
               class="btn btn-success btn-xs" id="btnAdd"
               style="vertical-align: bottom;">학생 추가</a>
            </span>
         </div>
         
         <div class="panel-body">
            전체 학생 수 <span class="badge">${count }</span> 
         </div>
         
         <div class="panel-body">
            <table class="table table-hover table-striped">
               <thead>
                  <tr class="trTitle">
                     <th>번호</th>
                     <th>이름</th>
                     <th>전화번호</th>
                     <th>성적 입력 여부</th>
                     <th>수정 및 삭제</th>
                  </tr>
               </thead>
               
               <tbody>
                 <c:forEach var="list" items="${studentList }">
                  
                  <tr>
                     <td>${list.sid }</td>
                     <td>${list.name }</td>
                     <td>${list.tel }</td>
                     <c:if test="${list.sub==0 }">
                     <td>X</td>
                     </c:if>
                     <c:if test="${list.sub==1 }">
                     <td>○</td>
                     </c:if>
                     <td>
                        <button type="button" class="btn btn-success updateBtn" value="${list.sid }" >수정</button>
                        <button type="button" class="btn btn-danger deleteBtn" value="${list.sid }">삭제</button>
                     </td>
                  </tr>
                 </c:forEach>
                 
                  
<!--                   <tr>
                     <td>1</td>
                     <td>김인교</td>
                     <td>010-1111-1111</td>
                     <td>0</td>
                     <td>
                        <button type="button" class="btn btn-success">수정</button>
                        <button type="button" class="btn btn-danger">삭제</button>
                     </td>
                  </tr>
                  <tr>
                     <td>2</td>
                     <td>유동현</td>
                     <td>010-2222-2222</td>
                     <td>1</td>
                     <td>
                        <button type="button" class="btn btn-success">수정</button>
                        <button type="button" class="btn btn-danger">삭제</button>
                     </td>
                  </tr>
                  <tr>
                     <td>3</td>
                     <td>김태민</td>
                     <td>010-3333-3333</td>
                     <td>1</td>
                     <td>
                        <button type="button" class="btn btn-success">수정</button>
                        <button type="button" class="btn btn-danger">삭제</button>
                     </td>
                  </tr>
 -->                  
                  
            </table>
         </div>
         
      </div>
   </div>
</div>

</body>
</html>
