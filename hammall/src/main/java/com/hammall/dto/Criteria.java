package com.hammall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum; // 페이지번호. 1 2 3 4 5 
	private int amount; // 페이지마다 출력될 게시물개수
	
	// 검색종류?
	// 검색방법?
	// 1) 단일항목검색 제목(T), 내용(C), 작성자(W)
	// 2) 다중항목검색 제목(T), 내용(C), 작성자(W), 제목+내용(TC), 제목+작성자(TW), 제목+내용+작성자(TCW)
	private String type;
	private String keyword; // 검색어
	
	public Criteria() {
		this(1, 5);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null? new String[] {} : type.split("");
	}
}
