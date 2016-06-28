<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.io.*,java.util.*,com.spring.ex3.member.vo.MemberBean"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>  
<c:url  var="server" value="http://localhost:8090/web_ch23/member" />
<c:if test="${message!=null }">
	<c:choose>
		<c:when test="${message=='insert' }">
		<script >
		window.onload=function(){
			alert("회원이 등록되었습니다.");
		}
		</script>
		</c:when>
		<c:when test="${message=='delete' }">
		<script >
		window.onload=function(){
			alert("회원을 삭제했습니다.");
		}
		</script>
		</c:when>
		<c:otherwise>
		<script >
		window.onload=function(){
			alert("오류가 발생했습니다.");
		}
		</script>
		</c:otherwise>
	</c:choose>
</c:if>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원 정보 목록창</title>
<script type="text/javascript">
function moveInsert() {
	document.listFrm.action ="http://localhost:8090/web_ch23/member/memberForm.do";
	document.listFrm.submit();
}
</script>
</head>

<body>
<form name="listFrm" method="post">
<table width="100%" cellpadding="2" cellspacing="2" border="1">
   <tr align="center">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%" ><b>나이</b></td>
      <td width="7%"><b>체중</b></td>
      <td width="7%" ><b>키</b></td>
      <td width="7%" ><b>삭제</b></td>
   </tr>

<c:choose>
<c:when test="${ memList==null}" >
   <tr>
    <td colspan=5>
      <b>등록된 회원이 없습니다.</b>
    </td>  
  </tr>
</c:when>  
<c:when test="${memList != null }" >
<c:forEach  var="mem" items="${memList }" >
   <tr align="center">
     <td>${mem.id }</td>
     <td>${mem.name}</td>
     <td>${mem.age}</td>     
     <td>${mem.weight}</td>     
     <td>${mem.height}</td> 
     <td><a href="${pageContext.request.contextPath}/member/delMember.do?id=${mem.id }">삭제하기</a></td>      
   </tr>
   </c:forEach>
</c:when>
</c:choose>
</table>
<br>

<input type="button" name="회원등록" value="회원등록" onClick="javascript:moveInsert();">

</form>
</body>
</html>