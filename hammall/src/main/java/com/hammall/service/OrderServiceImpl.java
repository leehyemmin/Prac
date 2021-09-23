package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hammall.domain.OrderDetailListVO;
import com.hammall.domain.OrderDetailVO;
import com.hammall.domain.OrderVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.OrderSaleDTO;
import com.hammall.mapper.CartMapper;
import com.hammall.mapper.OrderMapper;

import lombok.Setter;

@Service
public class OrderServiceImpl implements OrderService {

	@Setter(onMethod_ = @Autowired)
	private OrderMapper orderMapper;
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper cartMapper;

	
	// 주문하기
	@Transactional
	@Override
	public void order_buy(OrderVO vo, String mb_id) throws Exception {
		orderMapper.order_add(vo);
		orderMapper.orderDetail_add(vo.getOrd_code(), mb_id);
		cartMapper.cartAll_delete(mb_id);
	}

	// 즉시구매
	@Transactional
	@Override
	public void orderDirect_buy(OrderVO vo, OrderDetailVO vo2) throws Exception {
		orderMapper.order_add(vo); // 파라미터가 참조형(주소값)으로 전달되기 때문에
		vo2.setOrd_code(vo.getOrd_code());
		orderMapper.orderDirect_add(vo2);
	}

	// 사용자 주문목록
	@Override
	public List<OrderVO> mb_order_list(OrderVO vo) throws Exception {
		return orderMapper.mb_order_list(vo);
	}

	// 사용자 주문상세보기
	@Override
	public List<OrderDetailListVO> mb_deorder_list(long ord_code) throws Exception {
		return orderMapper.mb_deorder_list(ord_code);
	}

	// 주문리스트
	@Override
	public List<OrderVO> orderInfo_list(Criteria cri) throws Exception {
		return orderMapper.orderInfo_list(cri);
	}

	// 주문상품 개수
	@Override
	public int getTotalCountOrder(Criteria cri) throws Exception {
		return orderMapper.getTotalCountOrder(cri);
	}

	// 관리자 주문상세
	@Override
	public List<OrderDetailListVO> order_detail_list(long ord_code) throws Exception {
		return orderMapper.order_detail_list(ord_code);
	}

	
	// 월별 통계매출
	@Override
	public List<OrderSaleDTO> order_sale(String startDate, String endDate) throws Exception {
		return orderMapper.order_sale(startDate, endDate);
	}
	
	
	
	
	
	
	
	
}
