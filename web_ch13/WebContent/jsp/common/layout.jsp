<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<TITLE> <tiles:insertAttribute name="title" /></TITLE>
</head>
<BODY>
<center>
<table width="80%" height="1500"  border="1" >
<tr align=center height="20%">
    <td colspan="2"  bgColor="#66cc00">
        <!-- 헤더 부분: 시작 -->
        <tiles:insertAttribute name="header"/>
        <!-- 헤더 부분: 끝 -->
    </td>
</tr>
<tr align=center height="70%" >
    <td width="80" valign="top" bgColor="#ff9900">
        <!-- 사이드 부분: 시작 -->
        <tiles:insertAttribute name="side"/>
        <!-- 사이드 부분: 끝 -->    
    </td>
    <td width="300" valign="top">
        <!-- 내용 부분: 시작 -->
        <tiles:insertAttribute name="body"/>
        <br><br><br>
        <!-- 내용 부분: 끝 -->
    </td>
</tr>
<tr align=center height="10%"  bgColor="#ccffff">
    <td colspan="2">
        <!-- 푸터 부분: 시작 -->
        <tiles:insertAttribute name="footer"/>
        <!-- 푸터 부분: 끝 -->    
    </td>
</tr>
</table>
<center>
</BODY>
</html>
        