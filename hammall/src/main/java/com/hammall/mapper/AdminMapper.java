package com.hammall.mapper;

import com.hammall.domain.AdminVO;

public interface AdminMapper {

	// 로그인 인증
	public AdminVO login_check(AdminVO vo) throws Exception;
	
	// 로그인 업뎃
	public void login_update(String admin_id) throws Exception;
	
	// 정보수정 폼
	public AdminVO ad_info(String admin_id) throws Exception;
	
	// 정보수정 저장
	public int adModifyPOST(AdminVO vo) throws Exception;
	
	
}
