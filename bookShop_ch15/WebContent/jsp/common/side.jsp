<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<NAV>
<UL>
<c:choose>
<c:when test="${side_menu=='admin_mode' }">
<LI>
		<H3>주요기능</H3>
		<UL>
			<LI><A href="${pageContext.request.contextPath}/admin/admin.do?command=manage_goods">제품관리</A></LI>
			<LI><A href="${pageContext.request.contextPath}/admin/admin.do?command=manage_order">주문관리</A></LI>
			<LI><A href="#">회원관리</A></LI>
			<LI><A href="#">배송관리</A></LI>
			<LI><A href="#">게시판관리</A></LI>
		</UL>
	</LI>
</c:when>
<c:when test="${side_menu=='my_page' }">
	<LI>
		<H3>주문내역</H3>
		<UL>
			<LI><A href="${pageContext.request.contextPath}/mine/mine.do?command=find_order_delivery_hist">주문내역/배송 조회</A></LI>
			<LI><A href="#">반품/교환 신청 및 조회</A></LI>
			<LI><A href="#">취소 주문 내역</A></LI>
			<LI><A href="#">세금 계산서</A></LI>
		</UL>
	</LI>
	<LI>
		<H3>정보내역</H3>
		<UL>
			<LI><A href="${pageContext.request.contextPath}/mine/mine.do?command=my_info_detail">회원정보관리</A></LI>
			<LI><A href="#">나의 주소록</A></LI>
			<LI><A href="#">개인정보 동의내역</A></LI>
			<LI><A href="#">회원탈퇴</A></LI>
		</UL>
	</LI>
</c:when>
<c:otherwise>
	<LI>
		<H3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;국내외 도서</H3>
		<UL>
			<LI><A href="${pageContext.request.contextPath}/goods/goods.do?command=goods_list&type=computer">IT/인터넷</A></LI>
			<LI><A href="#">경제/경영</A></LI>
			<LI><A href="#">대학교재</A></LI>
			<LI><A href="#">자기계발</A></LI>
			<LI><A href="#">자연과학/공학</A></LI>
			<LI><A href="#">역사/인문학</A></LI>
		</UL>
	</LI>
	<LI>
		<H3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음반</H3>
		<UL>
			<LI><A href="#">가요</A></LI>
			<LI><A href="#">록</A></LI>
			<LI><A href="#">클래식</A></LI>
			<LI><A href="#">뉴에이지</A></LI>
			<LI><A href="#">재즈</A></LI>
			<LI><A href="#">기타</A></LI>
		</UL>
	</LI>
 </c:otherwise>
 </c:choose>	
</UL>
</NAV>
<DIV class="clear"></DIV>
<DIV id="banner">
	<a href="#"><IMG width="190" height="163" src="${pageContext.request.contextPath}/image/n-pay.jpg"> </a>
</DIV>
<DIV id="notice">
	<H2>공지사항</H2>
	<UL>
	
	<c:forEach  var="i" begin="1" end="5" step="1">
		<LI><A href="#">공지사항입니다.${ i}</A></LI>
	</c:forEach>
	</UL>
</DIV>


<DIV id="banner">
	<a href="#"><IMG width="190" height="362" src="${pageContext.request.contextPath}/image/side_banner1.jpg"></a>
</DIV>
<DIV id="banner">
	<a href="#"><IMG width="190" height="104" src="${pageContext.request.contextPath}/image/call_center_logo.jpg"> </a>
</DIV>
<DIV id="banner">
	<a href="#"><IMG width="190" height="69" src="${pageContext.request.contextPath}/image/QnA_logo.jpg"></a>
</DIV>
</html>