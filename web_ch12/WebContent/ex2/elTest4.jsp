<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL의 여러가지 연산자</title>
</head>
<body>
<h2>논리연산자</h2>
<h2>
\${(10==10) && (20!=20)}  : ${(10==10)&&(20!=20)} <br>
\${(10==10) and (20!=20)}  : ${(10==10) and (20!=20)} <br><br>

\${(10==10) || (20!=20)}  : ${(10==10)||(20!=20)} <br>
\${(10==10) or (20!=20)}  : ${(10==10) or (20!=20)} <br><br>

\${!(20==10)}  : ${!(20==10)}<br>
\${not (20==10)}  : ${not (20==10)}<br><br>

\${!(20!=10)}  : ${!(20!=10)}<br>
\${not(20!=10)}  : ${not(20!=10)}<br><br>

</h2>
</body>
</html>