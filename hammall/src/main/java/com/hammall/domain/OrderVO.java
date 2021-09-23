package com.hammall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	
	private long ord_code;
	private String mb_id;
	private String ord_name;
	private String ord_zipcode; 
	private String ord_addr; 
	private String ord_de_addr; 
	private String ord_phone; 
	private String ord_email;
	private int ord_price; 
	private Date ord_date;
}
