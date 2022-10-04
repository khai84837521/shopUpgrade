package com.shopUpdate.controller.cart;

import com.shopUpdate.domain.CartDTO;
import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Inject
    private CartService cartService;

    //장바구니 페이지
    @GetMapping
    public String myCart(@SessionAttribute("userInfo")MemberDTO memberDTO, Model model){
        String memberId = memberDTO.getMember_id();

        if(memberId != null){
            cartService.getCartList(memberId);
            CartView cartView = new CartView();
            model.addAttribute("cartCount",cartView.getCartCount());
            model.addAttribute("cartList", cartView.getCartList());
            return "member/cart";
        }else{
            model.addAttribute("url", "/member/login");
            model.addAttribute("msg", "로그인 후에 이용해주세요");
            return  "msgBox";
        }
    }

    //장바구니 추가
    //리스폰스바디로 헤더에 장바구니 물건 갯수 반환
    @PostMapping("/add")
    @ResponseBody
    public int add(CartDTO cartDTO){

        int cartCount = cartService.setCart(cartDTO);
        return cartCount;
    }

    //장바구니 물품 1개 삭제
    @DeleteMapping("/deleteProduct")
    @ResponseBody
    public int deleteProduct(String memberId, int cartId){
        int cartCount = cartService.deleteCart(memberId, cartId);
        return cartCount;
    }

    //장바구니 물품 모두 삭제
    @DeleteMapping("/deleteAllProduct")
    @ResponseBody
    public int deleteAllProduct(String memberId){
        int cartCount = cartService.deleteAllCart(memberId);
        return cartCount;
    }


    @PutMapping("/countUpdate")
    @ResponseBody
    public int countUpdate(CartDTO cartDTO){
        int cartCount = cartService.update(cartDTO);
        return cartCount;
    }
}
