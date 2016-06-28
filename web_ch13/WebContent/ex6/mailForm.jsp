<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url  var="mailServer"  value="/mail.do"/>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>메일 전송 폼</title>
</head>
<body>
<h1>메일 전송창</h1>
<form action="${mailServer }" method="post"      >
<table border="0" cellpadding="0" cellspacing="0">
<tr>
   <td>보내는사람</td>
   <td><input type="text" name="from" size="20"></td>
</tr>
<tr>
   <td>받는사람</td>
   <td><input type="text" name="to" size="20"></td>
</tr>
<tr>
   <td>참조</td>
   <td><input type="text" name="cc" size="20"></td>
</tr>
<tr>
   <td>제목</td>
   <td><input type="text" name="subject" size="40"></td>
</tr>
<tr>
   <td>내용</td>
   <td><textarea name="content" rows="10" cols="40"></textarea></td>
</tr>
<tr>
   <td colspan="2"><input type="submit" value="전송"></td>
</tr>
</table>
</form>

</body>
</html>