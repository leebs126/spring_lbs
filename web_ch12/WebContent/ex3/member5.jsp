<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"
    %>
    
<%
  request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean  id="m" class="ch12.ex2.MemberBean" />
<jsp:setProperty  name="m" property="*" />
<jsp:useBean   id="addr" class="ch12.ex2.Address"/>
<jsp:setProperty   name="addr" property="city" value="서울"/>
<jsp:setProperty   name="addr" property="zipcode" value="07654"/>
<%
  m.setAddr(addr);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<table align=center border=1>
  <tr>
     <tr align=center>
	     <td width="11%" >
           <b>아이디</b>
        </td>
        <td width="11%" >
            <b>이름</b>
        </td>
        <td width="11%" >
           <b>나이</b>
        </td>
        <td width="11%">
            <b>체중</b>
        </td>
        <td width="15%" >
            <b>키</b>
        </td>
         <td width="15%" >
            <b>도시</b>
        </td>
         <td width="15%" >
            <b>우편번호</b>
        </td>
    </tr>
  <tr align=center>
    <td>${m.id } </td>
      <td>${m.name } </td>
      <td>${m.age } </td>
      <td>${m.weight}</td>
      <td>${m.height}</td>
      <td><%=m.getAddr().getCity() %></td>
      <td><%=m.getAddr().getZipcode() %></td>
  </tr>
   <tr align=center>
      <td>${m.id } </td>
      <td>${m.name } </td>
      <td>${m.age } </td>
      <td>${m.weight}</td>
      <td>${m.height}</td>
      <td>${m.addr.city}</td>
      <td>${m.addr.zipcode}</td>
  </tr>
</table>

</body>
</html>
