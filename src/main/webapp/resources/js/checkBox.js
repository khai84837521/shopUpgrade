$(document).ready(function() {


	calculer();

	// $('.minus').click(function () {spinnerUpDown("minus")})

	// $('.plus').click(function () {spinnerUpDown("plus")})

	// $('#topQuantitySpinner').keyup(function () {spinnerUpDown(null)})


});


function CartdeleteOne(item){
		var memberId = $("#deleteAll").val();
		var cartId = parseInt($("#cartId").val());
		alert(cartId);
		var params = cartId +"/"+memberId
		$.ajax({
		type: 'DELETE', //요청 메소드 방식
		url:'cart/deleteProduct/'+params,
		async: false, // ajax 통신이 끝날때까지 기다리기
		success : function(cartCount){
			$(item).parents(".cart_goods_box").remove();
			calculer();
		}
	});

}



function CartdeleteAll(){
	var memberId = $('#deleteAll').val();

	$.ajax({
		type: 'DELETE', //요청 메소드 방식
		url: 'cart/deleteAllProduct/' + memberId,

		success: function (result) {
			$(".cart_goods_box").remove();
			calculer();
		}
	});

}


function addCart(){
	var addCartParam = $('#addCartParam').serialize();
	var amount = "&amount="+$('#topQuantitySpinner').val();
	var cartDTO = addCartParam + amount;
	$.ajax({
	    url : "/cart/add",
	    type : "POST",
	    data : cartDTO,
	    dataType : 'json',
	    async: false,
	    success : function(cartCount){
			$('#cartCount').empty();
	        $('#cartCount').append(cartCount);
	    }
	});
}



function spinnerUpDown(type){

	let amount = $('.productAmount');
	switch (type) {
		case 'plus':
			amount.val(parseInt(amount.val()) + 1);
			break;
		case 'minus':
			amount.val(parseInt(amount.val()) - 1)
			break;
	}
	if(parseInt(amount.val()) > 20){
		amount.val(20);
	}else if(parseInt(amount.val()) < 1){
		parseInt(amount.val(1));
	}

}

function spinnerUp(item){
	var productAmount = $(item).prev().find($('.productAmount'));
	var amount = parseInt(productAmount.val());


	if(amount >= 20){
		productAmount.val(20);
	}else{
		productAmount.val(amount + 1)
	}
	cartUpdate(productAmount);
}

function spinnerDown(item){
	var productAmount = $(item).next().find($('.productAmount'));
	var amount = parseInt(productAmount.val());
	productAmount.val(amount -1)

	if(amount <= 1){
		productAmount.val(1);
	}else{
		productAmount.val(amount - 1)
	}
	cartUpdate(productAmount);
}

function spinerInsert(item){
	var productAmount = $(item);
	var amount = parseInt(productAmount.val());

	if(amount >= 20) {
		productAmount.val(20);
	}else if(amount <= 1){
		productAmount.val(1);
	}
	cartUpdate(productAmount);
}


function cartUpdate(productAmount){
	var amount = parseInt(productAmount.val());
	var cartId = productAmount.parents('.cart_goods_box').find('#cartId').val();
	var thisCartGoodsBox  = productAmount.parents('.cart_goods_box');
	var price = parseInt(thisCartGoodsBox.find($('.price_mo>b')).text().replace("￦", "").replace(",", ""));
	var totalPrice = thisCartGoodsBox.find($('.total_p>b'));

	$.ajax({
		url : "cart/countUpdate",
		type : "PUT",
		data : JSON.stringify({
			"cartId" : cartId,
			"amount" : amount
		}),
		dataType: 'text',
		contentType : "application/json;charset=UTF-8",
		success : function(updateCount){
			if(updateCount > 0){
				totalPrice.text(wonFomatter(price*amount));
			}
		}
	});
}

function wonFomatter(item){
	var wonFormat = "￦"+item.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
	return wonFormat;
}

function calculer(){
	var checkedProduct = $(".goods_chk").find($('input[name=product]:checked'));
	// var cartCount = checkedProduct.parents($('.cart_goods_box'));
	var productPrice = 0;

	$('.pnum').find($('.con')).find($('b')).text(checkedProduct.length);
	$('#cartListSize').text(checkedProduct.length);

	checkedProduct.each(
		function (){
			productPrice += parseInt($(this).parents($('.cart_goods_box')).find($('.productAmountPrice')).val());
		}
	)
	// productPrice = "￦"+productPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	productPrice = wonFomatter(productPrice);
	$('.price').find($('.con')).find($('b')).text(productPrice);
	$('.price_total').find($('.con')).find($('b')).text(productPrice);
}

function allCheck(){
	if($('.btn_select_all').is(":checked") == true){
		$('input[name=product]').each(
			function(){
				$(this).prop("checked", true);
			}
		)
	}else{
		$('input[name=product]').each(
			function(){
				$(this).prop("checked", false);
			}
		)
	}
	calculer();
}

function doCheck(){
$('input[name=product]').each(
	function(){
		if($(this).is(":checked") == false){
			$('.btn_select_all').prop("checked", false);
			return false;
		}else{
			$('.btn_select_all').prop("checked", true);
		}

	}
)
	calculer();
}

function test(item){
	alert($(item).val());
}