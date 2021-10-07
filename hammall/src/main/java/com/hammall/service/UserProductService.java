package com.hammall.service;

import java.util.List;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;

public interface UserProductService {

	// 1차 카테고리
	public List<CategoryVO> getCategoryList() throws Exception;
	
	// 2차 카테고리
	public List<CategoryVO> getSubCategoryList(String ctg_code) throws Exception;
	
	// 2차 카테고리에 해당하는 상품목록
	public List<ProductVO> getProductListBysubCate(Criteria cri, String ctg_code) throws Exception;
	
	// 2차 카테고리에 해당하는 상품 개수
	public int getTotalCountProductBySubCate(String ctg_code) throws Exception;
	
	// 상품 상세설명(상품조회)
	public ProductVO getProductByNum(long prod_num) throws Exception;
}
