<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
  String param1=(String)request.getAttribute("param1");    
  String param2=(String)request.getAttribute("param2");
  String param3=(String)request.getAttribute("param3");
  
  String file1=(String)request.getAttribute("file1");;
  String file2=(String)request.getAttribute("file2");;
  
  String test=(String)request.getAttribute("test");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

�Ķ���� 1 :<%=param1 %><br>
�Ķ���� 2 :<%=param2 %><br>
�Ķ���� 3 :<%=param3 %><br><br>

<%
 if(null!=file1){
%>
<img src="<%=request.getContextPath() %>/download?file=<%=file1 %>" width=500 height=500 /><br>

<br><br>
���� �ٿ�ε� :<br>

����1:<a href="<%=request.getContextPath() %>/download?file=<%=file1 %>"><%=file1 %></a>  <br>
<%
 }
%>
<%
 if(null !=file2){
%>
 
����2 :<%=file2 %><br>
<%
 }
%>
</body>
</html>
