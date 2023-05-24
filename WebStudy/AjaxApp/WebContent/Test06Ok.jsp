<%@ page contentType="text/html; charset=UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	response.setContentType("text/xml");
%><?xml version="1.0" encoding="UTF-8"?>
<list>
<c:forEach var = "reco" items="${list }">
	<reco>
		<searchReco>${reco.searchReco}</searchReco>
	</reco>
</c:forEach>
</list> 

<%-- 
<list>
   <c:forEach var="item" items="${list }"  >
      <item>${item.recommend }</item>
   </c:forEach>
</list> --%>