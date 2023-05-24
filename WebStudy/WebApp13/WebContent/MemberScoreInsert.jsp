<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");


	//이전 페이지(MemberScoreInsertForm.jsp)로부터 수신
	
	//kor, eng, mat + sid
	
	String sid = request.getParameter("sid");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");
	
	
	MemberScoreDAO dao = new MemberScoreDAO();
	
	try
	{
		dao.connection();
		
		//add는 dto를 매개변수로 받음
		MemberScoreDTO score = new MemberScoreDTO();
		
		score.setSid(sid);
		score.setKor(Integer.parseInt(kor));
		score.setEng(Integer.parseInt(eng));
		score.setMat(Integer.parseInt(mat));
		
		//dto 채우고 add로 넘겨 -> db에 저장 
		dao.add(score);
		
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
	
	//클라이언트에게 MemberScoreSelect 를 요청할 수 있게 안내
	response.sendRedirect("MemberScoreSelect.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

</body>
</html>