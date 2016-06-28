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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table align="center" border=1 >
	<tr align="center">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%" ><b>나이</b></td>
      <td width="7%"><b>체중</b></td>
      <td width="7%" ><b>키</b></td>
   </tr>
    </tr>
   <tr align="center">
     <td>${id}</td>
     <td>${name}</td>
     <td>${age}</td>     
     <td>${weight}</td>     
     <td>${height}
     </td>     
   </tr>
</table>  
</body>
</html>