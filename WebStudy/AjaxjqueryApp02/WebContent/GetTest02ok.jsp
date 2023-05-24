<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//String userName = request.getParameter("userName").toString(); //넘긴데이터가 꼭 문자열이라는 보장이 없음

%>
<%-- <%=userName%> 님 안녕하세요<br>반갑습니다. --%>
${param.userName}님, 안녕하세요.
<br>
반갑습니다.