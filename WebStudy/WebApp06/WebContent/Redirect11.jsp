<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	int num1 = Integer.parseInt(request.getParameter("firstNum"));
	int num2 = Integer.parseInt(request.getParameter("secondNum"));
	
	String sign = request.getParameter("sign");
	
	String result ="";

    switch(sign){
	
	case "1" : result = String.format("%d",(num1+num2)); break;
	case "2" : result = String.format("%.1f",(num1/(double)num2)); break;
	case "3" : result = String.format("%d",(num1+num2)); break;
	case "4" : result = String.format("%d",(num1-num2)); break;
	default: break;
	
	}
    //response 객체의 주요 메소드중 하나인
    //sendRedirect(String location)
    //: 지정된 URL로 요청을 다시 전송한다.
    //이전의 요청(request)는 이 단계에서 소멸한다.
    
    
    response.sendRedirect("Receive11.jsp?num1="+num1+"&num2="+num2+"&result="+result+"&sign="+sign);
	
%>
