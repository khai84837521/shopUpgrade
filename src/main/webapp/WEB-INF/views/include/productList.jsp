<%--
  Created by IntelliJ IDEA.
  User: HANJAEWOOK
  Date: 2022-09-28
  Time: 오후 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="swiper proslide01 list innerContent">
    <!-- 전체 -->
    <ul class="swiper-wrapper">
        <c:forEach items="${productListCateSearchPopular}" var="productList">
            <li class="swiper-slide line_4">
                <div class="space">
                    <div class="PJ_goods_border">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/goods_view?n=${productList.product_id}"></a>
                            <img src="<c:url value="${productList.thumbnail}"/>" class="middle">
                            <span class="hot"></span>
                            <span class="choice">
													<button href="" type="button" class="cart btn-open-layer btn-add-cart14">장바구니</button>
												</span>
                        </div>
                        <div class="txt">
                            <a href="${pageContext.request.contextPath}/goods_view?n=${productList.product_id}"><strong class="title">${productList.title}</strong></a>
                        </div>
                        <div class="price gd-default">
												<span class="cost">
													<strong><fmt:formatNumber type="currency"  value= "${productList.price}" /><em class="pr_unit">원</em></strong>
												</span>
                            <div class="dc_per">20%</div>
                            <br>
                        </div>
                        <div class="tag-box">
                            <span class="tag-type2">SALE</span>
                            <span class="tag-type3">무료배송</span>
                        </div>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
    <!-- 전체 -->
</div><!-- proslide01 -->
<div class="swiper-button-next swiper-button-next-pro"></div>
<div class="swiper-button-prev swiper-button-prev-pro"></div>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>