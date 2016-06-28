<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean  id="m" class="ch12.ex1.MemberBean" />
<jsp:setProperty  name="m" property="*" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>회원 정보 표시창</title>
</head>
<body>
<table align=center border=1   width=600>
  <tr align="center">
       <td width=20%>
        <b>아이디</b>
      </td>
        </td>
        <td width="20%" >
           <b>이름</b>
        </td>
        <td width="20%" >
           <b>나이</b>
        </td>
        <td width="20%" >
            <b>체중</b>
        </td>
        <td width="20%" >
            <b>키</b>
        </td>		
  </tr>
   <tr align="center">
    <td>
      <%=m.getId() %> 
    </td>
    <td>
      <%=m.getName() %> 
    </td>
    <td>
      <%=m.getAge() %>
    </td>
    <td>
      <%=m.getWeight() %>
    </td>
    <td>
      <%=m.getHeight() %>
    </td>
  </tr>
  
  <tr align="center">
    <td>
      ${m.id } 
    </td>
    <td>
      ${m.name } 
    </td>
    <td>
      ${m.age }
    </td>
    <td>
      ${m.weight }
    </td>
    <td>
      ${m.height }
    </td>
  </tr>
</table>
</body>
</html>