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
import com.leaf4.app.vo.ItemVO;
import com.leaf4.app.vo.MemberVO;
import com.leaf4.app.vo.PagingVO;

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
	
	//------------------ 상품관리 --------------------//
	
	@GetMapping("orderList.do")
	public String orderList() {
		return "admin/order/orderList";
	}
	
	@GetMapping("cateList.do")
	public String cateList() {
		return "admin/cate/cateList";
	}
	
	
	@GetMapping("qnaList.do")
	public String qnaList() {
		return "admin/qna/qnaList";
	}
}
