<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border=1  >
  <tr align=center>
	     <td width="7%" >
           <b>아이디</b>
        </td>
        <td width="7%" >
            <b>이름</b>
        </td>
        <td width="5%" >
           <b>나이</b>
        </td>
        <td width="7%">
            <b>체중</b>
        </td>
        <td width="5%" >
            <b>키</b>
        </td>
         <td width="5%" >
            <b>주소</b>
        </td>
    </tr>
    <tr align=center>
      <td>${param.id } </td>
      <td>${param.name } </td>
      <td>${param.age } </td>
      <td>${param.weight }</td>
      <td>${param.height }</td>
       <td>${requestScope.address }</td>
    </tr>
</table>
</body>
</html>