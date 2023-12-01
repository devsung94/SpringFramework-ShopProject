package com.leaf4.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leaf4.app.vo.ItemVO;
import com.leaf4.app.vo.MemberVO;
import com.leaf4.app.vo.PagingVO;

@Mapper
public interface AdminDao {

	public int getMemTotalCount(PagingVO paging);
	public int getItemTotalCount(PagingVO paging);

	public List<MemberVO> getMemList(PagingVO paging);
	public MemberVO getMember(int memNo);
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(MemberVO member);
	public int selectMemDelete(String memNo);
	

	public List<ItemVO> getItemList(PagingVO paging);
	public ItemVO getItem(int itemNo);
	public int insertItem(ItemVO itemVO);
	public int updateItem(ItemVO itemVO);
	public int deleteItem(ItemVO itemVO);
	public int selectItemDelete(String itemNo);
	
	
}
