<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,ch15.ex1.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:url var="serverUrl"  value="http://localhost:8090/web_ch15/board.do"  />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글보기</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-2.2.1.min.js"></script>
<script>
 function backToList(obj){
	 obj.action="${serverUrl}";
	 obj.submit();
 }
 
 function fn_enable(obj){
	 document.getElementById("t_author").disabled=false;
	 document.getElementById("t_title").disabled=false;
	 document.getElementById("t_content").disabled=false;
	 document.getElementById("t_email").disabled=false;
	 document.getElementById("t_passwd").disabled=false;
	 
	 document.getElementById("b_author").disabled=false;
	 document.getElementById("b_title").disabled=false;
	 document.getElementById("b_content").disabled=false;
	 document.getElementById("b_email").disabled=false;
	 document.getElementById("b_passwd").disabled=false;
	 
 }
 
 function fn_modify(_msg_id,_param,obj){
		// alert(obj.value);
		 var _value=obj.value;
		 $.ajax({
				type:"post",
				async:false,  //false인 경우 동기식으로 처리한다.
				url:"${serverUrl}",
				data: {action:"modWrite",msg_id:_msg_id,param:_param,value:_value},
				success:function (data,textStatus){
					alert(data);
					
					
				},
				error:function(data,textStatus){
					alert("에러가 발생했습니다.");ㅣ
				}
			});  //end ajax	
	 }
 function fn_delete(_group_id,_msg_id,_parent_id,_imageFile){
		// alert(_group_id+","+_parent_id+","+_msg_id);
		// alert(_imageFile);
		 
		var formObj=document.createElement("form");
		var i_action = document.createElement("input");
		var i_groupId = document.createElement("input");
		var i_parentId = document.createElement("input");
		var i_msgId = document.createElement("input");
	    var i_imageFile = document.createElement("input");
		    
		    i_action.name="action";
		    i_action.value="delWrite";
		    i_groupId.name="group_id";
		    i_groupId.value=_group_id;
		    i_parentId.name="parent_id";
		    i_parentId.value=_parent_id;
		    i_msgId.name="msg_id";
		    i_msgId.value=_msg_id;
		    i_imageFile.name="imageFile";
		    i_imageFile.value=_imageFile;
		    
		    formObj.appendChild(i_action);
		    formObj.appendChild(i_groupId);
		    formObj.appendChild(i_parentId);
		    formObj.appendChild(i_msgId);
		    formObj.appendChild(i_imageFile);
		    document.body.appendChild(formObj); 
		    formObj.method="post";
		    formObj.action="${serverUrl}";
		    formObj.submit();
	 }
</script>
</head>
<body>
  <form name="frmCon" method="post"
    action="${serverUrl}?action=modWrite"
     enctype="multipart/form-data">
  <table  border=0 >
  <tr>
   <td width=150 align=center bgcolor=#FF9933>
      작성자 이름
   </td>
   <td >
    <input type=text value="${write.author }" name="t_author"  id="t_author" disabled />
   </td>
    <td>
      <input type="button" value="수정" onClick="fn_modify('${write.msg_id}','author',frmCon.t_author)" id="b_author"   disabled />
    </td>   
  </tr>
  <tr>
   <td width=150 align=center bgcolor=#FF9933>
      제목 
   </td>
   <td>
    <input type=text value="${write.title }" id="t_title" disabled />
   </td>   
    <td>
      <input type="button" value="수정" onClick="fn_modify('${write.msg_id}','title',frmCon.t_title)" id="b_title"   disabled />
    </td> 
  </tr>
  <tr>
   <td width=150 align=center bgcolor=#FF9933>
      내용
   </td>
   <td>
    <textarea rows=20 cols=60  id="t_content"  disabled />${write.content }</textarea>
   </td>  
    <td>
      <input type="button" value="수정" onClick="fn_modify('${write.msg_id}','content',frmCon.t_content)" id="b_content"   disabled />
    </td>  
  </tr>
 <tr>
   <td width=20% align=center bgcolor=#FF9933>
      전자메일
   </td>
   <td>
    <input type=text value="${write.email }" id="t_email" disabled />
   </td>  
    <td>
      <input type="button" value="수정" onClick="fn_modify('${write.msg_id}','email',frmCon.t_email)" id="b_email"   disabled />
    </td>  
  </tr>
<c:if test="${not empty write.imageFile && write.imageFile !='null' }">  
<tr>
   <td width=20% align=center bgcolor=#FF9933>
      이미지
   </td>
   <td>
    <img src="${pageContext.request.contextPath}/fileDownload.do?fileName=${write.imageFile }" 
       width="500" height="500"/>
   </td>   
  </tr>  
 </c:if>

    <tr>
   <td width=20% align=center bgcolor=#FF9933>
      비밀번호
   </td>
   <td>
     <input type=password value="${write.passwd }" id="t_passwd" name="passwd" disabled />
   </td> 
    <td>
      <input type="button" value="수정" onClick="fn_modify('${write.msg_id}','passwd',frmCon.t_passwd)" id="b_passwd"   disabled />
    </td>  
  </tr>
  <tr>
   <td width=20% align=center bgcolor=#FF9933>
      등록일자
   </td>
   <td>
    <input type=text value="<fmt:formatDate value="${msg.writeday}" />" disabled />
   </td>   
  </tr>  
  <tr >
   <td colspan=2 align=center>
    <input type=button value="수정하기" onClick="fn_enable(frmCon)">
    <input type=button value="삭제하기" onClick="fn_delete(${write.group_id},${write.msg_id},${write.parent_id},'${write.imageFile}')">
    <input type=button value="리스트로 돌아가기"  onClick="backToList(frmCon)">
   </td>
  </tr>
 </table>
 </form><br>
 <a href="${serverUrl}?action=reply.ui&group_id=${write.group_id}&parent_id=${write.msg_id }">답글쓰기</a>
</body>
</html>