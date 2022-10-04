<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header"/>
<body class="flexible">
<div id="doc-container">
    <!-- 로케이션 -->
    <section id="doc-location">
        <div class="doc-wrap">
            <div id="breadcrumb">
                <span class="item">
					<a class="hoverline" href="https://www.gsshop.com/index.gs?svcid=gc&amp;lseq=404864">홈</a>
				</span>

                <span class="item">
					<a class="hoverline"
                       href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865">${parentCategory.cate_name}</a>
					<button class="gui-btn icon mini">
                        <span class="sprite-arr-down_s">카테고리 더보기</span>
                    </button>
					<div class="cate-layer">
						<ul>
                            <c:forEach items="${category}" var="cate">
                                <li class="${cate.cate_code == parentCategory.cate_code ? 'on' : ''}"><a
                                        href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865"><span>${cate.cate_name}</span></a></li>
                            </c:forEach>
						</ul>
					</div>
				</span>
            </div>
        </div>
    </section><!--// doc-location -->
    <main id="doc-contents">
        <div class="doc-wrap">
            <h2 class="shop-title">${parentCategory.cate_name}</h2>
            <form>
            <aside id="content-aside">
                <input type="hidden" id="cateCode" value="${searchProduct.cateCode}">
                <input type="hidden" id="page" value="">
                <input type="hidden" id="pageSize" value="">
                <input type="hidden" id="orderType" value="">
                <input type="hidden" id="minPrice" value="">
                <input type="hidden" id="maxPrice" value="">
                <input type="hidden" id="keyword" value="">
                <input type="hidden" id="searchCate" value="${searchProduct.cateCode}">
                <div id="filter-group" data-type="filterSticky" class="">
                    <div id="div-category">
                        <dl id="opt-category" class="filter-wrap">
                            <div class="sticky-warp" style="height: 45px;">
                                <dt class="title"><strong>카테고리</strong></dt>
                            </div>
                            <dd id="filter-category">
                                <ul>
                                    <li class="on">
                                        <a id="category_${parentCategory.cate_code}" data-category="${parentCategory.cate_code}">${parentCategory.cate_name}</a>
                                        <ul parent-category="${parentCategory.cate_code}">
                                            <c:forEach items="${subCategoryList}" var="subCate">
                                                <li class="gui-check ${subCate.cate_code == searchProduct.cateCode ? 'on' : ''}">
                                                    <input type="checkbox" name="category"
                                                           id="category_${subCate.cate_code}"
                                                           value="${subCate.cate_code}" data-title="${subCate.cate_name}" onchange="searchCateToggle()" ${subCate.cate_code == searchProduct.cateCode ? 'checked' : ''}>
                                                    <label for="category_${subCate.cate_code}"><i></i>${subCate.cate_name}</label>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </ul>
                            </dd>
                        </dl>
                    </div>
