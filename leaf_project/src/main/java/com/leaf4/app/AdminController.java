package com.leaf4.app;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leaf4.app.dao.AdminDao;
import com.leaf4.app.vo.CateVO;
import com.leaf4.app.vo.ItemVO;
import com.leaf4.app.vo.MemberVO;
import com.leaf4.app.vo.OrderVO;
import com.leaf4.app.vo.PagingVO;
import com.leaf4.app.vo.QnaVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	AdminDao adminDao;
	
	@GetMapping("admin.do")
	public String adminHome() {
		return "admin/admin";
	}

	//------------------ 회원관리 --------------------//
	@GetMapping("memList.do")
	public String getMemList(Model model, @ModelAttribute("paging")PagingVO paging) {
		int totalRowCount=adminDao.getMemTotalCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		
		List<MemberVO> memberList=adminDao.getMemList(paging);
		model.addAttribute("memberList",memberList);
		//System.out.println(memberList.toString());
		return "admin/user/memList";
	}

	@RequestMapping("memAdd.do")
	public String getMemAdd(Model model) {
		return "admin/user/memAdd";
	}
	@RequestMapping("memCreate.do")
	public String memCreate(Model model, MemberVO memberVO) throws Exception {
		System.out.println(memberVO.toString());
		adminDao.insertMember(memberVO);
		
		model.addAttribute("url","/admin/memList.do");
		model.addAttribute("msg","회원등록이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("memEdit.do")
	public String getMemEdit(Model model,@RequestParam(name = "memNo")int memNo) {
		MemberVO memberVO=adminDao.getMember(memNo);
		model.addAttribute("member",memberVO);
		return "admin/user/memEdit";
	}
	
	@RequestMapping("memUpdate.do")
	public String memUpdate(Model model, MemberVO memberVO) throws Exception {
		System.out.println(memberVO.toString());
		adminDao.updateMember(memberVO);
		
		model.addAttribute("url","/admin/memList.do");
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("memDelete.do")
	@ResponseBody
	public Boolean memDelete(@RequestBody MemberVO memberVO) throws Exception {
		int res = adminDao.deleteMember(memberVO);
		Boolean result = false;
		
		if(res > 0) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("selectAction.do")
	@ResponseBody
	public Boolean selectAction(@RequestParam(value="Arr[]") String[] Arr) throws Exception {

		Boolean result = true;
		int size = Arr.length;
		System.out.println(Arr);
		System.out.println(Arr[0]);
		for(int i=0;i<size;i++) {
			adminDao.selectMemDelete(Arr[i]);
		}
		
		return result;
	}

	//------------------ 회원관리 --------------------//
	
	
	

	//------------------ 상품관리 --------------------//
	@GetMapping("itemList.do")
	public String itemList(Model model, @ModelAttribute("paging")PagingVO paging) {
		
		int totalRowCount=adminDao.getItemTotalCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		
		List<ItemVO> itemList=adminDao.getItemList(paging);
		model.addAttribute("itemList",itemList);
		//System.out.println(memberList.toString());
		
		
		return "admin/item/itemList";
	}

	
	@RequestMapping("itemAdd.do")
	public String getItemAdd(Model model) {
		return "admin/item/itemAdd";
	}
	
	@RequestMapping("itemCreate.do")
	public String itemCreate(Model model, ItemVO itemVO) throws Exception {
		System.out.println(itemVO.toString());
		adminDao.insertItem(itemVO);
		
		model.addAttribute("url","/admin/itemList.do");
		model.addAttribute("msg","상품등록이 완료되었습니다.");
		return "admin/message";
	}
	


	@RequestMapping("itemEdit.do")
	public String getItemEdit(Model model,@RequestParam(name = "itemNo")int itemNo) {
		ItemVO itemVO=adminDao.getItem(itemNo);
		model.addAttribute("item",itemVO);
		return "admin/item/itemEdit";
	}
	
	@RequestMapping("itemUpdate.do")
	public String itemUpdate(Model model, ItemVO itemVO) throws Exception {
		System.out.println(itemVO.toString());
		adminDao.updateItem(itemVO);
		
		model.addAttribute("url","/admin/itemList.do");
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("itemDelete.do")
	@ResponseBody
	public Boolean itemDelete(@RequestBody ItemVO itemVO) throws Exception {
		int res = adminDao.deleteItem(itemVO);
		Boolean result = false;
		
		if(res > 0) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("selectItemAction.do")
	@ResponseBody
	public Boolean selectItemAction(@RequestParam(value="Arr[]") String[] Arr) throws Exception {

		Boolean result = true;
		int size = Arr.length;
		System.out.println(Arr);
		System.out.println(Arr[0]);
		for(int i=0;i<size;i++) {
			adminDao.selectItemDelete(Arr[i]);
		}
		
		return result;
	}
	//------------------ 상품관리 end --------------------//
	
	//------------------ 주문관리 start --------------------//

	@GetMapping("orderList.do")
	public String orderList(Model model, @ModelAttribute("paging")PagingVO paging) {
		
		int totalRowCount=adminDao.getOrderTotalCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		
		List<OrderVO> orderList=adminDao.getOrderList(paging);
		model.addAttribute("orderList",orderList);		

		return "admin/order/orderList";
	}

	
	@RequestMapping("orderAdd.do")
	public String getOrderAdd(Model model) {
		return "admin/order/orderAdd";
	}
	
	@RequestMapping("orderCreate.do")
	public String orderCreate(Model model, OrderVO orderVO) throws Exception {
		System.out.println(orderVO.toString());
		adminDao.insertOrder(orderVO);
		
		model.addAttribute("url","/admin/orderList.do");
		model.addAttribute("msg","상품등록이 완료되었습니다.");
		return "admin/message";
	}
	


	@RequestMapping("orderEdit.do")
	public String getOrderEdit(Model model,@RequestParam(name = "orderNo")int orderNo) {
		OrderVO orderVO=adminDao.getOrder(orderNo);
		model.addAttribute("order",orderVO);
		return "admin/order/orderEdit";
	}
	
	@RequestMapping("orderUpdate.do")
	public String orderUpdate(Model model, OrderVO orderVO) throws Exception {
		System.out.println(orderVO.toString());
		adminDao.updateOrder(orderVO);
		
		model.addAttribute("url","/admin/orderList.do");
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("orderDelete.do")
	@ResponseBody
	public Boolean orderDelete(@RequestBody OrderVO orderVO) throws Exception {
		int res = adminDao.deleteOrder(orderVO);
		Boolean result = false;
		
		if(res > 0) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("selectOrderAction.do")
	@ResponseBody
	public Boolean selectOrderAction(@RequestParam(value="Arr[]") String[] Arr) throws Exception {

		Boolean result = true;
		int size = Arr.length;
		System.out.println(Arr);
		System.out.println(Arr[0]);
		for(int i=0;i<size;i++) {
			adminDao.selectOrderDelete(Arr[i]);
		}
		
		return result;
	}
	
	//------------------ 주문서관리 end --------------------//
	

	//------------------ 카테고리관리 start --------------------//
	
	@GetMapping("cateList.do")
	public String cateList(Model model, @ModelAttribute("paging")PagingVO paging) {
		
		int totalRowCount=adminDao.getCateTotalCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		
		List<CateVO> cateList=adminDao.getCateList(paging);
		model.addAttribute("cateList",cateList);		

		return "admin/cate/cateList";
	}

	
	@RequestMapping("cateAdd.do")
	public String getCateAdd(Model model) {
		return "admin/cate/cateAdd";
	}
	
	@RequestMapping("cateCreate.do")
	public String cateCreate(Model model, CateVO cateVO) throws Exception {
		System.out.println(cateVO.toString());
		adminDao.insertCate(cateVO);
		
		model.addAttribute("url","/admin/cateList.do");
		model.addAttribute("msg","카테고리등록이 완료되었습니다.");
		return "admin/message";
	}
	


	@RequestMapping("cateEdit.do")
	public String getCateEdit(Model model,@RequestParam(name = "cateNo")int cateNo) {
		CateVO cateVO=adminDao.getCate(cateNo);
		model.addAttribute("cate",cateVO);
		return "admin/cate/cateEdit";
	}
	
	@RequestMapping("cateUpdate.do")
	public String cateUpdate(Model model, CateVO cateVO) throws Exception {
		System.out.println(cateVO.toString());
		adminDao.updateCate(cateVO);
		
		model.addAttribute("url","/admin/cateList.do");
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("cateDelete.do")
	@ResponseBody
	public Boolean cateDelete(@RequestBody CateVO cateVO) throws Exception {
		int res = adminDao.deleteCate(cateVO);
		Boolean result = false;
		
		if(res > 0) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("selectCateAction.do")
	@ResponseBody
	public Boolean selectCateAction(@RequestParam(value="Arr[]") String[] Arr) throws Exception {

		Boolean result = true;
		int size = Arr.length;
		System.out.println(Arr);
		System.out.println(Arr[0]);
		for(int i=0;i<size;i++) {
			adminDao.selectCateDelete(Arr[i]);
		}
		
		return result;
	}
	//------------------ 카테고리관리 end --------------------//

	//------------------ QnA관리 start --------------------//
	
	@GetMapping("qnaList.do")
	public String qnaList(Model model, @ModelAttribute("paging")PagingVO paging) {
		
		int totalRowCount=adminDao.getQnaTotalCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		
		List<QnaVO> qnaList=adminDao.getQnaList(paging);
		model.addAttribute("qnaList",qnaList);		

		return "admin/qna/qnaList";
	}

	
	@RequestMapping("qnaAdd.do")
	public String getQnaAdd(Model model) {
		return "admin/qna/qnaAdd";
	}
	
	@RequestMapping("qnaCreate.do")
	public String qnaCreate(Model model, QnaVO qnaVO) throws Exception {
		System.out.println(qnaVO.toString());
		adminDao.insertQna(qnaVO);
		
		model.addAttribute("url","/admin/qnaList.do");
		model.addAttribute("msg","카테고리등록이 완료되었습니다.");
		return "admin/message";
	}
	


	@RequestMapping("qnaEdit.do")
	public String getQnaEdit(Model model,@RequestParam(name = "qnaNo")int qnaNo) {
		QnaVO qnaVO=adminDao.getQna(qnaNo);
		model.addAttribute("qna",qnaVO);
		return "admin/cate/cateEdit";
	}
	
	@RequestMapping("qnaUpdate.do")
	public String qnaUpdate(Model model, QnaVO qnaVO) throws Exception {
		System.out.println(qnaVO.toString());
		adminDao.updateQna(qnaVO);
		
		model.addAttribute("url","/admin/qnaList.do");
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "admin/message";
	}
	
	@RequestMapping("qnaDelete.do")
	@ResponseBody
	public Boolean qnaDelete(@RequestBody QnaVO qnaVO) throws Exception {
		int res = adminDao.deleteQna(qnaVO);
		Boolean result = false;
		
		if(res > 0) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("selectQnaAction.do")
	@ResponseBody
	public Boolean selectQnaAction(@RequestParam(value="Arr[]") String[] Arr) throws Exception {

		Boolean result = true;
		int size = Arr.length;
		System.out.println(Arr);
		System.out.println(Arr[0]);
		for(int i=0;i<size;i++) {
			adminDao.selectQnaDelete(Arr[i]);
		}
		
		return result;
	}
	

	//------------------ QnA관리 end --------------------//
}
