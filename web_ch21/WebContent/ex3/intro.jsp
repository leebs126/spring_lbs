<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, com.spring.ex1.*"
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
<title>회원 검색</title>
</head>
<body>
<h1>회원 검색 </h1>
<form name="frm" method="post"  action="${pageContext.request.contextPath}/member.do?action=searchMember" >
  이름 : <input  type=text name="name" ><br>
  나이 : <input   type=text name="age"><br>
  <input type=submit value="검색"  > 
  
</form>
</body>
</html>