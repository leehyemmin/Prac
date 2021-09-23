package com.hammall.mapper;

import java.util.List;

import com.hammall.domain.BoardVO;
import com.hammall.dto.Criteria;

public interface BoardMapper {

	// 게시판목록
	public List<BoardVO> getList();
	
	// 글 등록하기
	public void brd_insert(BoardVO board) throws Exception;
	
	// 글 읽기
	public BoardVO brd_read(Long brd_num) throws Exception;
	
	// 글 수정하기
	public int brd_update(BoardVO board) throws Exception;
	
	// 글 삭제하기
	public int brd_delete (Long brd_num) throws Exception;
	
	
	public List<BoardVO> getListWithPaging(Criteria cri) throws Exception;
	public List<BoardVO> getListWithSearchPaging(Criteria cri) throws Exception;
	public int getTotalCount(Criteria cri) throws Exception;
	
}
