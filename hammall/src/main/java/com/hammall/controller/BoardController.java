package com.hammall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hammall.domain.BoardVO;
import com.hammall.domain.MemberVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.PageDTO;
import com.hammall.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor  // 클래스의 모든 필드를 대상으로 파라미터를 구성하여, 생성자메서드 생성
public class BoardController {

	private BoardService boardService;
	
	// 게시판 리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		// 1) 게시물 데이터
		model.addAttribute("list", boardService.getListWithSearchPaging(cri));
		
		int total = boardService.getTotalCount(cri);
		
		// 2) 페이징정보.
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	// 글쓰기 폼
	@GetMapping("/register")
	public void register() throws Exception{
		log.info("...게시판 글쓰기");
	}
	
	
	// 글저장 -> 리스트
	@PostMapping("/register")
	public String register(BoardVO board, HttpSession session) throws Exception{
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		board.setMb_id(mb_id);
		
		boardService.brd_insert(board);
		
		return "redirect:/board/list";
	}
	
	
	// 글조회, 수정폼
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("brd_num") Long brd_num,@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		log.info("...선택번호" + brd_num);
		model.addAttribute("board", boardService.brd_read(brd_num));
		
	}
	
	// 수정하기 -> 리스트
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
		boardService.brd_update(board);
		
		// 1)rttr.addFlashAttribute("msg", 값) : 
		// 설명> /board/list 주소에서 사용하는 View(JSP)에 데이터 전달
		// 내부적으로 세션으로 저장했다가 뷰에서 사용하고 즉시 소멸되는 정보(일회성). 
		
		rttr.addFlashAttribute("result", "modify");  // list.jsp에서 참조
		
		// 2)rttr.addAttribute(null, rttr)
		// 설명> /board/list 주소에 파라미터 형태로 전달.
		
		// /board/list 주소의 메서드에서 참조.
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	
	// 게시물 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("brd_num") Long brd_num, Criteria cri, RedirectAttributes rttr) throws Exception{
		
		boardService.brd_delete(brd_num);
		
		rttr.addFlashAttribute("result", "remove");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	
	
}
