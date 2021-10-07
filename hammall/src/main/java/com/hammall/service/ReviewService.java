package com.hammall.service;

import com.hammall.domain.ReviewVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.ReviewPageDTO;

public interface ReviewService {

	
	// 상품후기 페이징, 개수
	public ReviewPageDTO getReviewListWithPaging(Criteria cri, int prod_num) throws Exception;
	
	// 상품후기 등록
	public void review_register(ReviewVO vo) throws Exception;
	
	// 상품후기 수정
	public void review_modify(ReviewVO vo) throws Exception;
	
	// 상품후기 삭제
	public void review_delete(int rev_num) throws Exception;
}
