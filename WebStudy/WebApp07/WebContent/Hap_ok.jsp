<%@ page contentType="text/html; charset=UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); 
	
	//이전 페이지(Hap.jsp)로부터 데이터 수신
	// su1,su2
	
	//※request : JSP 내장 객체 (-> Servlet구성 -> HttpServletRequest)
	
	//※ 인코딩 방식 request 접근 후 바로(처음에) 지정해 주어야
	//파라미터에 접근해서 데이터를 꺼내기 전에 지정해 주어야한다.
	//한글 데이터를 깨뜨리지 않고 수신하여 처리할 수 있다.
	
	//※ request로 부터 getparameter로 수신한 데이터는 String 형태로 반환
	
	String s1 = request.getParameter("su1");
	String s2 = request.getParameter("su2");
	int sum = 0;
	
	try
	{
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		
		
		
	}
	catch(Exception e)
	{
		//예외 발생시
		//사용자가 특정페이지를 다시 요청할 수 있게 안내
		response.sendRedirect("Error.jsp");// 이렇게 에러처리가 가능하다.
		
		//예외 발생시..
		//클라이언트의 브러우저 화면에 출력되지 않고
		//서버의 콘솔창에 오류메세지가 나오도록구성
		 System.out.println(e.toString());
		
		  //예외 발생 시
	      //해당 내용을 서버 log 기록으로 남기는 처리
	      getServletContext().log("오류 : " + e.toString());

		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hap_ok.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<div>
		<h1>큰주제</h1>
		<hr>
	</div>


	<div>
		<h2><%=sum %></h2>
		<!-- 이전페이지 로부터 넘어온 데이터의 정수1 정수2 항복에
		정수형태의 숫자가 아닌 변환이 불가능한 문자가 빈 공백을 입력했을경우
		or 값이 누락되었을 경우에도
		결과 확인 버튼 클릭시
		클아이언트의 화면 처리 결과를
		try _ catch 블럭에 의해
		항상 0으로 출력되는걸 확인할수있음
		<hr> -->

		<form></form>

	</div>

</body>
</html>