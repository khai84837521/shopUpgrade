<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko" class="win10 pc chrome v105.0.0.0"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">




	<link id="gs-icon-font" rel="stylesheet" href="${pageContext.request.contextPath}/resources/testResource/style.css">
	

<title>홍삼 - GS SHOP</title>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/testResource/common.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/testResource/shop.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/common.min.js"></script>





</head>
<body class="flexible">
<div id="doc-container">


				<!-- 로케이션 -->
	<section id="doc-location">
		<div class="doc-wrap">
			<div id="breadcrumb">
				<script>
					$(document).ready(function() {



						var item = $('.item');
						alert($(item[2]).text());

						for(var i=0; i<item.length; i++){
							// alert(i);

							for(var j=0; j<$(item[i]).find("li").length; j++){

								// alert($(item[i]).find($("li")[j]).find("a").text());
								// if($(this).attr('href') === $(item[i]).find('.hoverline').attr('href')){
								// 	alert($(item[i]).find($("li"[j])).length);
								// }
							}
						}

						$('.item').hover(
								function (){
									$(this).addClass(" on")
								},
								function (){
									$(this).removeClass(" on")
								}
						)

					})

				</script>
				<span class="item">
					<a class="hoverline" href="https://www.gsshop.com/index.gs?svcid=gc&amp;lseq=404864">홈</a>
				</span>


				<span class="item">식품</span>
								
				
				
				<span class="item">
					<a class="hoverline" href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865">건강식품</a>
					
					<button class="gui-btn icon mini">
                        <span class="sprite-arr-down_s">카테고리 더보기</span>
                    </button>
					<div class="cate-layer">
						<ul>
							<li class=""><a href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865"><span>123</span></a></li>
                            <li class=""><a href="https://www.gsshop.com/shop/jbp/grandJbp.gs?jbpBrandCd=1000003523&amp;lseq=404866&amp;gsid=Sect-0-0-1"><span>유어스</span></a></li>
                            <li class=""><a href="https://www.gsshop.com/shop/jbp/grandJbp.gs?jbpBrandCd=1000003523&amp;lseq=404866&amp;gsid=Sect-0-0-1"><span>유어스</span></a></li>
						</ul>
					</div>
					
				</span>


				<span class="item">
					<a class="hoverline" href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865">건강식품</a>

					<button class="gui-btn icon mini">
                        <span class="sprite-arr-down_s">카테고리 더보기</span>
                    </button>
					<div class="cate-layer">
						<ul>
							<li class=""><a href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865"><span>123</span></a></li>
                            <li class=""><a href="https://www.gsshop.com/shop/jbp/grandJbp.gs?jbpBrandCd=1000003523&amp;lseq=404866&amp;gsid=Sect-0-0-1"><span>유어스</span></a></li>
                            <li class=""><a href="https://www.gsshop.com/shop/jbp/grandJbp.gs?jbpBrandCd=1000003523&amp;lseq=404866&amp;gsid=Sect-0-0-1"><span>유어스</span></a></li>
						</ul>
					</div>

				</span>


				<span class="item">
					<a class="hoverline" href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865">홍삼</a>

					<button class="gui-btn icon mini">
                        <span class="sprite-arr-down_s">카테고리 더보기</span>
                    </button>
					<div class="cate-layer">
						<ul>
							<li class=""><a href="https://www.gsshop.com/shop/sect/sectL.gs?sectid=1462672&amp;lsectid=1462672&amp;lseq=404865"><span>kkkk</span></a></li>
                            <li class=""><a href="https://www.gsshop.com/shop/jbp/grandJbp.gs?jbpBrandCd=1000003523&amp;lseq=404866&amp;gsid=Sect-0-0-1"><span>jjjj</span></a></li>
						</ul>
					</div>

				</span>

								
				
			</div>	
		</div>
	</section><!--// doc-location -->
		

	<main id="doc-contents">
		<div class="doc-wrap">
			<h2 class="shop-title">홍삼
				
			</h2>
			
			<aside id="content-aside">
	<div id="filter-group" data-type="filterSticky" class="">
	
			
		<div id="div-category">
			<dl id="opt-category" class="filter-wrap">
	<div class="sticky-warp" style="height: 45px;"><dt class="title"><strong>카테고리</strong></dt>
	</div>
	<dd id="filter-category">
			
		<ul>
		
		
			<li class="on">
							
					
						<a id="category_1462672_1463159" data-category="1462672_1463159">홍삼</a>
					
				
				
				
					
						<ul parent-category="1462672_1463159">
														
													
									
								<li class="gui-check on">
									<input type="checkbox" name="category" id="category_1462672_1463159_1463160" value="1462672_1463159_1463160" data-title="홍삼정(농축액)">
									<label for="category_1462672_1463159_1463160"><i></i>홍삼정(농축액)</label>
								</li>

                                <li class="gui-check on">
                                    <input type="checkbox" name="category" id="category">
                                    <label for="category"><i></i>(농축액)</label>
                                </li>

						</ul>
					
				
			</li>
		
		</ul>
		
				
				
	</dd>
</dl>
		</div>
		
		
		<div id="div-brand">
		
			<dl id="opt-brand" class="filter-wrap">
	<div class="sticky-warp" style="height: 45px;"><dt class="title"><strong>브랜드</strong></dt></div>
	<dd id="filter-brand">
		<ul>
					
							
				<li class="gui-check ">
					<input type="checkbox" id="brand_1175" name="brand" value="1175" data-title="정관장">
					
						<label for="brand_1175"><i></i>정관장 <span class="cnt">(102)</span></label>
					
				</li>				

		</ul>

			<a id="brandLayer_open" class="gui-btn btn-more"><span>브랜드 더보기</span><i class="sprite-arr-right_m"></i></a>
			
		
	</dd>
