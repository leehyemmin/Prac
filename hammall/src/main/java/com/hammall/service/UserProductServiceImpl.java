package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;
import com.hammall.mapper.UserProductMapper;

import lombok.Setter;

@Service
public class UserProductServiceImpl implements UserProductService {

	@Setter(onMethod_ = @Autowired)
	private UserProductMapper userProductMapper;
	
	
	// 1차 카테고리
	@Override
	public List<CategoryVO> getCategoryList() throws Exception {
		return userProductMapper.getCategoryList();
	}

	// 2차 카테고리
	@Override
	public List<CategoryVO> getSubCategoryList(String ctg_code) throws Exception {
		return userProductMapper.getSubCategoryList(ctg_code);
	}

	// 2차 카테고리에 해당하는 상품목록
	@Override
	public List<ProductVO> getProductListBysubCate(Criteria cri, String ctg_code) throws Exception {
		return userProductMapper.getProductListBysubCate(cri, ctg_code);
	}

	// 2차 카테고리에 해당하는 상품 개수
	@Override
	public int getTotalCountProductBySubCate(String ctg_code) throws Exception {
		return userProductMapper.getTotalCountProductBySubCate(ctg_code);
	}

	@Override
	public ProductVO getProductByNum(long prod_num) throws Exception {
		return userProductMapper.getProductByNum(prod_num);
	}

}
