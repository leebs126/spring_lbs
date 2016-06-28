<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, com.spring.ex1.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table align="center" border=1 >
	<tr align="center">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%" ><b>나이</b></td>
      <td width="7%"><b>체중</b></td>
      <td width="7%" ><b>키</b></td>
       <td width="7%" ><b>삭제</b></td>
   </tr>

<c:forEach  var="mem" items="${memList }" >
   <tr align="center">
     <td>${mem.id }</td>
     <td>${mem.name}</td>
     <td>${mem.age}</td>     
     <td>${mem.weight}</td>     
     <td>${mem.height}</td> 
     <td><a href="${pageContext.request.contextPath}/member.do?action=delMember&id=${mem.id}">삭제하기</a></td>      
   </tr>
   </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/ex2/memberForm.jsp">회원 등록하기</a>
</body>
</html>