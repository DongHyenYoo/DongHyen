<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 

	//MemberInsert.jsp
	//데이터에 입력 전담 처리 페이지
	
	//이전페이지로부터의 데이터 수신 (MemberList.jsp)

	request.setCharacterEncoding("UTF-8");


	String userName = request.getParameter("userName");
	
	String userTel =  request.getParameter("userTel");
	
	MemberDAO dao = null;
	
	try
	{
		dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setName(userName);
		
		dto.setTel(userTel);
		
		int result = dao.add(dto);
		
		//아니면 dao.add(dto); 도 가능
	/* 	if(result>1)
		{
			
		}
		else
		{
			
		}
		 */
		
	}catch(Exception e)
	{
	   System.out.println(e.toString());
		
	}
	finally
	{
		try
		{
			dao.close();
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	
	response.sendRedirect("MemberList.jsp");
	

%>