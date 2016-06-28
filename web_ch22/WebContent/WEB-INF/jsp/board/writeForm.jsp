<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,com.spring.ex4.board.vo.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:url var="serverUrl"  value="http://localhost:8090/web_ch22/board"  />
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-2.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
  function readURL(input) {
      if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function (e) {
              $('#preview').attr('src', e.target.result);
          }
          reader.readAsDataURL(input.files[0]);
      }
  }  
  
function backToList(obj){
   obj.action="${serverUrl}/listWrite.do";
   obj.submit();
}
  
</script>    
<title>새글 쓰기 창</title>
</head>

<body>
<h1>새글 쓰기</h1>
  <form name="writeForm" method="post" 
                          action="${serverUrl}/addWrite.do"
                          enctype="multipart/form-data">
    <table border=0>
    <tr>
			<td align="right"> 작성자:</td>
			<td colspan=2><input type="text" size="20" maxlength="100"  name="author" /> </td>
		</tr>
		<tr>
			<td align="right">전자메일:</td>
			<td colspan=2><input type="text" size="30" maxlength="200"  name="email" /></td>
		</tr>
		<tr>
			<td align="right">제목: </td>
			<td colspan=2><input type="text" size="67"  maxlength="500" name="title" /></td>
		</tr>
		<tr>
			<td align="right" valign="top"><br>내용: </td>
			<td colspan=2><textarea name="content" rows="10" cols="65" maxlength="4000"></textarea> </td>
		</tr>
		<tr>
			<td align="right">비밀번호:  </td>
			<td colspan=2> <input type="password" size="10" maxlength="12" name="passwd" /></td>
		</tr>
         <tr>
			<td align="right">이미지파일 첨부:  </td>
			<td> <input type="file" name="imageFile"  onchange="readURL(this);" /></td>
            <td><img  id="preview" src="#"   width=200 height=200/></td>
		</tr>
		<tr>
			<td align="right"> </td>
			<td colspan=2>
				<input type=submit value="쓰기" />
				<input type=button value="목록보기"onClick="backToList(this.form)" />
				
			</td>
		</tr>
    </table>
  </form>
</body>
</html>