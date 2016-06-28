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
<h2>비교연산자</h2>
<h3>
\${10==10}  : ${10==10} <br>
\${10 eq 10}  : ${10 eq 10} <br><br>

\${"hello"=="hello"}  : ${"hello"=="hello"} <br>
\${"hello" eq "hello"}  : ${"hello" eq "hello"} <br><br>


\${20!=10}  : ${20!=10}<br>
\${20 ne 10}  : ${20 ne 10}<br><br>

\${"hello"!="apple"}  : ${"hello"!="apple"} <br>
\${"hello" ne "apple"}  : ${"hello" ne "apple"} <br><br>


\${10 < 10}  : ${10< 10} <br>
\${10 lt 10}  : ${10 lt 10} <br><br>

\${100>10} : ${100>10}<br>
\${100 gt 10} : ${100 gt 10}<br><br>

\${100 <=10} : ${100 <=10}<br>
\${100 le 10} : ${100 le 10}<br><br>

\${100 >=10} : ${100 >=10}<br>
\${100 ge 10} : ${100 ge 10}<br><br>

</h3>
</body>
</html>