</dl>
							
		
		</div>

		<div id="div-size">
		
		</div>					
		
		<div id="div-price">

		
			<dl id="opt-price" class="filter-wrap">
	
	
	<div class="sticky-warp" style="height: 45px;"><dt class="title"><strong>가격</strong></dt></div>
	<dd id="filter-price">
		<div id="price-range" data-min="3500" data-max="990000" data-unit="60000">
			
			<a href="javascript:;" data-price="3500-60000" id="price_3500-60000" data-title=" ~ 6만원"> ~ 6만원</a>
			
			<a href="javascript:;" data-price="60000-120000" id="price_60000-120000" data-title="6만원 ~ 12만원">6만원 ~ 12만원</a>
			
			<a href="javascript:;" data-price="120000-240000" id="price_120000-240000" data-title="12만원 ~ 24만원">12만원 ~ 24만원</a>
			
			<a href="javascript:;" data-price="240000-990000" id="price_240000-990000" data-title="24만원 ~ ">24만원 ~ </a>
			
		</div>
	</dd>
	
	
</dl>

		
		</div>		

	</div>
</aside>
		
			<div id="content-main">
						


<div id="prd-content">

	<section id="filter-sort">
		<div class="radio-tab">
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType1" value="DEFAULT" checked="">
				<label for="sortType1"><i></i>인기순</label>
			</span>
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType2" value="LOW_PRICE">
				<label for="sortType2"><i></i>낮은가격순</label>
			</span>
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType3" value="HIGH_PRICE">
				<label for="sortType3"><i></i>높은가격순</label>
			</span>
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType4" value="REVIEW_COUNT">
				<label for="sortType4"><i></i>상품평 많은순</label>
			</span>
			<span class="gui-radio">
				<input type="radio" name="sortType" id="sortType5" value="REG_DATE">
				<label for="sortType5"><i></i>최근등록순</label>
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

			<div id="small-pg-ctrl" class="pg-ctrl-box">
				<a class="gui-btn small icon  prev disabled" role="button"><i class="sprite-arr-left">이전</i></a>
				<span class="pagination" id="shortPaging"><strong>1</strong>/10</span>
				<a class="gui-btn small icon  next" role="button"><i class="sprite-arr-right">다음</i></a>
			</div>
		</aside>
	
	</section>	
				

<div id="searchPrdList">
		

	
	<section class="prd-list">
		<ul>
		
					<li>
			
			
			<a href="https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1&amp;lseq=405302" class="prd-item" data-prdid="66172344" onclick="PrdObject.setLatestViewedPrd(this);">
				<div class="prd-img">
				
					<img >
				

					
                    

					
					<span class="badge-abs">
					</span>
					

					<span class="toggle-zzim" id="toggle-zzim_66172344">찜완료</span>
					
					
<%--					<button class="link-new-tab" onclick="PrdObject.openNewTab(&#39;https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1&amp;lseq=405302&#39;); return false;"><i class="sprite-new-tab"></i>새창 열기</button>--%>
					
					
					
				</div>


				<dl class="prd-info">
								
										<dt class="prd-name">
						
							
								
							
						[정관장]홍삼정에브리타임밸런스(10ml x 30포) /5+1박스
					</dt>
					
					
										<dd class="price-info" data-exposprctypcd="2" data-exposprdtypcd="P" data-consultproduct="false" data-rentprc="0">
						
							
							
						
	
						<span class="price">
							
								
									
									
										
									
									<span class="set-price"><strong>486,000</strong>원</span>

									
								
						</span><!-- //price -->
					</dd>
					
					

					<dd class="user-side">
						
										<button class="user-comment" data-link="https://www.gsshop.com/prd/prd.gs?prdid=66172344&amp;sectid=1463159&amp;lsectid=1462672&amp;msectid=1463159&amp;rank=1" onclick="PrdObject.gotoPrdRevw(this); return false;">상품평 408</button>
										
									
								
							
						
						
						
						<button class="my-wish " onclick="PrdObject.toggleWish(this); return false;" id="wishPrdButton_66172344">찜하기</button>
						
					</dd>				
					
					<dd class="advantage">
						<div>
						 
								 
									<span>무료배송</span>
								
							
						</div>
					</dd>
				</dl>
			</a>
		</li>
		

		</ul>
	</section>


	</div>			
	<!-- 상품 리스트 끝 -->

	<!-- 상품 하단 페이징 시작 -->
	<div id="pageNavigation">
		<nav class="paging">
			<span class="blind">현재</span>
			<strong>1</strong>
			<span class="blind">페이지</span>
			<a data-index="2">2</a><span class="blind">페이지</span>
			<a data-index="3">3</a><span class="blind">페이지</span>
			<a data-index="4">4</a><span class="blind">페이지</span>
			<a data-index="5">5</a><span class="blind">페이지</span>
			<a data-index="6">6</a><span class="blind">페이지</span>
			<a data-index="7">7</a><span class="blind">페이지</span>
			<a data-index="8">8</a><span class="blind">페이지</span>
			<a data-index="9">9</a><span class="blind">페이지</span>
			<a data-index="10">10</a><span class="blind">페이지</span>
		</nav>
	</div>
	
	</div> 					

</div> 
			
		</div> 
	</main>
	
	
</div> 







<%--<div id="gshTrmLayer"></div>--%>


<%--<div id="gsrIntgLayer"></div>--%>






<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/common.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/base.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/filter.min.js"></script>


