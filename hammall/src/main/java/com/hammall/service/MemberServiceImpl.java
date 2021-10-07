package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.MemberVO;
import com.hammall.domain.UserInfoVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.LoginDTO;
import com.hammall.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	
	// MemberVO 가져오기
	@Override
	public MemberVO readUserInfo(String mb_id) throws Exception {
		return mapper.readUserInfo(mb_id);
	}

	// 회원가입
	@Override
	public void join(MemberVO vo) throws Exception {
		mapper.join(vo);
	}

	// 아이디 중복체크
	@Override
	public int checkIdDuplicate(String mb_id) throws Exception {
		return mapper.checkIdDuplicate(mb_id);
	}

	// 로그인 인증
	// @Transactional 작업
	@Override
	public MemberVO login_ok(LoginDTO dto) throws Exception {
		return mapper.login_ok(dto);
	}

	// 아이디 찾기
	@Override
	public String find_id(String mb_name, String mb_email) throws Exception {
		return mapper.find_id(mb_name, mb_email);
	}

	// 비밀번호 찾기
	@Override
	public String find_pwd(String mb_id, String mb_name) throws Exception {
		return mapper.find_pwd(mb_id, mb_name);
	}

	// 회원수정 폼
	@Override
	public MemberVO member_info(String mb_id) throws Exception {
		return mapper.member_info(mb_id);
	}

	// 회원정보수정 저장
	@Override
	public boolean modifyPOST(MemberVO vo) throws Exception {
		return mapper.modifyPOST(vo) == 1;
	}

	// 탈퇴하기
	@Override
	public void mb_delete(String mb_id) throws Exception {
		 mapper.mb_delete(mb_id);
	}

	@Override
	public List<UserInfoVO> userinfo_list() throws Exception {
		return mapper.userinfo_list();
	}
	
	



	

	

	

	
	
}
