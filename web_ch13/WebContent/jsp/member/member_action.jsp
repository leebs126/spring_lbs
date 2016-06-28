<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,ch13.ex2.*"
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
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean  id="m" class="ch13.ex2.MemberBean" />
<jsp:setProperty name="m" property="*"  />
    
<%

MemberDao memDao=new MemberDao();
memDao.insertMember(m);
ArrayList list =memDao.listMember();

  request.setAttribute("memberList", list);
  request.setAttribute("pageName","memberList");
%> 

<html>
<head>
<title>member_action.jsp</title>
</head>
<body>
<jsp:forward  page="member.jsp" />
</body>
</html>