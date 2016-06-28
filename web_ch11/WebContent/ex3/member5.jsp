<%@ page import="java.util.*,ch11.ex1.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<jsp:useBean  id="m"  class="ch11.ex1.MemberBean" />
<%
  request.setCharacterEncoding("UTF-8");

%>

<jsp:setProperty name="m" property="*" />

<html><body>
<table  border="0"  width="100%">
	<tr align="center" bgcolor="#99ccff">
	   <td width="7%" >
            아이디
        </td>
        <td width="7%">
            이름
        </td>
        <td width="5%" >
            나이
        </td>
        <td width="11%" >
           체중
        </td>
        <td width="5%" >
            키
        </td>
    </tr>
   <tr align="center">
    <td >
         <jsp:getProperty name="m"  property="id"  /> 
        </td>
        <td>
            <jsp:getProperty name="m"  property="name"  /> 
        </td>
        <td>
			<jsp:getProperty name="m"  property="age"  /> 
        </td>
        <td>
           <jsp:getProperty name="m"  property="weight"  /> 
        </td>
        <td>
            <jsp:getProperty name="m"  property="height"  /> 
        </td>
    </tr>
	<tr height="1" bgcolor="#99ccff">
		<td colspan="5">
		</td>

	</tr>
</table>
</body>
</html>
