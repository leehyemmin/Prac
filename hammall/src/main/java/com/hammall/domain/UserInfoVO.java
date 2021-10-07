package com.hammall.domain;

import java.util.Date;

import lombok.Data;


@Data
public class UserInfoVO {

	
	private String  user_id;
	private String  user_pw;
	private String  user_name;
	private String  user_zipcode;
	private String  user_addr;
	private String  user_de_addr;
	private String  user_phone;
	private String  user_email;
	private String  user_email_e;
	private int     user_point;
	private Date   	user_datesub;
	private Date   	user_up_date;
	private Date   	user_last_date;

	
}
