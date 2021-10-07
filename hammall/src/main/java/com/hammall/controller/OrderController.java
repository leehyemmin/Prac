package com.hammall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hammall.domain.CartVOList;
import com.hammall.domain.MemberVO;
import com.hammall.domain.OrderDetailListVO;
import com.hammall.domain.OrderDetailVO;
import com.hammall.domain.OrderVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.PageDTO;
import com.hammall.service.CartService;
import com.hammall.service.OrderService;
import com.hammall.service.UserProductService;
import com.hammall.util.FileUploadUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/order/*")
public class OrderController {

	@Setter(onMethod_ = @Autowired)
	private OrderService orderService;
	
	@Setter(onMethod_ = @Autowired)
	private CartService cartService;
	
	@Setter(onMethod_ = @Autowired) 
	private UserProductService userProductService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	// @RequestParam(required = false) : get요청에 의한 쿼리스트링이 존재하지않아도 처리하고자할때 사용(예외발생이 안됨)
	// 주문하기
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public void order(HttpSession session,@ModelAttribute("type") String type, @RequestParam(required = false) Long prod_num , @RequestParam(required = false) Integer ord_amount, Model model) throws Exception{
		
		// type : 1-즉시구매(장바구니 사용안함), 2- 장바구니 기반으로 주문하기
		
		// 사용자별 장바구니 내역
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		
		if(type.equals("1")) {
			log.info("즉시구매" + type);
			
			// 구매상품에 대한 정보를 표시
			ProductVO vo = userProductService.getProductByNum((long)prod_num);
			
			
			// 매개변수가 있는 생성자를 만들어서, 디폴트생성자 처리해줄것.
			CartVOList cartvo = new CartVOList(0, vo.getProd_img(), vo.getProd_name(), (int)ord_amount, vo.getProd_price());
			
			List<CartVOList> cartvoList = new ArrayList<CartVOList>();
			cartvoList.add(cartvo);
			
			model.addAttribute("cartVOList", cartvoList);
			
			// 즉시구매시 상품상세정보를 폼에 삽입하기위한 Model작업
						model.addAttribute("prod_num", prod_num);
						model.addAttribute("ord_amount", ord_amount);
						model.addAttribute("ord_price", vo.getProd_price());
			
		}else if(type.equals("2")){
			log.info("장바구니 기반으로 사용" + type);
			// 그매싱품을 장바구니에서 가져와서 표시
			model.addAttribute("cartVOList", cartService.list_cart(mb_id));
			
			// 사용하지않는 값이지만, 주문하기 클릭을 하게되면 OrderDetailVO vo2 파라미터에서 에러발생이되므로 형식만 유지함.
			model.addAttribute("prod_num", 0);
			model.addAttribute("ord_amount", 0);
			model.addAttribute("ord_price", 0);
			
		}
		
	}
	
	
	// 상품이미지 뷰
	@ResponseBody
	@RequestMapping(value = "/displayFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		return FileUploadUtils.getFile(uploadPath, fileName);
	}
	
	
	// order.jsp에서 type파라미터 정보를 받아와야, 즉시구매, 장바구니를 통한 구매를 분기작업을 할수가 있다.
	// OrderDetailVO vo2 : 장바구니 경유에서 주문하기는 사용이 안된다.
	@PostMapping("/order_buy")
	public String order_buy(OrderVO vo, OrderDetailVO vo2, String type, HttpSession session) throws Exception{
		
		log.info("order_buy" + vo);
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		vo.setMb_id(mb_id);
		
		// 구분확인 할것
		if(type.equals("1")) {
			
			log.info("order: " + vo);
			log.info("orderDetail: " + vo2);
			 
			
			// 장바구니 테이블은 제외(즉시구매이므로 장바구니에 상품을 저장안함)
			// 주문, 주문상세테이블 작업 : prod_num, ord_amount, ord_price
			orderService.orderDirect_buy(vo, vo2);// 즉시구매한 상품구성 해줄것
		}else if(type.equals("2")) {
			
			
			// 주문, 주문상세(장바구니참조), 장바구니 삭제
			orderService.order_buy(vo, mb_id); 
		}
		
		return "redirect:/";
	}
	
	
	// 사용자 주문목록보기
	@GetMapping("/mb_order_list")
	public String mb_order_list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		log.info("mb_order_list: " + cri);
		
		model.addAttribute("mb_order_list", orderService.orderInfo_list(cri));
		
		int total = orderService.getTotalCountOrder(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		return "/order/mb_order_list";
	}
	
	// 사용자 주문상세보기
	@GetMapping(value = "/mb_deorder_list",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public ResponseEntity<List<OrderDetailListVO>> mb_deorder_list(Long ord_code) throws Exception{
		
		ResponseEntity<List<OrderDetailListVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<OrderDetailListVO>>(orderService.mb_deorder_list(ord_code), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<OrderDetailListVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
}
