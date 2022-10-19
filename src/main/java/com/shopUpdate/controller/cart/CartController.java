package com.shopUpdate.controller.cart;

import com.shopUpdate.common.enums.Message;
import com.shopUpdate.common.enums.RedirectUrl;
import com.shopUpdate.domain.CartDTO;
import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.service.cart.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Inject
    private CartService cartService;


    /**
     * 장바구니 페이지 매핑
     * @param memberDTO
     * @return 메세지 페이지 (msgBox.jsp)
     */
    @GetMapping
    public String myCart(@SessionAttribute("userInfo")MemberDTO memberDTO, Model model){
        String memberId = memberDTO.getMember_id();

        if(memberId != null){
            return "cart/cart";
        }else{
            model.addAttribute("url", RedirectUrl.LOGIN);
            model.addAttribute("msg", Message.MEMEBER_SESSION_NULL);
            return  "/msgBox";
        }
    }

    /**
     * 장바구니 상품목록 리스트 매핑
     * @param memberDTO
     * @return 장바구니 상품 목록 페이지
     */
    @GetMapping("cartList")
    public String cartList(@SessionAttribute("userInfo")MemberDTO memberDTO, Model model){
        String memberId = memberDTO.getMember_id();
        CartView cartView = CartView.builder()
                .cartCount(cartService.getCartCount(memberId))
                .cartList(cartService.getCartList(memberId))
                .build();
        model.addAttribute("cartCount",cartView.getCartCount());
        model.addAttribute("cartList", cartView.getCartList());
        return "cart/cartList";
    }

    /**
     * 장바구니 추가
     * @param cartDTO
     * @return 장바구니 상품 수
     */
    @PostMapping("/add")
    @ResponseBody
    public int add(CartDTO cartDTO){
        int cartCount = cartService.setCart(cartDTO);
        return cartCount;
    }

    /**
     * 장바구니 단일 상품 삭제
     * @param memberId
     * @param cartId
     * @return 장바구니 상품 수
     */
    @DeleteMapping("/deleteProduct/{cartId}/{memberId}")
    @ResponseBody
    public int deleteProduct(@PathVariable(name = "memberId") String memberId, @PathVariable(name = "cartId") Integer cartId){
        int cartCount = cartService.deleteCart(memberId, cartId);
        return cartCount;
    }

    /**
     * 장바구니 전체 상품 삭제
     * @param memberId
     * @return 장바구니 상품 수
     */
    @DeleteMapping("/deleteAllProduct/{memberId}")
    @ResponseBody
    public int deleteAllProduct(@PathVariable String memberId){
        int cartCount = cartService.deleteAllCart(memberId);
        return cartCount;
    }

    /**
     * 장바구니 상품 갯수 변경
     * @param cartDTO
     * @return 업데이트 된 행 갯수
     */
    @PutMapping("/countUpdate")
    @ResponseBody
    public int countUpdate(@RequestBody CartDTO cartDTO){
        int updateCount = cartService.update(cartDTO);
        return updateCount;
    }
}
