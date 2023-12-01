package com.leaf4.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leaf4.app.vo.CateVO;
import com.leaf4.app.vo.ItemVO;
import com.leaf4.app.vo.MemberVO;
import com.leaf4.app.vo.OrderVO;
import com.leaf4.app.vo.PagingVO;
import com.leaf4.app.vo.QnaVO;

@Mapper
public interface AdminDao {

	public int getMemTotalCount(PagingVO paging);
	public int getItemTotalCount(PagingVO paging);
	public int getOrderTotalCount(PagingVO paging);
	public int getCateTotalCount(PagingVO paging);
	public int getQnaTotalCount(PagingVO paging);

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
	
	
	public List<OrderVO> getOrderList(PagingVO paging);
	public OrderVO getOrder(int orderNo);
	public int insertOrder(OrderVO orderVO);
	public int updateOrder(OrderVO orderVO);
	public int deleteOrder(OrderVO orderVO);
	public int selectOrderDelete(String orderNo);
	
	

	public List<CateVO> getCateList(PagingVO paging);
	public CateVO getCate(int cateNo);
	public int insertCate(CateVO cateVO);
	public int updateCate(CateVO cateVO);
	public int deleteCate(CateVO cateVO);
	public int selectCateDelete(String cateNo);


	public List<QnaVO> getQnaList(PagingVO paging);
	public QnaVO getQna(int qnaNo);
	public int insertQna(QnaVO qnaVO);
	public int updateQna(QnaVO qnaVO);
	public int deleteQna(QnaVO qnaVO);
	public int selectQnaDelete(String qnaNo);
	
}
