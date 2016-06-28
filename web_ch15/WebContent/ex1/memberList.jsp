<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,ch15.ex1.*"
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
   </tr>

    </tr>
  
<c:choose>
<%--
 ArrayList list =request.getAttribute("memberList");
--%>
<c:when test="${ memberList==null}" >
   <tr>
    <td colspan=5>
      <b>등록된 회원이 없습니다.</b>
    </td>  
  </tr>
</c:when>  
<c:when test="${memberList != null }" >
  <c:forEach  var="mem" items="${memberList }" >
   <tr align="center">
     <td>
          ${mem.id }
     </td>
     <td>
        ${mem.name }
     </td>
     <td>
       ${mem.age}
     </td>     
     <td>
       ${mem.weight }
     </td>     
     <td>
       ${mem.height}
     </td>     
   </tr>
   </c:forEach>
</c:when>
</c:choose>
</table>  
<a href="${pageContext.request.contextPath}/mem.do?action=memberForm.ui">회원 등록하기</a>
</body>
</html>