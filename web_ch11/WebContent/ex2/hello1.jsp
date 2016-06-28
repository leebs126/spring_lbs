<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("utf-8");
%> 

<%!
 String mesg = "이름을 입력하지 않았습니다. 이름을 입력해 주세요.";
%>
<HTML>
<HEAD>
</HEAD>
<BODY>
환영합니다.!!! <br>
<%
		String name = request.getParameter("userName" );
		if( name.length() == 0 ){
%>
	<jsp:forward  page="login1.jsp" >		
		<jsp:param name="mesg" value="<%= mesg %>" />
	</jsp:forward>

<%	
	}
%>
안녕하세요 !!  <%=  name %> 님
</BODY>
</HTML>


