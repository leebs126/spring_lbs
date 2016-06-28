<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("utf-8");
%> 
<HTML>
<HEAD>
</HEAD>
<BODY>
환영합니다.!!! <br>
<%
		String name = request.getParameter("userName" );
		if( name.length()==0){
		   RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");  
		   dispatch.forward(request, response);
%>
	<jsp:forward  page="login.jsp" />
<%	
	}
%>
안녕하세요   <%=  name %> 님
</BODY>
</HTML>

