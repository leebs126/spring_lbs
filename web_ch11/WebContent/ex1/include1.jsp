<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("utf-8");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include1.jsp</title>
</head>
<body>

<h1>안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!!
<br>
<jsp:include  page="icon_image.jsp"  flush="true" >
   <jsp:param name="name"  value="홍길동"/>
   <jsp:param name="imgName"  value="icon_idea.png"/>
</jsp:include>
<br>
<h1>안녕하세요. 쇼핑몰 중심 JSP 끝부분입니다.!!!
</body>
</html>