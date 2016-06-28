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
<%
  //최초 브라우저로 요청 시에는 null이다.
  String mesg = request.getParameter("mesg");
  if(mesg != null){
%>
<%= mesg %>

<%
  }
%>

<form action="hello1.jsp", method="get">
Name:  <input type="text"  name="userName">
<input type="submit"  value="전송">
</form>
</BODY>
</HTML>


