package com.hammall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hammall.domain.BoardVO;
import com.hammall.dto.Criteria;
import com.hammall.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	// 게시판목록
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	// 글 등록하기
	@Override
	public void brd_insert(BoardVO board) throws Exception {
		boardMapper.brd_insert(board);
	}
	
	// 글 읽기
	@Override
	public BoardVO brd_read(Long brd_num) throws Exception {
		return boardMapper.brd_read(brd_num);
	} 
	
	// 글 수정하기
	@Override
	public int brd_update(BoardVO board) throws Exception {
		return boardMapper.brd_update(board);
	}

	// 글 삭제하기
	@Override
	public int brd_delete(Long brd_num) throws Exception {
		return boardMapper.brd_delete(brd_num);
	}
	
	
	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) throws Exception {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public List<BoardVO> getListWithSearchPaging(Criteria cri) throws Exception {
		return boardMapper.getListWithSearchPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return boardMapper.getTotalCount(cri);
	}




	
	
}
