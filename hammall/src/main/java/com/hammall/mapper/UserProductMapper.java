package com.hammall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hammall.domain.CategoryVO;
import com.hammall.domain.ProductVO;
import com.hammall.dto.Criteria;

public interface UserProductMapper {

	// 1차 카테고리
	public List<CategoryVO> getCategoryList() throws Exception;
	
	// 2차 카테고리
	public List<CategoryVO> getSubCategoryList(String ctg_code) throws Exception;
	
	// 2차 카테고리에 해당하는 상품목록
	/* !!! mapper인터페이스에서 xml mapper파일의 sql구문에 파라미터 적용하는 규칙!!!!
	  파라미터가 1개일 경우에는 필드명을 사용하여 getter메서드를 호출한다.
	  파라미터가 2개일 경우(타입이 참조형일 경우에는 객체명.필드 형태로 사용해야함)
	  기본형일 경우에는 직접 사용해야한다.
	 */
	public List<ProductVO> getProductListBysubCate(@Param("cri") Criteria cri,@Param("ctg_code") String ctg_code) throws Exception;
	
	// 2차 카테고리에 해당하는 상품 개수
	public int getTotalCountProductBySubCate(String ctg_code) throws Exception;
	
	// 상품 상세설명(상품조회)
	public ProductVO getProductByNum(long prod_num) throws Exception;
	
	
	
}
