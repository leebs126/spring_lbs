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
<title>결과창</title>
</head>
<body>
 <h3>로그인 정보</h3>
 <h1>아이디: ${userId}</h1><br>
 <h1>이름: ${userName}</h1>
</body>
</html>