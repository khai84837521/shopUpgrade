<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
 
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>GH SHOP</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sub.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/check.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/address_daum.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script async defer crossorigin="anonymous" src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v10.0&appId=4210045182434131" nonce="SiOBIhLG"></script>
</head>

<body>
					
<div class="resp_member_join_wrap">
	<div class="member_tit"><h1 class="sub_tit">회원가입</h1></div>
	<form name="" id="registFrm" method="post" action="${pageContext.request.contextPath}/joinPro" onsubmit = "return join()">
		<div id="formMemberArea" class="resp_member_join">
			<div class="resp_join_table">
				
				<input type="hidden" value='<c:out value="${userInfo.memId}"/>' id="userid" name="memId">
				
				<input type="hidden" value='0000' id="pass" name="memPw">
				
				<input type="hidden" value='0000' id="pass2" name="re_password">
				
				
				<ul class="required">
					<li class="th">
						<p designelement="text" textindex="22">이름</p>
					</li>
					<li class="td"><input type="text" id = "name" name="memNm" placeholder="이름" autocomplete="off" onblur = "require($('#name').val(), $('#check_name_msg'))"
					value="<c:out value="${userInfo.name}"/>" >
					<br><span id="check_name_msg"></span><br>
					</li>
				</ul>
				
				<ul class="required">
					<li class="th">
						<p designelement="text" textindex="22">생년월일</p>
					</li>
					<li class="td"><input type="text" id = "birthDt" name="birthDt" placeholder="생년월일" autocomplete="off" onblur = "require($('#birthDt').val(), $('#check_birthDt_msg'))"
					value="<c:out value="${userInfo.birthday}"/>">
					<br><span id="check_birthDt_msg"></span><br>
					</li>
				</ul>
				
				
				<ul class="required">
					<li class="th">
						<p designelement="text" textindex="28">이메일</p>
					</li>
					<li>
						<div class="ip_h_cer">
							<input type="email" id = email name="email" placeholder="이메일" onblur = "require($('#email').val(), $('#check_email_msg'))"
							value="<c:out value="${userInfo.email}"/>">
						</div>
					</li>
				</ul>
				<br>
				<ul class="required" style="display:none;">
					<li class="th">
						<p designelement="text" textindex="21">휴대폰번호</p>
					</li>
				</ul>
				<ul>
					<li>
						<input type="tel" id="bcellphone" name= "phone" placeholder="휴대폰번호" onblur = "require($('#bcellphone').val(), $('#check_phone_number_msg'))"
						value="<c:out value="${userInfo.mobile}"/>">
						<br><span id="check_phone_number_msg"></span><br>
					</li>
				</ul>
				<br>
				<ul class="required">
					<li class="th">
						<p designelement="text">주소</p>
					</li>
					<span style = "font-weight: bold">
						주소	
					</span>
					
					
					<li>
						<div class="ip_h_cer">
							<input type="text" id="sample6_postcode" name = "zipcode" placeholder="우편번호">
							<input type="button" class="btn_h_cer" value="우편번호 찾기" onclick="sample6_execDaumPostcode()" >
						</div>
					</li>
					
					<li class="td">
						<input type="text" id="sample6_address" name = "address" placeholder="주소" onblur = "require($('#sample6_address').val(), $('#check_address_msg'))">
					</li>
					<li class="td">
						<input type="text" id="sample6_detailAddress" name = "addressSub" placeholder="상세주소">
					</li>
					<li class="td">
						<input type="text" id="sample6_extraAddress" name = "addressReference" placeholder="참고항목">
					</li>
					<li>
						<br><span id="check_address_msg"></span><br>
					</li>
				</ul>
				
				
			</div><!--resp_join_table-->
			<div class="resp_login_wrap Mt0">
				<input type="hidden" name="join_type" value="business">
				<div class="mem_agree_area" style="display:block;">

					<ul id="agreeList" class="agree_listbox">
						<li>
							<div><input type="checkbox" name="agree" value="Y" class="pilsu" id="ab_chkAll"><label for="ab_chkAll"><span class="desc" designelement="text" textindex="30">(필수)</span> <span designelement="text" textindex="31">이용약관에 모두 동의합니다.</span></label></div>
							<ul>
								<li><div>서비스 이용약관</div><a class="agree_view" href="" onclick=""><span designelement="text" textindex="32" >내용보기</span></a></li>
								<li><div>개인정보 수집/이용</div><a class="agree_view" href="" onclick=""><span designelement="text" textindex="33">내용보기</span></a></li>

							</ul>
						</li>					
					</ul>
				</div>
			</div><!--resp_login_wrap-->
		</div><!--formMemberArea-->
		<div class="btnArea">
			<button type="submit" class="btnSSG btnL action" id="authNoBtn">회원가입하기</button>
			
			<a href = "${pageContext.request.contextPath}/main">
				<button type="button" class="btnSSG btnR cancel" id="">취소</button>
			</a>
		</div><!--btnArea-->
	</form><!--registFrm-->
</div><!-- resp_member_join_wrap -->




</body>
</html>
