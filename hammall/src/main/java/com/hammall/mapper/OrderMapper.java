package com.hammall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hammall.domain.OrderDetailListVO;
import com.hammall.domain.OrderDetailVO;
import com.hammall.domain.OrderVO;
import com.hammall.dto.Criteria;
import com.hammall.dto.OrderSaleDTO;

public interface OrderMapper {

	/* 사용자 & 관리자 */
	
	// 주문정보
	public void order_add(OrderVO vo) throws Exception;
	
	// 주문상세정보(주문내역)
	public void orderDetail_add(@Param("ord_code") long ord_code,@Param("mb_id") String mb_id) throws Exception;
	
	// 즉시구매
	public void orderDirect_add(OrderDetailVO vo) throws Exception;
	
	// 주문목록 보기
	public List<OrderVO> mb_order_list(OrderVO vo) throws Exception;
	
	// 주문상세 보기
	public List<OrderDetailListVO> mb_deorder_list(long ord_code) throws Exception;
	

	// 관리자 주문상세
	public List<OrderDetailListVO> order_detail_list(long ord_code) throws Exception;
	
	
	
	// 주문리스트
	public List<OrderVO> orderInfo_list(Criteria cri) throws Exception;
	
	// 주문상품 개수(페이징기능에 사용)
	public int getTotalCountOrder(Criteria cri) throws Exception;
	
	
	// 월별 통계매출
	public List<OrderSaleDTO> order_sale(@Param("startDate") String startDate, @Param("endDate") String endDate) throws Exception;

	
	
}
