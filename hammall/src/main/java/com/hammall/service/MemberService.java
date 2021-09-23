package com.hammall.service;

import java.util.List;

import com.hammall.domain.MemberVO;
import com.hammall.domain.UserInfoVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.LoginDTO;

public interface MemberService {

	// MemberVO 가져오기
	public MemberVO readUserInfo(String mb_id) throws Exception;
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 아이디 중복체크
	public int checkIdDuplicate(String mb_id) throws Exception;
	
	// 로그인 인증
	public MemberVO login_ok(LoginDTO dto) throws Exception;
	
	// 아이디 찾기 : 화면 출력
	public String find_id(String mb_name, String mb_email) throws Exception;
	
	// 비밀번호 찾기
	public String find_pwd(String mb_id, String mb_name) throws Exception;
	
	// 회원수정 폼
	public MemberVO member_info(String mb_id) throws Exception;
	
	// 회원수정 저장
	public boolean modifyPOST(MemberVO vo) throws Exception;
	
	// 탈퇴하기
	public void mb_delete(String mb_id) throws Exception;
	
	// 회원목록
	public List<UserInfoVO> userinfo_list() throws Exception;
}
