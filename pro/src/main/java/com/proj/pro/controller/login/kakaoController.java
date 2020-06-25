package com.proj.pro.controller.login;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
@Controller
@RequestMapping("/kakao")
public class kakaoController {
	
	@Autowired
	private KaKaoLogin kakao;
	
	@RequestMapping(value="/")
	public String index() {
		
		return "main";
	}
	
	// 카카오 로그인 맵핑처리
	@RequestMapping(value="/kakaoLogin.pro")
    public ModelAndView login(@RequestParam("code") String code,HttpSession session, ModelAndView mv) {
        String access_Token = kakao.getAccessToken(code);
        RedirectView rv = new RedirectView("/pro/main.pro");
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        
        if(userInfo.get("email") != null) {
        	session.setAttribute("SID", userInfo.get("email"));
        	session.setAttribute("access_Token", access_Token);
        }
        mv.setView(rv);
        return mv;
    }
	
	// 카카오 로그아웃 맵핑처리
	@RequestMapping(value="/logout.pro")
	public ModelAndView logout(HttpSession session, ModelAndView mv) {
	    kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    RedirectView rv = new RedirectView("/pro/login/loginList.pro");
	    mv.setView(rv);
	    return mv;
	}
	
}
