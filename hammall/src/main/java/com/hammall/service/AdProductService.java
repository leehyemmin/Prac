package com.hammall.service;

import java.util.List;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;

public interface AdProductService {

	// 1차 카테고리
	public List<CategoryVO> getCategoryList() throws Exception;
		
	// 2차 카테고리
	public List<CategoryVO> getSubCategoryList(String ctg_code) throws Exception;
	
	// 상품등록
	public void product_insert(ProductVO vo) throws Exception;
	
	// 상품 리스트
	public List<ProductVO> product_list(Criteria cri) throws Exception;
	
	// 상폼개수(페이지기능에 사용)
	public int getTotalCountProduct(Criteria cri) throws Exception;
	
	// 상품 수정폼
	public ProductVO product_modify(Long prod_num) throws Exception;
	
	// 상품 수정 저장
	public void product_modify(ProductVO vo) throws Exception;
	
	// 상품 삭제
	public void product_deleteOk(Long prod_num) throws Exception;
}
