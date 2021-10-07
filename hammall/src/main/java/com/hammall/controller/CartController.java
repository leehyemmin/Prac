package com.hammall.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hammall.domain.CartVO;
import com.hammall.domain.MemberVO;
import com.hammall.service.CartService;
import com.hammall.util.FileUploadUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
@RequestMapping("/cart/*")
public class CartController {

	@Setter(onMethod_ = @Autowired)
	private CartService cartService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	
	// 장바구니 추가
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<String> add_cart(@RequestParam(required = false) Long prod_num,@RequestParam(required = false) Integer prod_amount, HttpSession session, HttpServletResponse response) throws Exception{
//		log.info("cart_add" + prod_num);
//		log.info("cart_add" + prod_amount);
		
		ResponseEntity<String> entity = null;
		
		if(session.getAttribute("loginStatus") == null) {
			entity = new ResponseEntity<String>("LoginRequired", HttpStatus.OK);
			
			return entity;
		}
		
		//loginStatus
		MemberVO vo = (MemberVO)session.getAttribute("loginStatus");
		
		CartVO cart = new CartVO(0, prod_num, vo.getMb_id(), prod_amount);
		
		log.info("장바구니 : " + cart);
		
		try {
			cartService.add_cart(cart);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 장바구니 리스트
	@GetMapping("/cart_list")
	public void cart_list(HttpSession session, Model model) throws Exception{
		log.info("장바구니 리스트");
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		model.addAttribute("cartVOList", cartService.list_cart(mb_id));
	}
	
	// 상품 이미지 뷰
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		return FileUploadUtils.getFile(uploadPath, fileName);
	}
	
	// 수량 변경
	@ResponseBody
	@PostMapping("/cart_amount_update")
	public ResponseEntity<String> cart_amount_update(int cart_code, int cart_amount) throws Exception{
		log.info("...상품 수량 변경");
		
		ResponseEntity<String> entity = null;
		
		try {
			cartService.cart_amount_update(cart_code, cart_amount);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 상품 삭제
	@ResponseBody
	@PostMapping("/delete")
	public ResponseEntity<String> delete_cart(long cart_code) throws Exception{
		log.info("...상품 삭제");
		
		ResponseEntity<String> entity = null;
		
		try {
			cartService.delete_cart(cart_code);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 장바구니 비우기
	@GetMapping("/cart_all_delete")
	public String cart_all_delete(HttpSession session) throws Exception{
	
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		cartService.cartAll_delete(mb_id);
		
		return "redirect:/cart/cart_list";
	}
	
	// 선택상품 삭제
	@ResponseBody
	@PostMapping("/cart_check_delete")
	public ResponseEntity<String> cart_check_delete(@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception{
		log.info("cart_check_delete: " + checkArr);
		 
		ResponseEntity<String> entity = null;
		
		try {
			cartService.cart_check_delete(checkArr);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	// 선택상품 주문
	@ResponseBody
	@PostMapping("/cart_check_order")
	public ResponseEntity<String> cart_check_order(@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception{
		log.info("cart_check_order: " + checkArr);
		
		ResponseEntity<String> entity = null;
		
		try {
			cartService.cart_check_order(checkArr);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	
	
	
	
}
