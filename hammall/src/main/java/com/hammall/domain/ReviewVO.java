package com.hammall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {

	private long rev_num;
	private String mb_id;
	private long prod_num;
	private int rev_score;
	private String rev_content;
	private Date rev_reg_date;
}
