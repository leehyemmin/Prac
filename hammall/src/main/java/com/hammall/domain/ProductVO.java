package com.hammall.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {

	
	private int prod_num;
	private String ctg_code;
	private String ctg_prt_code;
	private String prod_name;
	private int prod_price;
	private int prod_discount;
	private String prod_detail;
	private String prod_color;
	private String prod_size;
	private String prod_company;
	private String prod_img;
	private int prod_amount;
	private String prod_buy;
	private Date prod_datesub;
	private Date prod_up_date;
	
	// 파일첨부 파라미터 작업
	private MultipartFile file1;
	
}
