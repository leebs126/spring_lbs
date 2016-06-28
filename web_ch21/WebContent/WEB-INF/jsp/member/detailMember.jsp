<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*,java.util.*,com.spring.ex4.member.vo.MemberBean""
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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style type="text/css">
</style>
<title>회원 상세화면</title>
<script language="javascript">
	function update() {
		document.contents.action = "edit.do?id="+${id};
		document.contents.mode.value = "E";
		document.contents.submit();
	}
	function del() {
		document.contents.action = "delete.do";
		document.contents.num.value = "${id}";
		document.contents.submit();
	}
	function list() {
		document.contents.action = "list.do";
		document.contents.submit();
	}
</script>
</head>

<body>
<form name="contents" method="post">
<input type="hidden" name="tablename" value="freeboard">
<input type="hidden" name="mode" value="">
<div style="height:30px;"></div>
<div class="peNum" >회원 정보 상세</div>
	<dl class="insertForm">
		<dt>아이디</dt>
		<dd>${member.id}</dd>
		<dt>이름</dt>
		<dd>${member.name }</dd>
		<dt>나이</dt>
		<dd>${member.age}</dd>
		<dt>키</dt>
		<dd>${member.height}</dd>
		<dt>몸무게</dt>
		<dd>${member.weight}</dd>
	</dl>
</div>
</form>
<br>
<input type="button" name="update" value="수정" onClick="javascript:update();">
<input type="button" name="delete" value="삭제" onClick="javascript:del();">
<input type="button" name="list" value="목록" onClick="javascript:list();">



</body>
</html>