package com.leaf4.app;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leaf4.app.dao.LoginDao;
import com.leaf4.app.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	@Inject
	LoginDao loginDao;
	
//	@RequestMapping("/isLogin.do")
//	public String isLogin() {
//		return "login/isLogin";
//	}
	
	@GetMapping("login.do")
	public String loginGet() {
		return "login/login";
	}
	
	@PostMapping("isLogin.do")
	public String loginPost(String memId, String memPw, HttpSession session) {
		
		//id, pw는 사용자가 입력한 id와 pw
		MemberVO member=loginDao.getMember(memId);
		if(member==null) { 
			return "redirect:/login/login.do";
		
		}else { //id는 맞음
			if(!member.getMemPass().equals(memPw)) { //비밀번호는 틀림
				return "redirect:/login/login.do";
			}else { //비밀번호도 맞음
				session.setAttribute("MEMBER", member);
				if(member.getMemId().equals("admin"))
					return "redirect:/admin/admin.do";
				else
					return "redirect:/";
			}
		}
	}
	
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("MEMBER");
		return "redirect:/";
	}
	
	@RequestMapping("idCheck.do")
	@ResponseBody //Map<String,String> map
	public Boolean idCheck(@RequestBody MemberVO memberVO) throws Exception {
		//System.out.println(memberVO.toString());
		MemberVO member=loginDao.getMember(memberVO.getMemId());
		Boolean result = false;
		
		if(member==null) {
			result = true;
		}
		
		return result;
	}
	
	
	@RequestMapping("memberForm.do")
	public String memberForm() {
		return "login/memberForm";
	}
	
	@RequestMapping("memberRegist.do")
	public String memberRegist(MemberVO member) {
		loginDao.insertMember(member);
		return "redirect:/login/login.do";
	}
}
