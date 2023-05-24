<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive02.jsp</title>

<%

//한글 처리를 위한 인코딩 방식 지정(한글 깨짐 방지)
//전송한 방식 그대로 인코딩해야한다.
//그리고 꺼내기전에 인코딩방식을 정해야된다.
request.setCharacterEncoding("UTF-8");


String name= request.getParameter("username");
//Send02.jsp에서 request객체에 전송할 데이터를 한번에 담아 보내므로
//데이터에 따라 인코딩 방식을 설정해서 꺼내야한다.

int kor = Integer.parseInt(request.getParameter("userkor"));
int eng = Integer.parseInt(request.getParameter("usereng"));
int mat = Integer.parseInt(request.getParameter("usermat"));


int tot = kor + eng + mat;

double avg = tot/3.0;
 
%>

</head>
<body>

<%=name %>님, 성적처리가 완료되었습니다.
 회원님의 점수는 국어:<%=kor %>점 영어<%=eng %>점, 수학 <%=mat %>점입니다.
  총점은 <%=tot %>점, 평균은 <%=String.format("%.1f",avg) %>점 입니다. 

</body>
</html>