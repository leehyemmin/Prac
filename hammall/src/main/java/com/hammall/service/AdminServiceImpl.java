package com.hammall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.AdminVO;
import com.hammall.mapper.AdminMapper;

import lombok.Setter;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Setter(onMethod_ = @Autowired)
	private AdminMapper adminMapper;
	
	
	// 로그인 인증
	@Override
	public AdminVO login_check(AdminVO vo) throws Exception {
		
		AdminVO adVO = adminMapper.login_check(vo);
		
		if(adVO != null) {
			adminMapper.login_update(vo.getAdmin_id()); // 로그인 
		}
		return adVO; // 이전 로그인 시간정보
	}

	// 정보수정 폼
	@Override
	public AdminVO ad_info(String admin_id) throws Exception {
		return adminMapper.ad_info(admin_id);
	}

	@Override
	public boolean adModifyPOST(AdminVO vo) throws Exception {
		return adminMapper.adModifyPOST(vo) == 1;
	}
	
	
	
	
	
	
	
	

}
