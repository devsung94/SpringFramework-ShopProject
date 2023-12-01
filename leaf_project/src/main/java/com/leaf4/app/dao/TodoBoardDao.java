package com.leaf4.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leaf4.app.vo.PagingVO;
import com.leaf4.app.vo.TodoBoardVO;

@Mapper
public interface TodoBoardDao {

	public List<TodoBoardVO> getBoardList(PagingVO paging);
//	public List<TodoBoardVO> getBoardList();
	public TodoBoardVO getBoard(int boNo);
	public int updateBoard(TodoBoardVO todoBoard);
	public int deleteBoard(TodoBoardVO todoBoard);
	public int insertBoard(TodoBoardVO todoBoard);
	
	public int getTotalRowCount(PagingVO paging);
}
