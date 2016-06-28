<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url  var="mailServer"  value="/mail.do"/>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일작성폼</title>
</head>
<body>
<div>
   <form action="${mailServer}" method="post">
       <table>
           <tr><th colspan="2">JSP 메일 보내기</th></tr>
           <tr><td>보내는 사람</td><td><input type="text" name="from" /></td></tr>
           <tr><td>받는 사람</td><td><input type="text" name="to" /></td></tr>
            <tr><td>참조</td><td><input type="text" name="cc" /></td></tr>
           <tr><td>제목</td><td><input type="text" name="subject" /></td></tr>
           <tr><td>내용</td><td><textarea name="content" style="width:170px; height:200px;"></textarea></td></tr>
           <tr><td colspan="2" style="text-align:right;"><input type="submit" value="전송하기"/></td></tr>
       </table>
   </form>
    </div>
</body>
</html>