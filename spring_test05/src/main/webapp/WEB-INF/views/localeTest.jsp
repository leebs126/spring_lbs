<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.io.*,java.util.*"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다국어 기능</title>
<script type="text/javascript">
 function changeLocale(locale){
	 alert(locale);
	 var fLoc=document.fLocale;
	 var command = document.createElement("input");
	 command.name="locale";
	 command.value=locale;
	 fLoc.appendChild(command);
	 fLoc.action = '/mytest05/test/locale.do'; 
	 fLoc.submit(); 	 
	 
 }
</script>
</head>
<body>
<h1><spring:message code="btn.send"  /></h1>
<h1><spring:message code="btn.cancel"  /></h1>

<form name=fLocale method="get" >
<input type=button value="<spring:message code="btn.send"  />" />
 
<input type=button value="<spring:message code="btn.cancel"  />" />

<input type=button value="<spring:message code="btn.finish"  />" />
<br>
<br>
<input type=button value="<spring:message code="btn.korean"   />" onClick="changeLocale('ko')" />
<input type=button value="<spring:message code="btn.english"  />"  onClick="changeLocale('en')"/>
<form>
</body>
</html>

