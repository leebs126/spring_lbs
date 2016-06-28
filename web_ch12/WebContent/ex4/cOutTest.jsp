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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out태그 실습하기</title>
</head>
<body>
<%
  FileReader reader=null;
  try{
	  String filePath=request.getParameter("filePath");
	  reader=new FileReader(getServletContext().getRealPath(filePath));
%>
<pre>
  JSP 코드 : <%= filePath %>
 <c:out  value="<%=reader %>" escapeXml="false" />

</pre>
<%
}catch(Exception e){
	e.printStackTrace();
	
}
%>

</body>
</html>