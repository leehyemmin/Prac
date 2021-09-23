package com.hammall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hammall.domain.ReviewVO;
import com.hammall.dto.Criteria;

public interface ReviewMapper {

	// 상품후기 페이징
	public List<ReviewVO> getReviewListWithPaging(@Param("cri") Criteria cri,@Param("prod_num") int prod_num) throws Exception;

	// 상품후기 개수
	public int getCountByProduct_prod_num(long prod_num);
	
	// 상품후기 등록
	public void review_register(ReviewVO vo) throws Exception;
	
	// 상품후기 수정
	public void review_modify(ReviewVO vo) throws Exception;
	
	// 상품후기 삭제
	public void review_delete(int rev_num) throws Exception;
}
