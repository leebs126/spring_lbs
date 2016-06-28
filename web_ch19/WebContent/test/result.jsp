<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<html>
<head>
</head>

<body>
<table border="0" cellpadding="3" cellspacing="1" width="80%" align="center" bgcolor="#949EA5">
	<tr>
		<td bgcolor="#FFFFFF">아이디</td>
		<td bgcolor="#FFFFFF">비밀번호</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF">${userid}</td>
		<td bgcolor="#FFFFFF">${passwd}</td>
	</tr>
</table>
</body>
</html>

