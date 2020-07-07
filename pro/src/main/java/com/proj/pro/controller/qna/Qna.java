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
	public ModelAndView qnalist(ModelAndView mv, PageUtil page, HttpSession session,QnaVO qVO) {
		String sid = (String) session.getAttribute("SID");
			if(page.getNowPage() == 0) {
				page.setNowPage(1);
			}
			int totalCount = qDAO.getCnt();
			page.setPage(totalCount);
			ArrayList<QnaVO> list = (ArrayList<QnaVO>)qDAO.getList(page);
			int stc = page.getEndPage();
			mv.addObject("LIST",list);
//			if(list.get(qVO.getOk()) != null) {
//				int cnt = qDAO.qnaokData(list.get(qVO.getQno()));
//			}
			mv.addObject("PAGE", page);
			mv.setViewName("qna/qnaList");
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
	@RequestMapping(value="/qnaDetail.pro", method=RequestMethod.GET, params= "qno")
	public ModelAndView qnaDetail(ModelAndView mv, QnaVO qVO, int qno) {
		String view = "/qna/qnaDetail";
		qVO = qDAO.getDetail(qVO.getQno());
		qVO.setQorno(qno);
		 ArrayList<QnaVO> list = (ArrayList<QnaVO>)qDAO.qornoData(qVO.getQorno());
		mv.addObject("LIST", list);
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
		int cnt = qDAO.delData(qno);

		mv.setView(rv);
		return mv;
	}
	// qna 글 수정
	@RequestMapping(value="/mobtnProc.pro", method=RequestMethod.POST, params= {"qtt","qip"})
	public ModelAndView mobtnProc(ModelAndView mv, QnaVO qVO) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		int cnt = qDAO.mobData(qVO);
		mv.setView(rv);
		return mv;
	}
	// qna 답변 해주기
	@RequestMapping(value="/qnamnoProc.pro", method=RequestMethod.POST, params= {"qtt","qip","qorno"})
	public ModelAndView qnamnoProc(ModelAndView mv, HttpSession session, String qtt, String qip, int qorno, QnaVO qVO) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		String sid = (String)session.getAttribute("SID");
		qVO.setMemid(sid);
		qVO.setQtt(qtt);
		qVO.setQip(qip);
		qVO.setQorno(qorno);
		System.out.println(qVO);
//		if(qDAO.anscnt(qVO) > 0) {
			qDAO.qnaokData(qVO);
//		}
		int cnt = qDAO.qnaData(qVO);
		mv.addObject("DETAIL", qVO);
		mv.setView(rv);
		return mv;
	}
}