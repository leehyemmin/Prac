package com.hammall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String mb_id;
	private String mb_pw;
	private String mb_name;
	private String mb_zipcode;
	private String mb_addr;
	private String mb_de_addr;
	private String mb_phone;
	private String mb_email;
	private String mb_email_e;
	private int mb_point;
	private Date mb_datesub;
	private Date mb_up_date;
	private Date mb_last_date;
	
	
}
