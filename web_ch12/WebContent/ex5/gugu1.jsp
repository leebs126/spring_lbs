<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단 출력창</title>
</head>
<body>
 <c:set var="dan" value="${param.dan }" />
 
 <table border=1 width=800 align=center>
  <tr align=center bgcolor="#FFFF66"> 
    <td colspan=2><c:out value="${dan}" /> 단 출력  </td>
  </tr>

<c:forEach var="i"  begin="1" end="9" step="1"  >  
  <tr align=center> 
     <td width=400> 
       <c:out value="${dan}" /> * <c:out value="${i}" />    
  	</td>
  	<td width=400>
  	   <c:out value="${i*dan }" />
  	</td>
  </tr>

</c:forEach>
</table>
</body>
</html>