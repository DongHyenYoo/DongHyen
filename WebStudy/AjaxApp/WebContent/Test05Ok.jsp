<%@ page contentType="text/html; charset=UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	response.setContentType("text/xml");
	//--AJAX객체에 데이터를 반환할때
	// 브라우저가 이 데이터를 XML로 인식해야 하기 때문에
	//MIME(콘텐트타입선언) 타입을 XML로 선언
	
	//※ (수신해서 처리해야 하는) 데이터가 한 개 이상일 경우...
	// XML이나 JSON 과 같이 구조화 시킬 수 있는 데이터로 전달하는 것이
	// 이 데이터를 받아 처리하는 과정에서 용이하다.
	// 우편 번호에 대한 검색 결과는 당연히 다량의 데이터를 전송해야 하기 때문에
	// 텍스트가 아닌 XML 형태로 반환하려고 하는 것이다.
	
	/*
	[유동현] [오후 4:46] 그러니까 저 이상한 태그들은 우리가 만든 가상의 태그고
[유동현] [오후 4:46] list라는 태그는 넘겨받은 유일한 독재자라는거지?
[유동현] [오후 4:47] setAttribute로 넘겨받은 단하나 그게 루트엘리먼트가 되서
[유동현] [오후 4:47] 젤처음과 마지막에 쓰이는듯?...

	*/
	
%><?xml version = "1.0" encoding="UTF-8"?>
<list>
   <c:forEach var="item" items="${list }" >
   <item>
      <zipcode>${item.zipCode }</zipcode>
      <address>${item.address }</address>
   </item>
   </c:forEach>
</list>
