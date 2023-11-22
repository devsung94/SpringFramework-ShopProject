package com.leaf4.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.leaf4.app.vo.FreeBoardVO;
import com.leaf4.common.vo.PagingVO;
@Mapper
public interface IFreeBoardDao {
	public List<FreeBoardVO> getBoardList();
	public FreeBoardVO getBoard(int boNo);
	public int updateBoard(FreeBoardVO freeBoard);
	public int deleteBoard(FreeBoardVO freeBoard);
	public int insertBoard(FreeBoardVO freeBoard);
	
	public int getTotalRowCount(PagingVO paging);
	public List<FreeBoardVO> getBoardList(PagingVO paging);
}
