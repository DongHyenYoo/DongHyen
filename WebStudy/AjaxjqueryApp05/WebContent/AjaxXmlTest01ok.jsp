<%@ page contentType="text/html; charset=UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%
   request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();
%><%
   // AjaxXmlTest01ok.jsp
   
   String title = request.getParameter("title");
   String content = request.getParameter("content");
   
   response.setContentType("text/xml");
   
   //AJAX 객체에 이 데이터를 반환할때
   // 브라우저가 이 데이터를 XML로 인식해야 하기 때문에
   //MIME 타입을 XML로 선언
   
   
%><?xml version="1.0" encoding="UTF-8"?>
<list>
   <totalDataCount>5</totalDataCount>
   <%
   for (int i = 1; i <= 5; i++)
   {
   %>
   <comment num="<%=i %>">
      <title><%=title + i %></title>
      <content><%=content + i %></content>
   </comment>      
   <%
   }
   %>
</list>