package com.leaf4.app;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leaf4.app.dao.TodoBoardDao;
import com.leaf4.app.vo.PagingVO;
import com.leaf4.app.vo.TodoBoardVO;

@Controller
public class TodoController {
	@Inject
	TodoBoardDao todoBoardDao;
	
	@RequestMapping("/todo/todoList.do")
	public String todoList(Model model, @ModelAttribute("paging")PagingVO paging) {
		int totalRowCount=todoBoardDao.getTotalRowCount(paging);
		paging.setTotalRowCount(totalRowCount);
		paging.pageSetting();
		System.out.println(totalRowCount);
		System.out.println(paging.toString());
		
		List<TodoBoardVO> todoBoardList=todoBoardDao.getBoardList(paging);
		model.addAttribute("todoBoardList",todoBoardList);
		model.addAttribute("title","게시판");
		System.out.println(todoBoardList.toString());
		return "todo/todoList";
	}
	
	
	@RequestMapping("/todo/todoView.do")
	public String todoView(Model model,int boNo) {
		TodoBoardVO todoBoard=todoBoardDao.getBoard(boNo);
		model.addAttribute("todoBoard",todoBoard);
		return "todo/todoView";
	}
	
	@RequestMapping("/todo/todoEdit.do")
	public String todoEdit(Model model,int boNo) {
		TodoBoardVO todoBoard=todoBoardDao.getBoard(boNo);
		model.addAttribute("todoBoard",todoBoard);
		return "todo/todoEdit";
	}
	
	@RequestMapping("/todo/todoModify.do")
	public String todoModify(@ModelAttribute("todoBoard")TodoBoardVO todoBoard) {
		todoBoardDao.updateBoard(todoBoard);
		return "todo/todoModify";
	}
	@RequestMapping("/todo/todoDelete.do")
	public String todoDelete(@ModelAttribute("todoBoard")TodoBoardVO todoBoard) {
		todoBoardDao.deleteBoard(todoBoard);
		return "todo/todoDelete";
	}
	
	@RequestMapping("/todo/todoForm.do")
	public String todoForm() {
		return "todo/todoForm";
	}
	
	@RequestMapping("/todo/todoRegist.do")
	public String todoEdit(@ModelAttribute("todoBoard")TodoBoardVO todoBoard) {
		todoBoardDao.insertBoard(todoBoard);
		return "todo/todoRegist";
	}
}
