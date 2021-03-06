<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,com.spring.board.vo.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:url var="serverUrl"  value="http://localhost:8090/mytest04/board"  />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글쓰기 페이지</title>
<script type="text/javascript">
function backToList(obj){
   obj.action="${serverUrl}/listWrite.do";
   obj.submit();
}
  
</script> 
</head>

<body>
 <h1>답글쓰기</h1>
  <form name="replyForm" method="post"
    action="${serverUrl}/addReply.do">
    <table>
    <tr>
			<td align="right"> 작성자:&nbsp; </td>
			<td><input type="text" size="20" maxlength="100"  name="author"></input> </td>
		</tr>
		<tr>
			<td align="right">전자메일:&nbsp; </td>
			<td><input type="text" size="30" maxlength="200"  name="email"> </input> </td>
		</tr>
		<tr>
			<td align="right">제목:&nbsp;  </td>
			<td><input type="text" size="67"  maxlength="500" name="title"> </input></td>
		</tr>
		<tr>
			<td align="right" valign="top"><br>내용:&nbsp; </td>
			<td><textarea name="content" rows="10" cols="65" maxlength="4000"> </textarea> </td>
		</tr>
		<tr>
			<td align="right">비밀번호:&nbsp;  </td>
			<td><input type="password" size="10" maxlength="12" name="passwd"> </input> </td>
		</tr>
		<tr>
			<td align="right"> </td>
			<td>
				<input type=submit value="답글쓰기" />
				<input type=button value="목록보기"onClick="backToList(this.form)" />
				
			</td>
		</tr>
    </table>
  
  </form>
</body>
</html>