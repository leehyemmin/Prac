package com.hammall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.ReviewVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.ReviewPageDTO;
import com.hammall.mapper.ReviewMapper;

import lombok.Setter;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Setter(onMethod_ = @Autowired)
	private ReviewMapper reviewMapper;

	
	// 상품후기 페이징, 개수
	@Override
	public ReviewPageDTO getReviewListWithPaging(Criteria cri, int prod_num) throws Exception {
		
		return new ReviewPageDTO(reviewMapper.getCountByProduct_prod_num(prod_num), reviewMapper.getReviewListWithPaging(cri, prod_num));
	}


	// 상품후기 등록
	@Override
	public void review_register(ReviewVO vo) throws Exception {
		reviewMapper.review_register(vo);
	}


	// 상품후기 수정
	@Override
	public void review_modify(ReviewVO vo) throws Exception {
		reviewMapper.review_modify(vo);
	}


	@Override
	public void review_delete(int rev_num) throws Exception {
		reviewMapper.review_delete(rev_num);
	}
	
	
	
	
	
}
