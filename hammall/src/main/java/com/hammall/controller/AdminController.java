package com.hammall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hammall.domain.AdminVO;
import com.hammall.service.AdminService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class AdminController {

	@Setter(onMethod_ = @Autowired)
	public AdminService adminService;
	
	// 로그인 폼
	@GetMapping("")
	public String admin_login() {
		return "/admin/admin_login";
	}
	
	// 로그인 인증
	@PostMapping("admin_check")
	public String admin_ok(AdminVO vo, RedirectAttributes rttr, HttpSession session) throws Exception{
		
		AdminVO adVO = null;
		
		adVO = adminService.login_check(vo);
		
		if(adVO == null) {
			rttr.addFlashAttribute("msg", "Fail");
			
			return "redirect:/admin/";
		}
		
		// 세션인증작업
		session.setAttribute("adLoginStatus", adVO);
		
		return "redirect:/admin/admin_process";
	}
	
	@GetMapping("/admin_process")
	public String admin_process(HttpSession session) {
		log.info("...admin_process");
		
		String url = "";
		
		if(session.getAttribute("adLoginStatus") == null) {
			url = "redirect:/admin/"; // 관리자 로그인 주소
		}else {
			url = "/admin/admin_process"; // 관리자 메뉴 뷰(jsp)
		}
		
		return url;
	}
	
	// 로그아웃
	@PostMapping("/admin_logout")
	public String logout(HttpSession session, RedirectAttributes rttr) throws Exception{
		
		session.invalidate();
		
		rttr.addFlashAttribute("msg", "logout");
		return "redirect:/admin/";
	}
	
	// 정보수정 폼
	@GetMapping("/adFormModify")
	public void ad_info(HttpSession session, Model model) throws Exception{
		
		String admin_id = ((AdminVO)session.getAttribute("adLoginStatus")).getAdmin_id();
		
		model.addAttribute("vo", adminService.ad_info(admin_id));
	}
	
	// 정보수정 저장
	@PostMapping("/adFormModify")
	public String adFormModify(AdminVO vo, RedirectAttributes rttr, HttpSession session) throws Exception{
		
		String result = "";
		
		String admin_id = ((AdminVO)session.getAttribute("adLoginStatus")).getAdmin_id();
		vo.setAdmin_id(admin_id);
		
		adminService.adModifyPOST(vo);
		
		result = "adModifySuccess";
		
		rttr.addFlashAttribute("status", result);
		
		return "redirect:/admin/admin_process";
	}
	
	
	
	
	
	
	
	
}
