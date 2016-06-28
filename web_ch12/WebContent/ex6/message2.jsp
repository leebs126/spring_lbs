<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*"
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
<title>다국어 기능2</title>
</head>
<body>
<%-- <fmt:setLocale value="en_US" /> --%>
<fmt:setLocale value="ko_KR" />
 <fmt:bundle basename="resource.button" > 
  <fmt:message key="btn.send" var="send" /><br>
  <fmt:message key="btn.cancel" var="cancel" /><br>  
  <fmt:message key="btn.finish" var="finish" />
</fmt:bundle>

<input type=button value="${send}" />
<input type=button value="${cancel}" />
<input type=button value="${finish}" />
</body>
</html>

