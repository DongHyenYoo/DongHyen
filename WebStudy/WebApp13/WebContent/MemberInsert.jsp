<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	
	//MemberInsert.jsp
	//데이터베이스의 테이블(TBL_Member)에
	//회원 데이터 추가 액션 처리 수행
	//... 이후, 다시 리스트 페이지를 요청할 수 있도록 안내한다.
	
	//이전페이지 insertform로부터 데이터 수신
	
	//uName. uTel
	
	String uName = request.getParameter("uName");
	String uTel = request.getParameter("uTel");
	
	MemberDAO dao = new MemberDAO();
	
	try
	{
		//데이터 베이스 연결;
		dao.connection();
		
		//MemberDTO 객체 구성 -> dao의 add() 메소드 호출 위해 필요
		MemberDTO dto = new MemberDTO();
		
		dto.setName(uName);
		dto.setTel(uTel);
		
		//insert 쿼리문을 수행하는 dao의 메소드 add 호출
		
		dao.add(dto);
		
		
		
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
	
	//클라이언트가 MemberSelect.jsp페이지를 다시 요청할 수 있도록 안내하는 처리
	
	response.sendRedirect("MemberSelect.jsp");
	


%>
