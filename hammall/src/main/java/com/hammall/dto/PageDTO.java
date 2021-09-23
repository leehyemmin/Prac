package com.hammall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 리스트페이지에 페이징번호 출력작업.. [이전] 1 2 3 .. [다음]

@Getter
@Setter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total; // 테이블에 모든 테이터개수
	private Criteria cri; // 현재페이지번호, 게시물 출력개수
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		
		
		
	}
}
