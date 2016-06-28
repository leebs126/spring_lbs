<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색 회원 정보 출력</title>
</head>
<body>
<table align="center" border=1 >
	<tr align="center">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%" ><b>나이</b></td>
      <td width="7%"><b>체중</b></td>
      <td width="7%" ><b>키</b></td>
   </tr>
   <tr align="center">
     <td>${member.id }</td>
     <td>${member.name}</td>
     <td>${member.age}</td>     
     <td>${member.weight}</td>     
     <td>${member.height}</td> 
   </tr>
</table>
</body>
</html>