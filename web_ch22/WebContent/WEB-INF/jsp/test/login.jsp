<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, com.spring.ex1.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>

<body>
<form name="userFrm" method="post" action="loginAction.do">

<table width="400" border=0>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userId" size="10"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="userName" size="10"></td>
	</tr>

</table>
<br>
   <input type="submit" value="로그인"  />
</form>
</html>