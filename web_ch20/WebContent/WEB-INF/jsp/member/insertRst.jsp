<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url  var="server" value="http://localhost:8090/web_ch20" />

<html>
 <body >
  <jsp:forward  page="/member/listMember.do"/>
 </body>
</html>
