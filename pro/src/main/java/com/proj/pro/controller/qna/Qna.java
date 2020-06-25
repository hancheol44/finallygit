package com.proj.pro.controller.qna;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.QnaDAO;
import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class Qna {

	@Autowired
	QnaDAO qDAO;
	  
	// qna리스트 뷰 요청 처리
	@RequestMapping("/qnaList.pro")
	public ModelAndView qnalist(ModelAndView mv, PageUtil page, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		if(sid == null || sid.length() == 0) {
			RedirectView rv = new RedirectView("/pro/login/loginList.pro");
			mv.setView(rv);
		} else {
			if(page.getNowPage() == 0) {
				page.setNowPage(1);
			}
			int totalCount = qDAO.getCnt();
			page.setPage(totalCount);
			ArrayList<QnaVO> list = (ArrayList<QnaVO>)qDAO.getList(page);
			
			mv.addObject("LIST",list);
			mv.addObject("PAGE", page);
			mv.setViewName("qna/qnaList");
		}
			return mv;
	}
	
	// qna글쓰기 뷰 요청 처리
	@RequestMapping("/qnaWrite.pro")
	public ModelAndView qnaWrite(HttpSession session, ModelAndView mv) {
		
		String sid = (String)session.getAttribute("SID");
		
		String name = qDAO.getName(sid);
		String view = "/qna/qnaWrite";
		
		mv.addObject("NAME", name);
		mv.setViewName(view);
		return mv;
	}
	
	// qna 디테일 요청 처리
	@RequestMapping(value="/qnaDetail.pro", method=RequestMethod.GET, params="qno")
	public ModelAndView qnaDetail(ModelAndView mv, QnaVO qVO, int qno) {
		String view = "/qna/qnaDetail";
		qVO = qDAO.getDetail(qno);
		mv.addObject("DETAIL", qVO);
		mv.addObject("qno", qno);
		mv.setViewName(view);
		return mv;
	}
	
	// qna 글쓰기
	@RequestMapping(value="/qnaWriteProc.pro", method=RequestMethod.POST, params= {"qtt","qip"})
	public ModelAndView qnaWriteProc(ModelAndView mv, HttpSession session, String qtt, String qip, QnaVO qVO) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		String sid = (String)session.getAttribute("SID");
		qVO.setQtt(qtt);
		qVO.setQip(qip);
		qVO.setMemid(sid);
		
		int cnt = qDAO.addData(qVO);
		
		mv.setView(rv);
		return mv;
	}
	
	// qna 글삭제
	@RequestMapping(value="/qnaDelProc.pro", method=RequestMethod.POST, params="qno")
	public ModelAndView qnaDelProc(ModelAndView mv, int qno) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		System.out.println(qno);
		int cnt = qDAO.delData(qno);

		mv.setView(rv);
		return mv;
	}
	
	
}
