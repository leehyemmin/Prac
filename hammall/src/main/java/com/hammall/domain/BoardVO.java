package com.hammall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private Long brd_num;
	private String mb_id;
	private String brd_title;
	private String brd_content;
	private Date brd_reg_date;
	private Date updateDate;
}
