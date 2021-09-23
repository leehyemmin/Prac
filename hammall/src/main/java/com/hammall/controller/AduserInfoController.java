package com.hammall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hammall.dto.Criteria;
import com.hammall.dto.PageDTO;
import com.hammall.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/member/*")
public class AduserInfoController {

	@Setter(onMethod_ = @Autowired)
	private MemberService memberService;
	
	
	// 회원관리
	@RequestMapping(value = "/userInfo_list", method = {RequestMethod.GET, RequestMethod.POST})
	public void userInfo_list(Model model) throws Exception {
		
		model.addAttribute("user_list", memberService.userinfo_list());
		
		
	}
	
	
	
}
