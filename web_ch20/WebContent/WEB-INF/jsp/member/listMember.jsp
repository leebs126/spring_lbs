<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.io.*,java.util.*,com.spring.member.vo.MemberVO"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>  
<c:url  var="server" value="http://localhost:8090/web_ch20" />
<c:if test="${result!=null }">
	<c:choose>
		<c:when test="${result>0 }">
		<script >
		window.onload=function(){
			alert("회원이 등록되었습니다.");
		}
		</script>
		</c:when>
		<c:otherwise>
		<script >
		window.onload=function(){
			alert("회원이 등록되지 않았습니다.");
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
	document.listFrm.action = "memberForm.do";
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
   </tr>

<c:choose>
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
<br>

<input type="button" name="회원등록" value="회원등록" onClick="javascript:moveInsert();">

</form>
</body>
</html>