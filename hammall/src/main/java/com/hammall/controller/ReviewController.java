package com.hammall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hammall.domain.MemberVO;
import com.hammall.domain.ReviewVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.ReviewPageDTO;
import com.hammall.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/review/*")
@AllArgsConstructor
public class ReviewController {

	//@AllArgsConstructor : 모든 필드에 생성자메서드가 생성이되고, 생성자는 어노테이션을 생략하고 자동으로 주입이된다.
	private ReviewService reviewService;
	
	// 상품후기목록(페이징기능 포함)
	@GetMapping(value = "/pages/{prod_num}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReviewPageDTO> getReviewListPage(@PathVariable("prod_num") int prod_num,@PathVariable("page") int page){
		
		ResponseEntity<ReviewPageDTO> entity = null;
		
		Criteria cri = new Criteria(page, 5);
		
		log.info("상품번호: " + prod_num);
		log.info("cri: " + cri);
		
		
		try {
			entity = new ResponseEntity<ReviewPageDTO>(reviewService.getReviewListWithPaging(cri, prod_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReviewPageDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	// 상품후기 등록
	@PostMapping("/review_register")
	public ResponseEntity<String> review_register(ReviewVO vo, HttpSession session) throws Exception{
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		vo.setMb_id(mb_id);
		
		log.info("review_register " + vo);
		
		ResponseEntity<String> entity = null;
		
		try {
			reviewService.review_register(vo);
			entity = new ResponseEntity<String> ("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String> (HttpStatus.BAD_REQUEST	);
		}
		
		return entity;
	}
	
	
	// 상품후기 수정
	@PostMapping("/review_modify")
	@ResponseBody
	public ResponseEntity<String> review_modify(ReviewVO vo) throws Exception{
		log.info("review_modify" + vo);
		
		ResponseEntity<String> entity = null;
		
		
		try {
			reviewService.review_modify(vo);
			entity = new ResponseEntity<String> ("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	// 상품후기 삭제
	@PostMapping("/review_delete")
	@ResponseBody
	public ResponseEntity<String> review_delete(int rev_num) throws Exception{
		log.info("review_delete" + rev_num);
		
		ResponseEntity<String> entity = null;
		
		
		try {
			reviewService.review_delete(rev_num);
			entity = new ResponseEntity<String> ("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
}
