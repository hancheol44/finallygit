package com.proj.pro.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.LoginDAO;
import com.proj.pro.vo.LoginVO;

@Controller
@RequestMapping("/login")
public class login {
	
	
	  @Autowired LoginDAO lDAO;
	  
	
	 
	//로그인 뷰 처리
	@RequestMapping("/loginList.pro")
	public ModelAndView loginList(HttpSession session, ModelAndView mv) {
		
		String sid = (String) session.getAttribute("SID");
		String view = "login/loginList";
		if(sid != null) {
			System.out.println("Session SID : " + session.getAttribute("SID"));
			RedirectView rv = new RedirectView("/pro/main");
			mv.setView(rv);
		}else {
			mv.setViewName(view);
		}
		return mv;
	}

	
	/*
	 * @RequestMapping("/main.pro") public ModelAndView LoginProc(HttpSession
	 * session, ModelAndView mv) {
	 * 
	 * String sid = (String) session.getAttribute("SID"); String view =
	 * "login/main"; if(sid != null) { RedirectView rv = new RedirectView("main");
	 * mv.setViewName(view); } return mv;
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(path= {"/loginList.pro"}) public ModelAndView
	 * doolcuri(ModelAndView mv){ String view = "main"; mv.setViewName(view); return
	 * mv; }
	 */
	
	 @RequestMapping(value="/loginProc.pro", method=RequestMethod.POST, params= {"!id","!pw"})
	 public ModelAndView loginProcRedirect(String id, String pw, ModelAndView mv) 
	 { System.out.println("### redirect ###");
	  System.out.println("### id : " + id); System.out.println("### pw : " + pw);
	  
	   //임시로 당분간 로그인페이지로 Redirect 시키기로 하자. 
	   RedirectView rv = new
	  RedirectView("/pro/login/loginList.pro");
	  
	  mv.setView(rv); return mv;
	   }
	 
	@RequestMapping(value="/loginProc.pro", method=RequestMethod.POST, params= {"id","pw"})
	   public ModelAndView loginProc(String id, String pw, LoginVO lVO, ModelAndView mv, HttpSession session) { 
	 
	      int cnt = lDAO.login(lVO);
	      
	      RedirectView rv = null;
	      if(cnt == 1) {
	         session.setAttribute("SID", id);
	         rv = new RedirectView("/pro/main.pro");
	      } else {
	         // 아이디와 비밀번호에 맞는 회원이 없는 경우이므로 다시 로그인 페이지로 이동시킨다.
	         rv = new RedirectView("/pro/login/loginList.pro");
	      }
	      mv.setView(rv);
	      return mv;
	   }
	   //로그아웃 처리요청
		@RequestMapping("/logout.pro")
		public ModelAndView logout(HttpSession session, ModelAndView mv) {
			String view = "/pro/login/loginList.pro";
			
			RedirectView rv = null;
			session.removeAttribute("SID");
			
			if(session.getAttribute("SID") != null) {
				view="/pro/main.pro";
			}
			rv = new RedirectView(view);
			mv.setView(rv);
			return mv;
		}
		
}
