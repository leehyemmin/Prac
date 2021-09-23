package com.hammall.service;

import com.hammall.domain.AdminVO;

public interface AdminService {

	// 로그인 인증
	public AdminVO login_check(AdminVO vo) throws Exception;
	
	// 정보수정 폼
	public AdminVO ad_info(String admin_id) throws Exception;
	
	// 정보수정 저장
	public boolean adModifyPOST(AdminVO vo) throws Exception;

}