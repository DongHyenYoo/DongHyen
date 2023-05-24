<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
/*
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("userName");
String id = request.getParameter("userId");
String tel = request.getParameter("userTel");
String sex = request.getParameter("sex");
String password = request.getParameter("userPwd");
String loc = request.getParameter("location");
String[] sub = request.getParameterValues("Sub");

//String subStr = Arrays.toString(sub);
String subStr = String.join(" ", sub);

//subStr = sub.toString();
*/
%>

</head>
<body>

 <!-- 
        --회원 가입 버튼 클릭 시
           『아이디 : superman
             패스워드 : 1234
             이름 : 홍길동
             전화번호 : 010-1111-1111
             
             성별 : 여성
             지역 : 서울
             수강과목 : 오라클중급』
        이라는 내용을 출력하는 JSP페이지를 작성한다
        (Receive04.jsp)

        
      - 사용자의 최초 요청 주소는
        『http://localhost:8090/WebApp06/Send04.jsp』로 한다. -->
<div>

<h2>회원가입 완료</h2>
<%-- 
아이디 : <%=id %><br><br>
패스워드 : <%=password %><br><br>
전화번호 : <%=tel %><br><br>
성별 : <%=sex %><br><br>
지역 : <%=loc %><br><br>
수강과목 : <%=subStr %><br>
</div>
 --%>



</body>
</html>