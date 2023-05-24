<%@page import="java.util.ArrayList"%>
<%@page import="com.test.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%
	// MemberInsert.jsp
	// 이전 페이지로부터 데이터 수신
	// name, tel, addr
	
	String name[] = null;
	String tel[] = null;
	String addr[] = null;
	
	for(int i = 1; i < 6; i++)
	{
		name[i] = request.getParameter("name"+i);
		tel[i]  = request.getParameter("tel"+i);
		addr[i] = request.getParameter("addr"+i);
	}

	for(int i = 1; i<6; i++)
	{
		out.println("");
	}
/* 		
	List<MemberDTO> list = new ArrayList<MemberDTO>();

	for(int i = 0; i < name.length; i++)
	{
		MemberDTO dto = new MemberDTO(name[i], tel[i], addr[i]);
		list.add(dto);
	}
	
	request.setAttribute("list", list);
 */	
%>

<%-- <jsp:forward page="MemberList.jsp"></jsp:forward> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
</head>
<body>

	<div>
	<%=name[1] %>
	<%=name[2] %>
	<%=name[3] %>
	</div>
	
</body>
</html>