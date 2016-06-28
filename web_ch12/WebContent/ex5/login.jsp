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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>결과창</title>
</head>
<body>
<c:if test="${empty param.name  }">
  이름을 입력하세요.<br>
  <a href="login.html">로그인 창 </a>

</c:if>

<c:if test="${not empty param.name  }">  
 <h1> 환영합니다. <c:out value="${param.name }" /> 님!!!</h1>
</c:if>
</body>
</html>

