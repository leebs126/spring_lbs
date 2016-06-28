<%@ page import="java.util.*,ch11.ex1.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<jsp:useBean  id="m"  class="ch11.ex1.MemberBean" scope="page" />
<%
request.setCharacterEncoding("UTF-8");

%>

<%-- <jsp:setProperty name="m" property="*" /> --%>

<%--
<jsp:setProperty name="m" property="id"  />
<jsp:setProperty name="m" property="name"  />
<jsp:setProperty name="m" property="age"   />
<jsp:setProperty name="m" property="weight" />
<jsp:setProperty name="m" property="height" />
--%>

<%-- 
<jsp:setProperty name="m" property="id" param="id"  />
<jsp:setProperty name="m" property="name" param="name"  />
<jsp:setProperty name="m" property="age" param="age"/>
<jsp:setProperty name="m" property="weight" param="weight" />
<jsp:setProperty name="m" property="height" param="height" />

 --%>

<jsp:setProperty name="m" property="id" value='<%= request.getParameter("id") %>'  />
<jsp:setProperty name="m" property="name" value='<%= request.getParameter("name") %>'  />
<jsp:setProperty name="m" property="age" value='<%= request.getParameter("age") %>'  />
<jsp:setProperty name="m" property="weight" value='<%= request.getParameter("weight") %>'  />
<jsp:setProperty name="m" property="height" value='<%= request.getParameter("height") %>'  />




<%
		/* request.setCharacterEncoding("UTF-8");
       String  userId = request.getParameter("id");
		String  userName = request.getParameter("name");
		String  userAge = request.getParameter("age");
		String  userWeight = request.getParameter("weight");
		String  userHeight = request.getParameter("height");

		m.setId(userId);
		m.setName(userName );
		m.setAge(userAge);
		m.setWeight(userWeight);
		m.setHeight(userHeight); */


		MemberDao  memDao  = new MemberDao( );
		memDao.insertMember( m );
		ArrayList  list  = memDao.listMember();
		
%> 
<html><body>
<table  width="100%">
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
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 회원이  없습니다.</span></b></p>
        </td>
    </tr>
<%
	} else {

		for ( int i = 0; i < list.size(); i++ ) {

			MemberBean bean = ( MemberBean )list.get( i );
			String id=bean.getId();
			String name =bean.getName();
			String age  =bean.getAge();
			String weight=bean.getWeight();
			String height =bean.getHeight();
		
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
		<td colspan="5">
<!--	지금 입력된 사용자 나이는 ? 		    -->
<%--		  <jsp:getProperty name="m"  property="age"  />  --%>
<!--		  입니다.  -->
		</td>

	</tr>
</table>
</body>
</html>
