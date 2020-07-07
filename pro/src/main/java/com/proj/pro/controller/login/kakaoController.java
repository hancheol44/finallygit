package com.proj.pro.controller.login;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.LoginDAO;
import com.proj.pro.home.HomeController;
import com.proj.pro.service.kakaoService.KaKaoLogin;
import com.proj.pro.vo.LoginVO;
import com.proj.pro.vo.SalesVO;

@Controller
@RequestMapping("/kakao")
public class kakaoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private KaKaoLogin kakaos;
	
	@Autowired
	private LoginDAO lDAO;
	
	// 회원가입 뷰 맵핑 처리
	@RequestMapping("/Signup.pro")
	public ModelAndView singup(HttpSession session, ModelAndView mv) {
		
		int sid = (int) session.getAttribute("userId");
		String view = "/login/Singup";
		if(sid == 1) {
			System.out.println("Session userId : " + session.getAttribute("userId"));
			RedirectView rv = new RedirectView("/pro/main");
			mv.setView(rv);
		}else {
			mv.setViewName(view);
		}
		return mv;
	}

	
	// 카카오 로그인 맵핑처리
	@RequestMapping(value="/kakaoLogin.pro")
    public ModelAndView login(@RequestParam("code") String code,HttpSession session, ModelAndView mv, LoginVO lVO, Locale locale) {
        String access_Token = kakaos.getAccessToken(code);
        RedirectView rv = null; 
        HashMap<String, Object> userInfo = kakaos.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        int cad = (int) userInfo.get("id");
        int cnt = lDAO.kidCheck(cad);
        String abc = lDAO.sid(cad);
        System.out.println(abc);
        
        Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
        
        
        if(cnt == 1) {
        	session.setAttribute("userId", userInfo.get("id"));
        	session.setAttribute("access_Token", access_Token);
        	System.out.println(userInfo.get("id"));
        	session.setAttribute("SID", abc);
        	logger.info("Login ID : {} - {}", abc,formattedDate);
        	System.out.println(abc);
        	rv = new RedirectView("/pro/main.pro");
        } else {
        	session.setAttribute("userId", userInfo.get("id"));
        	rv = new RedirectView("/pro/kakao/Signup.pro");
        }
        mv.setView(rv);
        return mv;
    }
	
	// 카카오 로그아웃 맵핑처리
	@RequestMapping(value="/logout.pro")
	public ModelAndView logout(HttpSession session, ModelAndView mv) {
	    kakaos.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    session.removeAttribute("SID");
	    RedirectView rv = new RedirectView("/pro/main.pro");
	    mv.setView(rv);
	    return mv;
	}
	
	//회원가입 맵핑 처리
	@RequestMapping("/joinProc.pro")
	public ModelAndView join(HttpSession session, ModelAndView mv, LoginVO lVO) {
		int sid = (int) session.getAttribute("userId");
		session.setAttribute("SID", lVO.getMemid());
		System.out.println("sid");
		lVO.setMemno(sid);
		lDAO.join(lVO);
		System.out.println(sid);
		RedirectView rv = new RedirectView("/pro/main.pro");
		mv.setView(rv);
		return mv;
	}
	
	// 아이디 체크
	@RequestMapping("id.ck")
	@ResponseBody
	public ModelAndView idcheck(HttpSession session, ModelAndView mv) {
		
		String sid = (String) session.getAttribute("SID");
		
		int cnt = lDAO.idCheck(sid);
		
		return mv;
	}
	
	// 마이페이지 폼 처리
	@RequestMapping(value="/myPage.pro")
	public ModelAndView myPage(HttpSession session, ModelAndView mv, SalesVO sVO) {
		int memno = (int) session.getAttribute("userId");
		ArrayList<LoginVO> list = (ArrayList<LoginVO>)lDAO.getList(memno);
		sVO.setMemno(memno);
		ArrayList<SalesVO> list1 = (ArrayList<SalesVO>)lDAO.SalList(sVO);
		mv.addObject("SAL", list1);
		mv.addObject("LIST", list);
		mv.setViewName("login/myPage");
		return mv;
	}
	
	// 회원 정보 수정 처리
	@RequestMapping("/eidtInfoProc.pro")
	public ModelAndView editInfo(HttpSession session, ModelAndView mv,LoginVO lVO) {
		
		String sid = (String) session.getAttribute("SID");
		System.out.println(sid);
		int memno = (int) session.getAttribute("userId");
		System.out.println(lVO);
		lVO.setMemno(memno);
		lDAO.eidtInfo(lVO);
		RedirectView rv = new RedirectView("/pro/main.pro");
		mv.setView(rv);
		return mv;
	}
	
	// 사업자 정보 수정 처리
	@RequestMapping("/busiInfoProc.pro")
	public ModelAndView busiInfo(HttpSession session, ModelAndView mv, LoginVO lVO) {
		
		int memno = (int) session.getAttribute("userId");
		lVO.setMemno(memno);
		lDAO.busiInfo(lVO);
		RedirectView rv = new RedirectView("/pro/main.pro");
		mv.setView(rv);
		return mv;
	}
	
	// 좋아요 리스트 보기
	@RequestMapping("/salListProc.pro")
	public ModelAndView salList(HttpSession session, ModelAndView mv, SalesVO sVO) {
		int memno = (int) session.getAttribute("userId");
		try {
			String view = "/pro/main.pro";
			sVO.setMemno(memno);
			ArrayList<SalesVO> list = (ArrayList<SalesVO>)lDAO.SalList(sVO);
			mv.addObject("SAL", list);
			mv.setViewName(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
}
