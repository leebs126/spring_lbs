<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 데이터 형</title>
</head>
<body>
<h1>EL로 여러가지 데이터 출력하기</h1>
<h1>
 \${100} :${100}<br>
 \${"안녕하세요"}:${"안녕하세요"}<br>
 \${10+1}:${10+1 }<br>
 \${"10"+1} :${"10"+1 }<br>
  \${null+10 }:${null+10 }<br>
 <%-- \${"안녕"+11 }:${"안녕"+11 }<br> --%>
 <%-- \${"hello"+"world"}:${"hello"+"world"}<br> --%>
 </h1>
 

</body>
</html>