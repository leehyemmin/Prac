package com.hammall.dto;

import java.util.List;

import com.hammall.domain.ReviewVO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor  // 2개 필드에 대한 생성자메서드 생성
public class ReviewPageDTO {

	private int reviewCnt; // 상품후기 개수
	private List<ReviewVO> list; // 상품후기 목록
}
