package com.hammall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AdminVO {
	
	private String admin_id;
	private String admin_pw;
	private String admin_name; 
	private Date admin_date_late;
	
}
