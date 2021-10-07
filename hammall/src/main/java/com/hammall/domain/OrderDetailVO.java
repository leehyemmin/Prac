package com.hammall.domain;

import lombok.Data;

@Data
public class OrderDetailVO {

	private long ord_code;
	private int prod_num; 
	private int ord_amount; 
	private int ord_price;
}
