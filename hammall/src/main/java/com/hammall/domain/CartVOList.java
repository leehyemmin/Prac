package com.hammall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVOList {
	
	private long cart_code;
	private String prod_img;
	private String prod_name;
	private int cart_amount;
	private long prod_price;
}
