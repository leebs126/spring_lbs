<%@ page import="java.util.*,ch11.ex1.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
		request.setCharacterEncoding("UTF-8");
	    String   userId=request.getParameter("id");
		String  userName = request.getParameter("name");
		String  userAge = request.getParameter("age");
		String  userWeight = request.getParameter("weight");
		String  userHeight = request.getParameter("height");

		MemberBean  m = new MemberBean(userId,userName , userAge , userWeight, userHeight);
		MemberDao  memberDao  = new MemberDao();
		memberDao.insertMember(m);
		ArrayList  list  = memberDao.listMember();
		
%>
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
<%
	if ( list.size() == 0 ) {
%>
	<tr>
        <td  align="center" colspan="5">
            <b><span style="font-size:9pt;">등록된 회원이  없습니다.</span></b>
        </td>
    </tr>
<%
	} else {

		for ( int i = 0; i < list.size(); i++ ) {

			MemberBean bean = (MemberBean)list.get( i );
			String id=bean.getId();
			String name=bean.getName();
			String age=bean.getAge();
			String weight=bean.getWeight();
			String height=bean.getHeight();
		
%>
    <tr align="center">
	     <td>
            <%=id%>
        </td>

        <td>
           <%=name%>
        </td>
        <td>
			<%=age%>
        </td>
        <td>
           <%=weight%>
        </td>
        <td>
           <%=height%>
        </td>
    </tr>
<%
		} // end for

	} // end if
%>
	<tr height="1" bgcolor="#99ccff">
		<td colspan="5"></td>
	</tr>
</table>
</body>
</html>
