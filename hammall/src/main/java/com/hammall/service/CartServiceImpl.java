package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.CartVO;
import com.hammall.domain.CartVOList;
import com.hammall.dto.CartDTO;
import com.hammall.mapper.CartMapper;

import lombok.Setter;

@Service
public class CartServiceImpl implements CartService {

	@Setter(onMethod_ = @Autowired)
	private CartMapper cartMapper;

	
	// 장바구니 추가
	@Override
	public void add_cart(CartVO vo) throws Exception {
		cartMapper.add_cart(vo);
	}

	// 장바구니 리스트
	@Override
	public List<CartVOList> list_cart(String mb_id) throws Exception {
		return cartMapper.list_cart(mb_id);
	}

	// 수량 변경
	@Override
	public void cart_amount_update(int cart_code, int cart_amount) throws Exception {
		cartMapper.cart_amount_update(cart_code, cart_amount);
	}

	// 상품 삭제
	@Override
	public void delete_cart(Long cart_code) throws Exception {
		cartMapper.delete_cart(cart_code);
	}

	// 장바구니 비우기
	@Override
	public void cartAll_delete(String mb_id) throws Exception {
		cartMapper.cartAll_delete(mb_id);
	}

	// 선택상품 삭제
	@Override
	public void cart_check_delete(List<Integer> checkArr) throws Exception {
		cartMapper.cart_check_delete(checkArr);
	}

	// 선택상품 주문
	@Override
	public void cart_check_order(List<Integer> checkArr) throws Exception {
		cartMapper.cart_check_order(checkArr);
	}

	// 상품가격 합
	@Override
	public List<CartDTO> cart_money() throws Exception {
		return cartMapper.cart_money();
	}
	
	
	
}
