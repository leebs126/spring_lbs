<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
  request.setCharacterEncoding("UTF-8");
%>  

<html>
<body>
<table align="center" border=1 >
   <tr align="center">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%" ><b>나이</b></td>
      <td width="7%"><b>체중</b></td>
      <td width="7%" ><b>키</b></td>
   </tr>
<c:choose> 
   <c:when test="${empty param.name}">
	   <tr align="center">
	      <td colspan=5 > 이름을 입력하세요!!</td>
	   </tr>
   </c:when>
   <c:otherwise >
	   <tr align="center">
	      <td> <c:out value="${param.id}"  escapeXml="true" /></td>
	      <td> <c:out value="${param.name}"  escapeXml="true"  /></td>
	      <td> <c:out value="${param.age}"   escapeXml="true"/></td>
	      <td> <c:out value="${param.weight}" escapeXml="true"  /></td>
	      <td> <c:out value="${param.height}" escapeXml="true"/></td>
	   </tr>
   </c:otherwise>
</c:choose>   
</table>
</body>
</html>


