<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<META name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<body>
<c:choose> 
 <c:when test="${pageName==null }">
<tiles:insertDefinition name="memberForm" />
</c:when>

 <c:when test="${pageName=='memberList' }">
<tiles:insertDefinition name="memberList" />
</c:when>

</c:choose>
</body>
</html>
