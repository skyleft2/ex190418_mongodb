package com.example.ex190418_mongodb.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex190418_mongodb.model.member.dto.MemberDTO;
import com.example.ex190418_mongodb.service.member.MemberService;
import com.example.ex190418_mongodb.service.member.MemberServiceImpl;

@Controller
@RequestMapping("/member/") // 공통적인 mapping
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping("login.do") // 세부 mapping
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}
	
	
	@RequestMapping("login_check.do") // 세부 mapping
	public String login_check(ModelMap model, String _id, String passwd, String name, HttpSession session) throws Exception {
		
		MemberDTO dto = memberService.loginCheck(_id, passwd);
		String msg;
		String url;
		
		if(dto==null) {
			msg = "로그인 정보 틀림";
			url = "member/login";
		}else {
			msg = dto.getName() + " 야 환영해";
			url = "home";
			session.setAttribute("userid", _id);
			session.setAttribute("name", dto.getName());
		}
		model.addAttribute("msg", msg);
				
		return url;
	}
	
	@RequestMapping("logout.do") // 세부 mapping
	public String loginout(HttpSession session) throws Exception {
		
		session.invalidate();
						
		// redirect 미사용시 url이 member/logout.do 로 나옴. redirect 사용시 login.do 로  
		return "redirect:/member/login.do";
	}
	
	
	@RequestMapping("join.do") // 세부 mapping
	public ModelAndView join() {
		return new ModelAndView("member/join");
	}
	
	
	@RequestMapping("member_join.do") // 세부 mapping
	public String member_join(String _id, String passwd, String name) throws Exception {
		
		MemberDTO dto = new MemberDTO();
		dto.set_id(_id);
		dto.setPasswd(passwd);
		dto.setName(name);
		
		memberService.join(dto);
		
		return "redirect:/member/login.do";
	}
}
