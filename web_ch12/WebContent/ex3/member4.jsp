<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
    import ="java.util.*"
%>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean  id="m" class="ch12.ex1.MemberBean"/>
<jsp:setProperty name="m" property="*"  />
<jsp:useBean  id="list" class="java.util.ArrayList" />
<%
   list.add(m);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력 창</title>
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
        <td width="11%">
            <b>체중</b>
        </td>
        <td width="5%" >
            <b>키</b>
        </td>
    </tr>
    <tr align=center>
      <td>${list[0].id } </td>
      <td>${list[0].name } </td>
      <td>${list[0].age } </td>
      <td>${list[0].weight}</td>
      <td>${list[0].height}</td>
    </tr>
</table>
</body>
</html>