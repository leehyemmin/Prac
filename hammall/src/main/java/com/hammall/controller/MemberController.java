package com.hammall.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hammall.domain.MemberVO;
import com.hammall.dto.LoginDTO;
import com.hammall.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*") // 공통 경로. jsp파일 폴더명
public class MemberController {

	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	//private boolean isAuthCheck;
	
	@Inject
	private BCryptPasswordEncoder cryPassEnc;
	
	
	// 회원가입 폼
	@GetMapping("/join")
	public void join() {
		log.info("...회원가입");
	}
	
	
	// 회원가입
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberVO vo, RedirectAttributes rttr) throws Exception{
		
		log.info(vo);
		
		// 인증확인 체크작업
		//if(isAuthCheck == false) return "";
		
		// 암호화
		vo.setMb_pw(cryPassEnc.encode(vo.getMb_pw()));
		
		String result = "";
		service.join(vo);
		
		result = "insertSuccess";
		
		rttr.addFlashAttribute("status", result);
		
		return "redirect:/";
	}
	
	// 아이디 중복체크(ajax 요청)  /member/checkIdDuplicate
	@ResponseBody
	@RequestMapping(value = "checkIdDuplicate", method = RequestMethod.POST)
	public ResponseEntity<String> checkIdDuplicate(@RequestParam("mb_id") String mb_id) throws Exception{
		
		log.info("...아이디 중복체크");
		
		ResponseEntity<String> entity = null;
		
		try {
			int count = service.checkIdDuplicate(mb_id);
			
			// count가 0이면 아이디 사용가능, 1이면 불가능
			if(count!=0) {
				// 아이디 존재 -> 사용 불가능
				entity = new ResponseEntity<String>("FAIL", HttpStatus.OK);
			}else {
				// 사용가능한 아이디
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); // 요청 문제 있음
		}
		
		return entity;
	}
	
	// 로그인 폼
	@GetMapping("/login")
	public void login() {
		log.info("...로그인");
	}
	
	// 로그인 인증
	@PostMapping("/loginPost")
	public void login_ok(LoginDTO dto, RedirectAttributes rttr, HttpSession session, Model model) throws Exception{
		
		MemberVO vo = service.login_ok(dto);
		
		if(vo == null) return;
		
		String result = "";
		
		if(vo != null) {
			
			// 암호화 하기전
			/*
			if(vo.getMb_pw().equals(dto.getMb_pw())) {
			*/	
			
			// 암호화
			if(cryPassEnc.matches(dto.getMb_pw(), vo.getMb_pw())) {
//				vo.setMb_pw("");
//				session.setAttribute("LoginStatus", vo); // 세션정보로 인증상태를 저장
				
				// 인터셉터에서 참조할 모델작업
				model.addAttribute("memberVO", vo);
			
				
				result = "loginSuccess";
			}else {
				return;
			}
		}
		
		rttr.addFlashAttribute("status", result);
		
	}
	
	// 로그아웃 기능 : 메인페이지("/")
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		
		log.info("...로그아웃");
		
		session.invalidate();
		
		String result = "logout";
		rttr.addFlashAttribute("status", result);
		
		return "redirect:/";
	}
	
	// 아이디 찾기 폼
	@GetMapping("/find_id")
	public void find_id() {
		log.info("...아이디 찾기");
	}
	
	// 아이디 찾기(ajax적용) : 화면출력
	@PostMapping("/find_id")
	public ResponseEntity<String> find_id(@RequestParam("mb_name") String mb_name,@RequestParam(value = "mb_email", required = false) String mb_email) throws Exception{
		log.info("이름? " + mb_name);
		log.info("이메일? " + mb_email);
		
		ResponseEntity<String> entity = null;
		
		String mb_id = service.find_id(mb_name, mb_email);
		
		if(mb_id != null) {
			entity = new ResponseEntity<String>(mb_id, HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}
		
		return entity;
	}
	
	// 비밀번호 찾기 폼
	@GetMapping("/find_pwd")
	public void find_pwd() {
		log.info("...비밀번호 찾기");
	}
	
	// 비밀번호 찾기. 
	@ResponseBody
	@RequestMapping(value = "/find_pwd", method = RequestMethod.POST)
	public ResponseEntity<String> pw_search(@RequestParam("mb_id") String mb_id, @RequestParam("mb_name") String mb_name) throws Exception{
		
		log.info("아이디? " + mb_id);
		log.info("이름? " + mb_name);
		
		ResponseEntity<String> entity = null;
		
		String mb_pw = service.find_pwd(mb_id, mb_name);
		
		if(mb_pw != null) {
			
			entity = new ResponseEntity<String>(mb_pw, HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}
				
		return entity;
	}
	
	// DB와 연관된 것은 throws Exception 잡아주기
	// 회원정보 폼
	@GetMapping(value = "/modifyForm")
	public void member_info(HttpSession session, Model model) throws Exception{
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		
		model.addAttribute("vo", service.member_info(mb_id));
	}
	
	// 회원수정
	@PostMapping("/modifyForm")
	public String modifyForm(MemberVO vo, RedirectAttributes rttr, HttpSession session) throws Exception{
		
		vo.setMb_pw(cryPassEnc.encode(vo.getMb_pw()));
		
		String result = "";
		
		String mb_id = ((MemberVO) session.getAttribute("loginStatus")).getMb_id();
		vo.setMb_id(mb_id);
		
		service.modifyPOST(vo);
		
		result = "modifySuccess";
		
		rttr.addFlashAttribute("status", result);
		
		return "redirect:/";
	}
	
	
	// 탈퇴하기
	@GetMapping("/mb_delete")
	public String mb_delete( HttpSession session, RedirectAttributes rttr) throws Exception{
		
		String mb_id = ((MemberVO)session.getAttribute("loginStatus")).getMb_id();
		
		service.mb_delete(mb_id);
		session.invalidate();
		
		String result ="DelSuccess";
		
		rttr.addFlashAttribute("status", result);
		
		return "redirect:/";
	
	}

	
}
