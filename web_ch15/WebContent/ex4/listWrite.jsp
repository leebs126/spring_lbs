<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,ch15.ex3.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>  
<c:url var="serverUrl"  value="http://localhost:8090/web_ch15/board.do"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:choose>
<c:when test='${message=="new_write" }'>
<script>
window.onload=function(){
  alert("새글을 등록했습니다.");
}
</script>
</c:when>
<c:when test='${message=="reply_write" }'>
<script>
window.onload=function(){
  alert("답글을 등록했습니다.");
}
</script>
</c:when>
<c:when test='${message=="delete_write" }'>
<script>
 window.onload=function(){
  alert("글을 삭제했습니다.");
} 
</script>
</c:when>
</c:choose>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글목록</title>
</head>
<body>
<table align=center border=0  width=80% >
  <tr height=10 align=center>
     <td bgcolor="#336699">글번호</td>
     <td  bgcolor="#336699">제목</td>
	 <td  bgcolor="#336699">작성자</td>              
     <td  bgcolor="#336699">이메일</td>        
     <td  bgcolor="#336699">날짜</td>
  </tr>
<c:choose>
  <c:when test="${listWrite ==null }" >
    <tr>
    <td colspan=6>
      <p align=center>
      <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
       </p>
    </td>  
  </tr>
  </c:when>
  <c:when test="${listWrite !=null }" >
   <c:set  var="count" value="${1 }" />
    <c:forEach  var="write" items="${listWrite }" varStatus="msgNum" >
      <c:set var="group_id" value="${write.group_id}"  />
      <c:set var="parent_id" value="${write.parent_id}"  />
      <c:choose>
       <c:when test="${pre_group_id!=group_id }">
             <c:set  var="count" value="${1 }" />
           <tr height=10 align=center >
	        <td>${msgNum.count}</td>
	        <td align=left >
	        <font  size="4px" > 
	          <a href="${serverUrl}?action=viewWrite&msg_id=${write.msg_id}">
	             <b>${write.title }</b>
	          </a>
	          </font>
	        </td>
	        <td>${write.author }</td>
	        <td> ${write.email }</td>
	        <td><fmt:formatDate value="${write.writeday}" /></td> 
	     </tr>
       </c:when>
       <c:when test="${pre_group_id==group_id }">
	      <tr height=10 align=center >
	        <td>${msgNum.count}</td>
	        <td align=left >
	          <c:choose>
	            <c:when test="${parent_id==pre_msg_id }">
	               <c:forEach var="i" begin="0" end="${count}">
	                 &nbsp; 
	               </c:forEach>
	              <font  size="2px" >[답변]
			          <a href="${serverUrl}?action=viewWrite&msg_id=${write.msg_id}">
			             ${write.title } 
			          </a>  
		          </font>
		          <c:set  var="count" value="${count+1 }" />
	            </c:when>
	            <c:when test="${pre_parent_id!=pre_msg_id }">
	              <c:set  var="count" value="${1 }" />
	               <c:forEach var="i" begin="0" end="${count}">
	                 &nbsp; 
	               </c:forEach>
	                <font  size="2px" >[답변]
		          <a href="${serverUrl}?action=viewWrite&msg_id=${write.msg_id}">
		             ${write.title }
		          </a>  
		          </font>
		          <c:set  var="count" value="${count+1 }" />
	            </c:when>
	          </c:choose>
	          
	        </td>
	        <td>${write.author }</td>
	        <td> ${write.email }</td>
	        <td><fmt:formatDate value="${write.writeday}" /></td> 
	     </tr>
       </c:when>
      </c:choose>
     <c:set var="pre_group_id" value="${group_id}"  />
     <c:set var="pre_msg_id" value="${write.msg_id}"  />
    </c:forEach>
  </c:when>
</c:choose>
</table>
<a href="${serverUrl}?action=write.ui">글쓰기</a>
</body>
</html>