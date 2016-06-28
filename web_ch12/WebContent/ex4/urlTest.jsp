<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>  

<c:url var="url1"  value="/ex4/member5.jsp"  >
  <c:param  name="id" value="${'hong'}" />
  <c:param  name="name" value="${'홍길동'}" />
  <c:param  name="age" value="${22}" />
  <c:param  name="weight" value="${77}" />
  <c:param  name="height" value="${188}" />
</c:url>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cURL 태그 실습</title>
</head>
<body>
<a href='<%=request.getContextPath()%>/ex4/member4.jsp'>이동하기</a> <br><br>
<a href='${url1}'>이동하기</a>
</body>
</html>