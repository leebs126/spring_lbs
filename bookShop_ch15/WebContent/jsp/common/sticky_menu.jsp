<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="serverUrl"  value="http://localhost:8090/Shoping12/download.do"  />
<script>
var array_index=0;
function fn_show_next_goods(){
	var img_sticky=document.getElementById("img_sticky");
	var cur_goods_num=document.getElementById("cur_goods_num");
	var h_goods_id=document.frm_sticky.h_goods_id;
	var h_goods_fileName=document.frm_sticky.h_goods_fileName;
	
	if(array_index <h_goods_id.length-1)
		array_index++;
	 	
	var goods_id=h_goods_id[array_index].value;
	var fileName=h_goods_fileName[array_index].value;
	
	img_sticky.src=${serverUrl}+"?goods_id="+goods_id+"&fileName="+fileName;
	
	cur_goods_num.innerHTML=array_index+1;
}

function fn_show_previous_goods(){
	var img_sticky=document.getElementById("img_sticky");
	var cur_goods_num=document.getElementById("cur_goods_num");
	var h_goods_id=document.frm_sticky.h_goods_id;
	var h_goods_fileName=document.frm_sticky.h_goods_fileName;
	
	if(array_index >0)
		array_index--;
	
	var goods_id=h_goods_id[array_index].value;
	var fileName=h_goods_fileName[array_index].value;
	
	img_sticky.src=SERVER_URL+"goods_id="+goods_id+"&fileName="+fileName;
	cur_goods_num.innerHTML=array_index+1;
}

</script>    
<body>    
    <div id="sticky" >
	<UL>
		<LI><A href="#"><IMG
				width="24" height="24" src="<%=request.getContextPath() %>/image/facebook_icon.png">
				페이스북</A></LI>
		<LI><A href="#"><IMG
				width="24" height="24" src="<%=request.getContextPath() %>/image/twitter_icon.png">
				트위터</A></LI>
		<LI><A href="#"><IMG
				width="24" height="24" src="<%=request.getContextPath() %>/image/rss_icon.png">
				RSS 피드</A></LI>
	</UL>
	<DIV class="recent">
		<H3>최근 본 상품</H3>
		  <UL>
		<!--   상품이 없습니다. -->
		 <c:choose>
			<c:when test="${ empty quick_goods_list }">
				     <STRONG>상품이 없습니다.</STRONG>
			</c:when>
			<c:otherwise>
	<form name="frm_sticky"  >	        
		      <c:forEach var="item" items="${quick_goods_list }" varStatus="itemNum">
		         <c:choose>
		           <c:when test="${itemNum.count==1 }">
			      <a href="${pageContext.request.contextPath}/goods/goods.do?command=goods_detail&goods_id=${item.goods_id }">
			  	         <IMG width="75" height="95" id="img_sticky"  
			                 src="${pageContext.request.contextPath}/download.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
			      </a>
			        <input type="hidden"  name="h_goods_id" value="${item.goods_id}" />
			        <input type="hidden" name="h_goods_fileName" value="${item.goods_fileName}" />
			      <br>
			      </c:when>
			      <c:otherwise>
			        <input type="hidden"  name="h_goods_id" value="${item.goods_id}" />
			        <input type="hidden" name="h_goods_fileName" value="${item.goods_fileName}" />
			      </c:otherwise>
			      </c:choose>
		     </c:forEach>
		   </c:otherwise>
	      </c:choose>
		 </UL>
</form>		 
	</DIV>
	 <div>
	 <c:choose>
	    <c:when test="${ empty quick_goods_list }">
		    <h5>  &nbsp; &nbsp; &nbsp; &nbsp;  0/0  &nbsp; </h5>
	    </c:when>
	    <c:otherwise>
           <h5>   <a href="javascript:fn_show_previous_goods()"> 이전 </a> &nbsp;  <span id="cur_goods_num">1</span>/${quick_goods_list}  &nbsp; <a href="javascript:fn_show_next_goods()"> 다음 </a> </h5>
       </c:otherwise>
       </c:choose>
    </div>
</div>

</body>
</html>