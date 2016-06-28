<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<jsp:useBean  id="m1"  class="ch12.ex1.MemberBean" scope="page"  />
<<jsp:setProperty  name="m1"  property="name" value="이순신"/>
<jsp:useBean  id="m2"  class="java.util.ArrayList" scope="page"  />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL의 여러가지 연산자</title>
</head>
<body>
<h2>empty 연산자</h2>
<h2>
\${empty m1 } :${empty m1 } <br>
\${not empty m1 } :${not empty m1 } <br><br>

\${empty m2 } :${empty m2 } <br>
\${not empty m2} :${not empty m2 } <br><br>


\${empty "hello"} :${empty "hello" }<br>
\${empty null} :${empty null } <br>
\${empty ""} :${empty "" } <br>

</h2>
</body>
</html>