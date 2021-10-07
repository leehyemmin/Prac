package com.hammall.domain;

import lombok.Data;

@Data
public class OrderDetailListVO {
	
	private String ord_code;
	private int prod_num;
	private int ord_amount;
	private int ord_price;
	
	private String prod_name;
	private String prod_img;
}
