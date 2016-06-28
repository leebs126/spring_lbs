<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<DIV id="logo">
	<A href="${pageContext.request.contextPath}/main/main.do">
		<IMG width="176" height="80" alt="booktopia" src="${pageContext.request.contextPath}/image/Booktopia_Logo.jpg">
		</A>
	</DIV>
	<DIV id="head_link">
		<UL>
		   <c:choose>
		     <c:when test="${isLogOn==true }">
			<LI><A href="${pageContext.request.contextPath}/member/member.do?command=action_logout">로그아웃</A></LI>
			<LI><A href="${pageContext.request.contextPath}/mine/mine.do?command=my_page_list">마이페이지 </A></LI>
			 </c:when>
			 <c:otherwise>
			<LI><A href="${pageContext.request.contextPath}/member/member.do?command=member_login_page">로그인</A></LI>
			<LI><A href="${pageContext.request.contextPath}/member/member.do?command=member_join_page">회원가입</A></LI> 
			 </c:otherwise>
			</c:choose>
			<LI><A href="${pageContext.request.contextPath}/cart/cart.do?command=my_cart_list">장바구니</A></LI>
			<LI><A href="#">고객센터</A></LI>
			<LI><A href="#">주문배송</A></LI>
			<LI class="no_line"><A href="${pageContext.request.contextPath}/admin/admin.do?command=add_goods_page">관리자</A></LI>
		</UL>
	</DIV>
	<BR>
	<DIV id="search">
		<FORM action="${pageContext.request.contextPath}/goods/goods.do" method='post'>
			<INPUT name="command"  type="hidden" value="goods_search">
			<INPUT name="searchWord" class="main_input" type="text"> 
			<INPUT name="search" class="btn1" type="submit" value="검 색">
		</FORM>
	</DIV>

</body>
</html>