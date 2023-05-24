<%@page import="com.test.ScoreDAO"%>
<%@page import="com.test.ScoreDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

//list에서 온값 받아오기
//이름, 국어점수, 영어, 수학
String name = request.getParameter("userName");
int kor = Integer.parseInt(request.getParameter("userKor"));
int eng = Integer.parseInt(request.getParameter("userEng"));
int mat = Integer.parseInt(request.getParameter("userMat"));

int result = 0;

ScoreDTO dto = new ScoreDTO();

dto.setName(name);
dto.setKor(kor);
dto.setEng(eng);
dto.setMat(mat);

ScoreDAO dao = new ScoreDAO();
dao.open();

result = dao.add(dto);

dao.close();

if (result > 0)
{
	response.sendRedirect("ScoreList.jsp");
	
}
else
{
	response.sendError(500, "스포트라이트는 확실하게");
}

%>
