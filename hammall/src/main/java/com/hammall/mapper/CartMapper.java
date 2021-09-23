package com.hammall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hammall.domain.CartVO;
import com.hammall.domain.CartVOList;
import com.hammall.dto.CartDTO;

public interface CartMapper {

	// 장바구니 추가
	public void add_cart(CartVO vo) throws Exception;
	
	// 장바구니 리스트
	public List<CartVOList> list_cart(String mb_id) throws Exception;
	
	// 수량 변경
	public void cart_amount_update(@Param("cart_code") int cart_code,@Param("cart_amount") int cart_amount) throws Exception;
	
	// 상품 삭제
	public void delete_cart(Long cart_code) throws Exception;
	
	// 장바구니 비우기
	public void cartAll_delete(String mb_id) throws Exception;
	
	// 선택된 상품 삭제
	public void cart_check_delete(List<Integer> checkArr) throws Exception;
	
	// 선택 상품 주문(선택된 것을 제외한 상품 삭제)
	public void cart_check_order(List<Integer> checkArr) throws Exception;
	
	// 상품가격 합
	public List<CartDTO> cart_money() throws Exception;
	
}
