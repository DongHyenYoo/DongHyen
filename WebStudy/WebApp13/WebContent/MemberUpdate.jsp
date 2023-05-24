<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//MemberUpdate.jsp
	//이전페이지로부터(MemberUpdateForm) 데이터 수신
	//uName, uTel + sid
	
	
	String sid = request.getParameter("sid");
	String name = request.getParameter("uName");
	String tel = request.getParameter("uTel");
	
	MemberDAO dao = new MemberDAO();
	
	try
	{
		
		dao.connection();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setSid(sid);
		dto.setName(name);
		dto.setTel(tel);
		
		dao.modify(dto);
		
	}
	catch(Exception e)
	{
		
			System.out.println(e.toString());
	}
	
	finally
	{
		try
		{
			dao.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	
	//수정이 되었으니 memberSelect.jsp 페이지를 클라이언트가 다시 요청하도록한다.
	
	response.sendRedirect("MemberSelect.jsp");

%>