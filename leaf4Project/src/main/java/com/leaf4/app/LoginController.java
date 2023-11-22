package com.leaf4.app;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leaf4.login.dao.ILoginDao;
import com.leaf4.member.vo.MemberVO;


@Controller
public class LoginController {
	@Inject
	ILoginDao loginDao;
	
	
	@RequestMapping("/login/isLogin.wow")
	public String isLogin() {
		return "login/isLogin";
	}
	
	@GetMapping("/login/login.wow")
	public String loginGet() {
		return "login/login";
	}
	@PostMapping("/login/login.wow")
	public String loginPost(String id, String pw, HttpSession session) {
		//id, pw는 사용자가 입력한 id와 pw
		MemberVO member=loginDao.getMember(id);
		if(member==null) return "redirect:/login/login.wow";
		else { //id는 맞음
			if(!member.getMemPass().equals(pw)) { //비밀번호는 틀림
				 return "redirect:/login/login.wow";
			}else { //비밀번호도 맞음
				session.setAttribute("MEMBER", member);
				return "redirect:/login/isLogin.wow";
			}
		}
	}
	
	
	@RequestMapping("/login/logout.wow")
	public String logout(HttpSession session) {
		session.removeAttribute("MEMBER");
		return "redirect:/login/isLogin.wow";
	}
	
	
	@RequestMapping("/login/memberForm.wow")
	public String memberForm() {
		return "login/memberForm";
	}
	
	@RequestMapping("/login/memberRegist.wow")
	public String memberRegist(MemberVO member) {
		loginDao.insertMember(member);
		return "redirect:/login/isLogin.wow";
	}
	
	
}
