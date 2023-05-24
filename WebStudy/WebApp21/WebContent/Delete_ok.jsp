<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%
String pageNum = request.getParameter("pageNum");
String vNum = request.getParameter("num");
int num = Integer.parseInt(vNum);

Connection conn = DBConn.getConnection();
BoardDAO dao = new BoardDAO(conn);

dao.deleteData(num);

DBConn.close();

response.sendRedirect(cp+"/List.jsp?pageNum="+pageNum);

%>
