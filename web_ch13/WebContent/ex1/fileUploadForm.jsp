<%@ page language="java" contentType="text/html; charset=UTF-8"
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
 <head>
	<title>파일 업로드 폼 </title>
 </head>
<%-- <c:url var="fileUpload"  value="<%=request.getContextPath()%>/fileUpload.do"  /> --%>
 <body>
   <form action="<%=request.getContextPath()%>/fileUpload.do" method="post" enctype="multipart/form-data" >
       파일1: <input type="file" name="file1" ><br>
	 파일2: <input type="file" name="file2" > <br>
	 파라미터1: <input type="text" name="param1" > <br>
	 파라미터2: <input type="text" name="param2" > <br>
	 파라미터3: <input type="text" name="param3" > <br>
	 <input type="submit" value="전송" >
   </form>
 </body>
</html>