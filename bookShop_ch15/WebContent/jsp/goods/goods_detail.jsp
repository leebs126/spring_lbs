<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<style>
#layer {
	z-index: 2;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	/* background-color:rgba(0,0,0,0.8); */
}

#popup {
	z-index: 3;
	position: fixed;
	text-align: center;
	left: 50%;
	top: 45%;
	width: 300px;
	height: 200px;
	background-color: #ccffff;
	border: 3px solid #87cb42;
}

#close {
	z-index: 4;
	float: right;
}
</style>
<script type="text/javascript">
	function add_cart(goods_id) {
		$.ajax({
			type : "post",
			async : false, //false인 경우 동기식으로 처리한다.
			url : "http://localhost:8090/Shoping11/cart/cart.do",
			data : {
				command:"add_cart",
				goods_id:goods_id
				
			},
			success : function(data, textStatus) {
				//alert(data);
			//	$('#message').append(data);
				if(data.trim()=='add_success'){
					imagePopup('open', '.layer01');	
				}else if(data.trim()=='already_existed'){
					alert("이미 카트에 등록된 제품입니다.");	
				}
				
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax	
	
	}

	function imagePopup(type) {
		if (type == 'open') {
			// 팝업창을 연다.
			jQuery('#layer').attr('style', 'visibility:visible');

			// 페이지를 가리기위한 레이어 영역의 높이를 페이지 전체의 높이와 같게 한다.
			jQuery('#layer').height(jQuery(document).height());
		}

		else if (type == 'close') {

			// 팝업창을 닫는다.
			jQuery('#layer').attr('style', 'visibility:hidden');
		}
	}
</script>
</head>
<body>
	<hgroup>
		<h1>컴퓨터와 인터넷</h1>
		<h2>국내외 도서 &gt; 컴퓨터와 인터넷 &gt; 웹 개발</h2>
		<h3>${goodsMap.goodsVO.goods_title }</h3>
		<h4>${goodsMap.goodsVO.goods_writer} &nbsp; 저| ${goodsMap.goodsVO.goods_publisher }</h4>
	</hgroup>
	<div id="goods_image">
		<figure>
			<img alt="HTML5 &amp; CSS3"
				src="${pageContext.request.contextPath}/download.do?goods_id=${goodsMap.goodsVO.goods_id}&fileName=${goodsMap.goodsVO.goods_fileName}">
		</figure>
	</div>
	<div id="detail_table">
		<table>
			<tbody>
				<tr>
					<td class="fixed">정가</td>
					<td><span>
					   <fmt:formatNumber  value="${goodsMap.goodsVO.goods_price}" type="number" var="goods_price" />
				         ${goods_price}원
					</span></td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">판매가</td>
					<td><span class="active">
					   <fmt:formatNumber  value="${goodsMap.goodsVO.goods_price*0.9}" type="number" var="discounted_price" />
				         ${discounted_price}원(10%할인)</span></td>
				</tr>
				<tr>
					<td class="fixed">포인트적립</td>
					<td class="active">${goodsMap.goodsVO.goods_point}P(10%적립)</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">포인트 추가적립</td>
					<td>만원이상 구매시 1,000P, 5만원이상 구매시 2,000P추가적립 편의점 배송 이용시 300P 추가적립</td>
				</tr>
				<tr>
					<td class="fixed">발행일</td>
					<td>${goodsMap.goodsVO.goods_published_date}</td>
				</tr>
				<tr>
					<td class="fixed">페이지 수</td>
					<td>${goodsMap.goodsVO.goods_page_total}쪽</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">ISBN</td>
					<td>${goodsMap.goodsVO.goods_isbn}</td>
				</tr>
				<tr>
					<td class="fixed">배송료</td>
					<td><STRONG>무료</STRONG></td>
				</tr>
				<tr>
					<td class="fixed">배송안내</td>
					<td><strong>[당일배송]</strong> 당일배송 서비스 시작!<br> <strong>[휴일배송]</strong>
						휴일에도 배송받는 Senop</TD>
				</tr>
				<tr>
					<td class="fixed">도착예정일</td>
					<td>지금 주문 시 내일 도착 예정</td>
				</tr>
				<tr>
					<td class="fixed">수량</td>
					<td><select style="width: 60px;"><option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<ul>
			<li><a class="buy" href="#">구매하기 </a></li>
			<li><a class="cart" href="javascript:add_cart('${goodsMap.goodsVO.goods_id }')">장바구니</a></li>
			
			<li><a class="wish" href="#">위시리스트</a></li>
		</ul>
	</div>
	<div class="clear"></div>
	<!-- 내용 들어 가는 곳 -->
	<div id="container">
		<ul class="tabs">
			<li><a href="#tab1">책소개</a></li>
			<li><a href="#tab2">저자소개</a></li>
			<li><a href="#tab3">책목차</a></li>
			<li><a href="#tab4">출판사서평</a></li>
			<li><a href="#tab5">추천사</a></li>
			<li><a href="#tab6">리뷰</a></li>
		</ul>
		<div class="tab_container">
			<div class="tab_content" id="tab1">
				<h4>책소개</h4>
				<p>${goodsMap.goodsVO.goods_intro}</p>
				<c:forEach var="image" items="${goodsMap.imageList }">
					<img width="400" height="400"
						src="${pageContext.request.contextPath}/download.do?goods_id=${goodsMap.goodsVO.goods_id}&fileName=${image.fileName}">
				</c:forEach>
			</div>
			<div class="tab_content" id="tab2">
				<h4>저자소개</h4>
				<p>
				<div class="writer">저자 : ${goodsMap.goodsVO.goods_writer}</div>
				${goodsMap.goodsVO.goods_writer_intro }
				<p></p>
			</div>
			<div class="tab_content" id="tab3">
				<h4>책목차</h4>
				<p>${goodsMap.goodsVO.goods_contents_order }</p>
			</div>
			<div class="tab_content" id="tab4">
				<h4>출판사서평</h4>
				<p>${goodsMap.goodsVO.goods_publisher_comment }</p>
			</div>
			<div class="tab_content" id="tab5">
				<h4>추천사</h4>
				<p>${goodsMap.goodsVO.goods_recommendation }</p>
			</div>
			<div class="tab_content" id="tab6">
				<h4>리뷰</h4>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div id="layer" style="visibility: hidden">
		<!-- visibility:hidden 으로 설정하여 해당 div안의 모든것들을 가려둔다. -->
		<div id="popup">
			<!-- 팝업창 닫기 버튼 -->
			<a href="javascript:" onClick="javascript:imagePopup('close', '.layer01');"> <img
				src="${pageContext.request.contextPath}/image/close.png" id="close" />
			</a> <br /> <font size="12" id="contents">장바구니에 담았습니다.</font><br>
<form action='${pageContext.request.contextPath}/cart/cart.do?command=my_cart_list'>				
		<input  name="btn_cancel_member" type="submit" value="장바구니 보기">
		<input  type="hidden" name="command" value="my_cart_list"/>
</form>				
			<div></div>
</body>
</html>
