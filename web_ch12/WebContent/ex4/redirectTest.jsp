<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
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
<title>리다이렉트 페이지</title>
</head>
<body>
<c:redirect  url="/ex4/member5.jsp"  >
  <c:param  name="id" value="${'hong'}" />
  <c:param  name="name" value="${'홍길동'}" />
  <c:param  name="age" value="${22}" />
  <c:param  name="weight" value="${77}" />
  <c:param  name="height" value="${188}" />
</c:redirect>
</body>
</html>