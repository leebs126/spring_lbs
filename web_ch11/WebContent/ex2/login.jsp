<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("utf-8");
%> 
<HTML>
<HEAD>
<TITLE>로그인창</TITLE>
</HEAD>
<BODY>
이름을 입력하지 않았습니다. 이름을 입력해 주세요.
<form action="hello.jsp"  method="get">
Name:  <input type="text"  name="userName">
<input type="submit"  value="전송">
</form>
</BODY>
</HTML>