<%--                    <div id="div-brand">--%>
<%--                        <dl id="opt-brand" class="filter-wrap">--%>
<%--                            <div class="sticky-warp" style="height: 45px;">--%>
<%--                                <dt class="title"><strong>브랜드</strong></dt>--%>
<%--                            </div>--%>
<%--                            <dd id="filter-brand">--%>
<%--                                <ul>--%>
<%--                                    <li class="gui-check ">--%>
<%--                                        <input type="checkbox" id="brand_1175" name="brand" value="1175"--%>
<%--                                               data-title="정관장">--%>
<%--                                        <label for="brand_1175"><i></i>정관장 <span class="cnt">(102)</span></label>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                                <a id="brandLayer_open" class="gui-btn btn-more"><span>브랜드 더보기</span><i--%>
<%--                                        class="sprite-arr-right_m"></i></a>--%>
<%--                            </dd>--%>
<%--                        </dl>--%>
<%--                    </div>--%>
                    <div id="div-size"></div>
                    <div id="div-price">
                        <dl id="opt-price" class="filter-wrap">
                            <div class="sticky-warp" style="height: 45px;">
                                <dt class="title"><strong>가격</strong></dt>
                            </div>
                            <dd id="filter-price">
                                <div id="price-range" data-min="3500" data-max="990000" data-unit="60000">
                                    <a href="javascript:;" data-price="3500-60000" id="price_3500-60000"
                                       data-title=" ~ 6만원"> ~ 6만원</a>
                                    <a href="javascript:;" data-price="60000-120000" id="price_60000-120000"
                                       data-title="6만원 ~ 12만원">6만원 ~ 12만원</a>
                                    <a href="javascript:;" data-price="120000-240000" id="price_120000-240000"
                                       data-title="12만원 ~ 24만원">12만원 ~ 24만원</a>
                                    <a href="javascript:;" data-price="240000-990000" id="price_240000-990000"
                                       data-title="24만원 ~ ">24만원 ~ </a>
                                </div>
                            </dd>
                        </dl>
                    </div>
                </div>
            </aside>
            </form>
            <div id="content-main">
                <div id="prd-content">
                    <section id="filter-sort">
                        <div class="radio-tab">
            <span class="gui-radio">
				<input type="radio" name="sortType" id="sortType5" value="recent" checked="" onclick="changeOrderType(this.value)">
				<label for="sortType5"><i></i>최근등록순</label>
			</span>
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType1" value="popular" onclick="changeOrderType(this.value)">
				<label for="sortType1"><i></i>인기순</label>
			</span>
                            <span class="gui-radio">
				<input type="radio" name="sortType" id="sortType2" value="minPrice" onclick="changeOrderType(this.value)">
				<label for="sortType2"><i></i>낮은가격순</label>
			</span>
                            <span class="gui-radio">
				<input type="radio" name="sortType" id="sortType3" value="maxPrice" onclick="changeOrderType(this.value)">
				<label for="sortType3"><i></i>높은가격순</label>
			</span>
        </div>

        <aside class="aside">
			<span class="btn-group">
				<span class="btn-radio">
					<input type="radio" name="filterView" id="filterView1" class="blind" value="Y" checked="">
					<label class="gui-btn icon small" for="filterView1"><i class="sprite-cate-view">필터열기</i></label> 
				</span>
				<span class="btn-radio">
					<input type="radio" name="filterView" id="filterView2" class="blind" value="N">
					<label class="gui-btn icon small" for="filterView2"><i class="sprite-cate-view2">필터접기</i></label> 
				</span>
			</span>
        </aside>

                    </section>

                    <div id="productContainer">

                    </div>

                </div>

            </div>
        </div>
    </main>
</div>

<%--<div id="gshTrmLayer"></div>--%>
<%--<div id="gsrIntgLayer"></div>--%>

<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/common.min.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/base.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/filter.min.js"></script>
<script>
	$(document).ready(
		function() {
			var n = $("#breadcrumb");
			n.on("mouseenter", ".gui-btn", function() {
				var n = $(this).parent(".item");
				n && n.addClass("on").siblings().removeClass("on")
			}),
			n.on("mouseleave", function() {
				n.children(".on").removeClass("on")
			})

            getList(1);
        }
	);

    function getParameter() {
        var result = '?';
        if ($('#page').val() !== '') {
            result += 'page='+$('#page').val()
        } else {
            result += 'page=1'
        }
        if ($('#pageSize').val() !== '') {
            result += '&pageSize='+$('#pageSize').val()
        }
        if ($('#orderType').val() !== '') {
            result += '&orderType='+$('#orderType').val()
        }
        if ($('#minPrice').val() !== '') {
            result += '&minPrice='+$('#minPrice').val()
        }
        if ($('#maxPrice').val() !== '') {
            result += '&maxPrice='+$('#maxPrice').val()
        }
        if ($('#keyword').val() !== '') {
            result += '&keyword='+$('#keyword').val()
        }
        if ($('#searchCate').val() !== '') {
            result += '&searchCate='+$('#searchCate').val()
        }
        return result;
    }

    function getList(page) {
        if (page !== 0) {
            $('#page').val(page);
        }
        var listContainer = $("#productContainer");
        var cateCode = $('#cateCode').val();
        var param = getParameter();
        var url = "/product/"+cateCode+"/list"+param;
        $.ajax({
            url : url,
            type : "GET",
            success : function(html){
                listContainer.empty();
                listContainer.append(html);
            }
        });
    }

    function changeOrderType(orderType) {
        $('#orderType').val(orderType);
        getList(0);
    }

    function searchCateToggle() {
        let categoryBoxs = $("input[name='category']:checked");
        let cateCodes = [];
        categoryBoxs.each(function (e, cate) {
            cateCodes.push(cate.value);
        })
        let searchCate = cateCodes.join();
        $('#searchCate').val(searchCate);
        getList(1);
    }

</script>

