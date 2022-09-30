<%--
  Created by IntelliJ IDEA.
  User: jinhu
  Date: 2022-10-01
  Time: 오전 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${productView.count > 0}">
    <div id="searchPrdList">
      <div id="small-pg-ctrl" class="pg-ctrl-box">
        <span class="pagination" id="shortPaging">${productView.count} 개의 상품이 있습니다.</span>
      </div>
      <section class="prd-list">
        <ul>
          <c:forEach items="${productView.productList}" var="product">
            <li>
              <a href="https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1&amp;lseq=405302"
                 class="prd-item" data-prdid="${product.product_id}"
                 onclick="PrdObject.setLatestViewedPrd(this);">
                <div class="prd-img">
                  <img src="${product.thumbnail}">
                  <span class="badge-abs"></span>
                  <span class="toggle-zzim" id="toggle-zzim_66172344">찜완료</span>
                    <%--					<button class="link-new-tab" onclick="PrdObject.openNewTab(&#39;https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1&amp;lseq=405302&#39;); return false;"><i class="sprite-new-tab"></i>새창 열기</button>--%>
                </div>
                <dl class="prd-info">
                  <dt class="prd-name">
                      ${product.title}
                  </dt>
                  <dd class="price-info" data-exposprctypcd="2" data-exposprdtypcd="P"
                      data-consultproduct="false" data-rentprc="0">
						<span class="price">
									<span class="set-price"><strong>${product.price}</strong>원</span>
						</span><!-- //price -->
                  </dd>
                  <dd class="user-side">
                    <button class="user-comment"
                            data-link="https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1"
                            onclick="PrdObject.gotoPrdRevw(this); return false;">상품평 0
                    </button>
                    <button class="my-wish "
                            onclick="PrdObject.toggleWish(this); return false;"
                            id="wishPrdButton_66172344">찜하기
                    </button>

                  </dd>
                  <dd class="advantage">
                    <div>
                      <span>무료배송</span>
                    </div>
                  </dd>
                </dl>
              </a>
            </li>
          </c:forEach>
        </ul>
      </section>

    </div>
    <!-- 상품 리스트 끝 -->

    <!-- 상품 하단 페이징 시작 -->
    <div id="pageNavigation">
      <nav class="paging">
        <fmt:parseNumber var="startPageParce" integerOnly="true" value="${searchProduct.page / 10 }"/>
        <c:set var="startPage" value="${startPageParce * 10 + 1}"/>
        <c:set var="endPage" value="${startPage + 9}"/>
        <fmt:parseNumber var="totalPage" integerOnly="true" value="${productView.count % searchProduct.pageSize != 0 ? (productView.count / searchProduct.pageSize + 1) : productView.count / searchProduct.pageSize }"/>
        <c:if test="${endPage > totalPage}">
          <c:set var="endPage" value="${totalPage}"/>
        </c:if>

        <c:if test="${startPage != 1}">
          <a class="go-first" onclick="getList(1)"><span>처음</span></a>
        </c:if>

        <c:if test="${startPage != 1}">
          <a data-index="${startPage-10}" class="go-prev" onclick="getList(${startPage-10})"><span>이전</span></a>
        </c:if>

        <c:forEach begin="${startPage}" end="${endPage}" var="page">
          <c:choose>
            <c:when test="${page == searchProduct.page}">
              <span class="blind">현재</span>
              <strong>${page}</strong>
              <span class="blind">페이지</span>
            </c:when>
            <c:otherwise>
              <a onclick="getList(${page})">${page}</a><span class="blind">페이지</span>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <c:if test="${(productView.count / searchProduct.pageSize) > 10}">
          <a class="go-next" onclick="getList(${startPage+10})"><span>다음</span></a>
        </c:if>

        <c:if test="${totalPage > endPage}">
          <a class="go-last" onclick="getList(${totalPage})"><span>마지막</span></a>
        </c:if>
      </nav>
    </div>
  </c:when>
  <c:otherwise>
    <div id="searchPrdList">
      <div id="small-pg-ctrl" class="pg-ctrl-box">
        <span class="pagination" id="shortPaging">${productView.count} 개의 상품이 있습니다.</span>
      </div>
    </div>
  </c:otherwise>
</c:choose>
