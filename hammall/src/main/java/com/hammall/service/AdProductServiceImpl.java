package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;
import com.hammall.mapper.AdProductMapper;

import lombok.Setter;

@Service
public class AdProductServiceImpl implements AdProductService {

	@Setter(onMethod_ = @Autowired)
	private AdProductMapper pro_mapper;
	
	
	// 1차 카테고리
	@Override
	public List<CategoryVO> getCategoryList() throws Exception {
		return pro_mapper.getCategoryList();
	}

	// 2차 카테고리
	@Override
	public List<CategoryVO> getSubCategoryList(String ctg_code) throws Exception {
		return pro_mapper.getSubCategoryList(ctg_code);
	}

	// 상품 등록
	@Override
	public void product_insert(ProductVO vo) throws Exception {
		pro_mapper.product_insert(vo);
	}

	// 상품 리스트
	@Override
	public List<ProductVO> product_list(Criteria cri) throws Exception {
		return pro_mapper.product_list(cri);
	}

	// 상품 개수
	@Override
	public int getTotalCountProduct(Criteria cri) throws Exception {
		return pro_mapper.getTotalCountProduct(cri);
	}

	// 상품 수정폼
	@Override
	public ProductVO product_modify(Long prod_num) throws Exception {
		return pro_mapper.product_modify(prod_num);
	}

	// 상품 수정 저장
	@Override
	public void product_modify(ProductVO vo) throws Exception {
		pro_mapper.product_modifyOk(vo);
	}

	@Override
	public void product_deleteOk(Long prod_num) throws Exception {
		pro_mapper.product_deleteOk(prod_num);
	}
	
	
	
	
	
	

}
