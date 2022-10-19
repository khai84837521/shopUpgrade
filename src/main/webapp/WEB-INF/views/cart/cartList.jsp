<%--
  Created by IntelliJ IDEA.
  User: HANJAEWOOK
  Date: 2022-10-05
  Time: 오후 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="${pageContext.request.contextPath}/resources/js/checkBox.js"></script>

<c:forEach var="cartDto" items="${cartList }" varStatus = "status">
  <c:set value="${totalPrice + cartDto.prodPrice*cartDto.amount }" var="totalPrice"/>
  <div class="cart_goods_box">
    <div class="goods_chk">
      <input type="checkbox" checked name = "product" data-price="${cartDto.prodPrice*cartDto.amount }" value="${cartDto.cartId }" onclick="doCheck()">
    </div><!-- goods_chk -->
    <div class="cart_goods_list">
      <div class="img_area">
        <a href=""><img src="${cartDto.prodThumbnail }" style="width:90%;" class="goods_thumb"></a>
      </div>
      <div class="option_area">
        <ul>
          <li class="name">${cartDto.prodTitle }</li>
          <li class="amount">
            <div class="spinnerBox">
              <button class="minus" onclick="spinnerDown(this)">-</button>
              <div class="number">
                <input id="topQuantitySpinner" class="productAmount" type="number" value="${cartDto.amount}" onkeyup="spinerInsert(this)">
                <label for="topQuantitySpinner" class="blind">스피너 값</label>
              </div>
              <button class="plus" onclick="spinnerUp(this)">+</button>
            </div>
          </li>
          <li class="price_mo"><b><fmt:formatNumber type="currency" value="${cartDto.prodPrice }"/></b>원</li>
        </ul>
      </div>
    </div><!-- cart_goods_list -->
    <div class="price_total">
      <span class="ptitle">합계 : </span>
      <span class="total_p"><b><fmt:formatNumber type="currency" value="${cartDto.prodPrice*cartDto.amount}"/></b>원</span>
      <input class="productAmountPrice" type="hidden" value="${cartDto.prodPrice*cartDto.amount}"/>
    </div>
    <div class="btn_wrap">
      <ul>
        <li>
          <button type="button" class="btn_cle btn_st_1" onclick = "CartdeleteOne(this)">삭제</button>
          <input type="hidden" id="cartId" value="${cartDto.cartId}">
        </li>
      </ul>
    </div>
  </div><!--cart_goods_box 각 제품리스트 -->
</c:forEach>


