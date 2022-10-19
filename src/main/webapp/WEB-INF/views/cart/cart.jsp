<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GH SHOP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sub.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/checkBox.js"></script>
</head>

<body>
<div id="container">			
	<div class="cart_wrap_mo innerContent">
		<!-- 전체선택 버튼 -->
		<div class="goods_chk_all">
			<div class="checkbox" id = "box">
				<button type="button" class="btn_cle btn_st1" onclick = "CartdeleteAll()">전체삭제</button>
				<input type = "hidden" id = "deleteAll" value = "${sessionScope.userInfo.member_id}">
<%--			<input type="checkbox" class="btn_select_all" checked="checked" onclick="allCheck()">--%>
<%--			<span class="txt" id = "All">전체선택</span>--%>
			</div>

			<div class="btn">
				<button type="button" class="btn_cle btn_st1">
				<input type="checkbox" class="btn_select_all" checked="checked" onclick="allCheck()">
				<span class="txt" id = "All">전체선택</span>
				</button>
<%--				<button type="button" class="btn_cle btn_st1" onclick = "CartdeleteAll()">전체삭제</button>--%>
<%--				<input type = "hidden" id = "deleteAll" value = "${sessionScope.userInfo.member_id}">--%>
			</div>
		</div>	
		<!-- 전체선택 버튼 -->				
<!-- 리스트 반복문	/////////////////////////////////////////////////////////////////////	 -->
		<!-- 제품리스트 1 -->
		

		<div id="cartList">

		</div>
		
		<!-- 제품리스트 1 -->
<!-- 리스트 반복문	/////////////////////////////////////////////////////////////////////	 -->
		<!-- 총합계내역 -->
		<div class="price_total_box">
			<div class="baesong_total">
				<div class="con">배송 : <span id = "cartListSize"></span>건 </div>
			</div>

			<div class="price_total_wrap">
				<h2 id = "totalPrice" class="title">전체 합계</h2>
				<ul>
					<li class="pnum">
						<div class="tit">상품수</div>
						<div class="con"><b></b>개</div>
					</li>
					<li class="price">
						<div class="tit">상품금액</div>
						<div class="con"><b id="product_price"><fmt:formatNumber type="currency" value="${totalPrice }"/></b>원</div>
					</li>

				</ul>
				<div class="price_total">
					<div class="tit">전체 주문금액</div>
					<div class="con"><b id="total_price"><fmt:formatNumber type="currency" value="${totalPrice}"/></b>원</div>
				</div>
			</div>									
		</div><!-- price_total_all -->	
		<!-- 총합계내역 -->
		
		<!-- 주문 버튼 -->
		<div class="cart_order_btn_wrap">			
			<button type="button" class="all_order" onclick = "submit()">상품주문</button>			
		</div><!-- cart_order_btn_area -->
		<!-- 주문 버튼 -->
	</div><!--cartwrap-->
</div><!--container-->


</body>

</html>
<script>
	$(document).ready(
		function (){
			getCateList();
		}
	);

	function getCateList(){
		var cartList = $('#cartList')

		$.ajax({
			url : "/cart/cartList",
			type : "GET",
			success : function(html){
				cartList.empty();
				cartList.append(html);
			}
		});
		console.log("getCateList()");

	}



</script>