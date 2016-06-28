<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter( "name" ) ;
	String imgName = request.getParameter( "imgName" ) ;
%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>icon</title>
</head>
<body>
<br><br>
이름은 <%= name%>입니다. <br><br>
<img src="../image/<%= imgName%>"  />
</body>
</html>