<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 등록 폼</title>
</head>
<body>
<form  method=post action="member_action.jsp">
 <h1>회원 정보 등록 폼</h1>
 <table >
   <tr>
     <td width=200>
     	 <p align=right >사용자 아이디
     </td>
     <td width=400>
         <input   type=text name=id >
     </td>
   </tr>
 <tr>
     <td width=200>
     	 <p align=right >사용자 이름
     </td>
     <td width=400>
         <input   type=text name=name >
     </td>
   </tr>
   <tr>
     <td width=200>
     	 <p align=right >나이
     </td>
     <td width=400>
         <input   type=text name=age >
     </td>
   </tr>
   <tr>
     <td width=200>
     	 <p align=right >몸무게
     </td>
     <td width=400>
         <input   type=text name=weight >
     </td>
   </tr>
   <tr>
     <td width=200>
     	 <p align=right >키
     </td>
     <td width=400>
         <input   type=text  name=height >
     </td>
   </tr>
   <tr>
    <td width=200><p>&nbsp; </p> </td>
    <td width=400><input type=submit value="보내기" >
       <input type=reset value="초기화" > </td>
   </tr>
 </table>

</form>
</body>
</html>