<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>엉덩이가 큰 그녀</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/insertSearch.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sub.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/check.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/checkBox.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dd43a0e2b4.js" crossorigin="anonymous"></script>
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/cart.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/member.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<script src="https://kit.fontawesome.com/dd43a0e2b4.js"
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/check.js"></script>
    <link id="gs-icon-font" rel="stylesheet" href="${pageContext.request.contextPath}/resources/testResource/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/testResource/common.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/testResource/jquery.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/testResource/common.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/testResource/lb4gs.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/testResource/shop.min.css">
</head>

 
 <body>
 <div id="mainLayout">
 
    <header id="header">
            <div id="util">
                <div class="innerContent flex">
                    <div class="qbtn">
                        <ul>
                            <li class="tab01">
                                <a href="">즐겨찾기<span class="icon_bookmark"></span></a>
                            </li>
                            <li class="tab02">
                                <a href="${pageContext.request.contextPath}/main">GH SHOP CUSTOMER</a>
                            </li>
                        </ul>
                    </div>
                      <div class="util_menu">
                    	<c:choose>
                    	<c:when test ="${sessionScope.userInfo.member_id == null}">
	                    	<ul>
	                            <li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
	                            <li><a href="${pageContext.request.contextPath}/join">회원가입</a></li>
	                            <li onclick = "MSG()"><a href="${pageContext.request.contextPath}/login">마이페이지</a></li>
	                            <li onclick = "MSG()"><a href="${pageContext.request.contextPath}/login">고객센터</a></li>
	                        </ul>
                    	</c:when>
                    	<c:otherwise>
                    	<ul>
                            <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
                            <li><a>${sessionScope.userInfo.memNm}님</a></li>
                            <li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
                            <li><a href="${pageContext.request.contextPath}/board/flist">고객센터</a></li>
                        </ul>
                            <input type="hidden" id="memberId" value="${sessionScope.userInfo.member_id}">
                    	</c:otherwise>
                    	</c:choose>
                    </div>
                </div>
            </div>
            <div id="mid">
                <div class="innerContent">
                    <div id="layout_side" class="mobile layout_side">
           
                        <div class="menuSide">
               

                            <div class="right_cs">
                                <div class="tle">고객 센터</div>
                                <b>070-123-4567</b>
                                <div class="info info1">
                                    평일 : AM10:00 ~ PM17:00<br>
                                    점심 : PM12:00 ~ PM1:00<br>
                                    주말 및 공휴일 휴무
                                    <a href="" class="kakach"><img src="${pageContext.request.contextPath}/resources/images/kakach.jpg"></a>
                                </div>
                                <div class="tle">계좌 안내</div>
                                <div class="info info2">
                                    <img src="${pageContext.request.contextPath}/resources/images/qbnk.png">
                                    <strong>051-04542-5224-1</strong>
                                    예금주：아이티윌
                                </div>
                            </div>
                            <!-right_cs--->
                                <div class="aside_menu3">
                                    <ul>
                                        <li><a href="${pageContext.request.contextPath}/notice.jsp">공지사항</a></li>
                                        <li><a href="">EVENT</a></li>
                                    </ul>
                                </div>
                                <!--aside_menu3-->

                        </div><!-- mobile -->
                        <div class="menuBG"></div>

                    </div>
                    <!--mobile layout_side-->

                    <h1 class="hlogo">
                        <a href="${pageContext.request.contextPath}/main">GH SH<span>O</span>P</a>
                    </h1>
					 <!-- 인기검색어 -->
                            <table class="hot-Search">
								<tr>
									<td class="td1"><h2>실시간 검색 순위</h2></td>
									<td class="td2">
										<div class="swiper rankwrap">
											<div id="ranking" class="swiper-wrapper">
												${searchDTO.k}
											</div>
										</div>									
									</td>
								</tr>
							</table>
							

                    <div class="top_search">
                        <form name="frmSearchTop" id="frmSearchTop" action="${pageContext.request.contextPath}/sub" method="get" novalidate="novalidate" >
                            <input type="hidden"  value="" name="c">
                            <input type="hidden"  value="" name="l">
                            <input type="hidden"  value="" name="s">
                            <input type="hidden"  value="" name="e">
                            <input type="hidden"  value="" name="sK">
                            <fieldset>
                                <legend>검색폼</legend>
                                <div class="top_search_cont">
                                    <div class="top_text_cont">
                                        <input type="text" id="search_form" name="keyword" class="top_srarch_text" title="라이프앤밸러스 일상생활에 활력을" placeholder="라이프앤밸러스 일상생활에 활력을" autocomplete="off"
                                        value="${countMav.value}">
                                        <input type="image" src="${pageContext.request.contextPath}/resources/images/search_bt.png" id="btnSearchTop" class="btn_top_srarch" title="검색" value="검색" alt="검색">
										
                    <!-- Side widget-->
                                    </div>
                                    <!-- //top_text_cont -->
                                </div>
                                <!-- //top_search_cont -->
                            </fieldset>
                        </form>
                        <!-- 검색필터 추가 -->
				                    <div class="card mb-4" id="r_search" style="display: none;">
				                        <div class="card-header">추천검색어</div>
				                        <div class="card-body">
				                            <div class="row">
				                                <div class="col-sm-6">
				                                    <ul class="search-list">
				                                         <li ><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=비타민&s=&e=&sK=">비타민</a></li>
				                                         <li><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=칼슘&s=&e=&sK=">칼슘</a></li>
				                                         <li><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=유산균&s=&e=&sK=">유산균</a></li>
				                                    </ul>
				                                </div>
				                                <div class="col-sm-6">
				                                    <ul class="list-unstyled mb-0">
				                                       <li ><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=정관장&s=&e=&sK=">정관장</a></li>
				                                       <li><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=이만기&s=&e=&sK=">이만기</a></li>
				                                       <li><a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=건강&s=&e=&sK=">건강</a></li>
				                                    </ul>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="card-header" id="bottomcard" onclick="href='#'">브랜드검색</div>
				                    </div>
				             <!-- //검색필터 추가 -->
                  			  </div>

                    <div class="buttonArea">
                        <ul>                           
                            <li><a href="${pageContext.request.contextPath}/cart" class="cart">장바구니<span id="cartCount" class="count">${cartCount}</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="gnbw">
                <div class="innerContent">
                    <div id="categoryAll">
                        <a>
                            <div class="h_buger">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                            전체카테고리
                        </a>
                        <div class="categoryAll_abs">
                            <ul> 
                            	<!-- 전체상품 -->
                                <li class="cate6">
                               
                                    <a href="${pageContext.request.contextPath}/sub?c=&l=&keyword=&s=&e=&sK=">
                                        <span class="ca_i">
                                            <img src="${pageContext.request.contextPath}/resources/images/ca_ii.png">
                                        </span>
                                        <span class="ca_t">전체상품</span>
                                    </a>
                                </li>
                                <!-- 하위메뉴 -->
                                <c:forEach items = "${cateList}" var="mainCateList" varStatus="status">
                                <c:if test="${mainCateList.parent_cate_code == 0}">
                                <li class="cate0">
                                <!-- 대분류 -->
                                    <a href="${pageContext.request.contextPath}/sub?c=a&l=A&keyword=&s=&e=&sK=">
                                        <span class="ca_i">
                                            <img src="${pageContext.request.contextPath}/resources/images/ca_i${status.index}.png">
                                        </span>
                                        <span class="ca_t">${mainCateList.cate_name}</span>
                                    </a>
	                                    <ol>
			                                <c:forEach items="${cateList}" var="subCateList">
                                                <c:if test="${mainCateList.cate_code == subCateList.parent_cate_code}">
                                                 <li>
                                                     <a href="${pageContext.request.contextPath}/sub?c=${CartegoryDTO.cateCode}&l=B&keyword=&s=&e=&sK=">${subCateList.cate_name}</a>
                                                 </li>
                                                </c:if>
			                                </c:forEach>
	                                    </ol>

                                </li>
                                </c:if>
                                </c:forEach>
                            </ul>
                        </div>

                    </div>
                    <div class="gnbMenu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/sub_new" >NEW</a></li>
                            <li><a href="${pageContext.request.contextPath}/sub_best">TOP 100</a></li>
                        </ul>
                    </div>
                  
                </div>
            </div>
        </header><!-- header -->



 <script type="text/javascript">

     // <input type="button" value="dup. check" class="dup"> 클릭했을때
     // html 문서가 실행이 준비 되면 => 동작
     $(document).ready(function(){
         // 버튼을 클릭했을때
//  			alert("클릭이벤트");
         // idCheck2.jsp에 아이디를 들고 가서  아이디를 중복체크 아이디 중복, 아이디 사용가능 출력
         $.getJSON('${pageContext.request.contextPath}/mainRank',function(rdata){
             //#dupdiv 대상에  가져온 값을 출력
             $.each(rdata,function(index,item){
                 $('#ranking').append("<div class='swiper-slide rankitem'>"+item.keyword+"</div>");
             });

         });
     });




     /* 리스트 ajax */
     $(document).ready(function(){

         $.getJSON('${pageContext.request.contextPath}/test',function(dated){
             $.each(dated,function(index,item){

                 $('#middle').attr("src",item.imagePath); //이미지
                 $('.title').append(item.goodsNm); //상품명
                 $('.del').append(item.fixedPrice+"원");//정가
                 $('#middle').attr(index);//한번정지

             });//each
// 				$(this).unbind();
         }); //json
         //이벤트를 한번만 수행하고 멈춤
     });
     /* 끝 리스트 ajax */

     /* 인기검색어 슬라이드 넘어가기 */
     var swiper = new Swiper(".rankwrap", {
         direction: "vertical",
         autoplay: {
             delay: 1000,
             disableOnInteraction: false,
         },
         speed: 1000,
     });
 </script>