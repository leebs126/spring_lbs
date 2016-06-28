<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
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
<title>회원정보 검색창</title>
</head>
<body>
<form  method=post action="${pageContext.request.contextPath}/member.do?action=searchMember">
 <h1>회원정보 검색창</h1>
 <table >
   <tr>
     <td width=200>
     	 <p align=right >회원 아이디
     </td>
     <td width=400>
         <input   type=text name=id >
     </td>
   </tr>
   <tr>
    <td width=200><p>&nbsp; </p> </td>
    <td width=400><input type=submit value="검색하기" >
       <input type=reset value="초기화" > </td>
   </tr>
 </table>
</form>
</body>
</html>