package com.proj.pro.controller.qna;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.QnaDAO;
import com.proj.pro.service.QnaService;
import com.proj.pro.service.SalesService;
import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class Qna {

	@Autowired
	QnaDAO qDAO;
	@Inject
	private QnaService service;
	  
	// Q&A 리스트 뷰 요청 처리, 페이징처리
	@RequestMapping("/qnaList.pro")
	public ModelAndView qnalist(ModelAndView mv, PageUtil page, HttpSession session,QnaVO qVO) {
		String sid = (String) session.getAttribute("SID");
			if(page.getNowPage() == 0) {
				page.setNowPage(1);
			}
			int totalCount = qDAO.getCnt();
			page.setPage(totalCount);
			ArrayList<QnaVO> list = (ArrayList<QnaVO>)qDAO.getList(page);
			ArrayList<QnaVO> TOP = (ArrayList<QnaVO>)qDAO.getTop();
			int stc = page.getEndPage();
			mv.addObject("TOP",TOP);
			mv.addObject("LIST",list);
			mv.addObject("PAGE", page);
			mv.setViewName("qna/qnaList");
			return mv;
	}
	/*
	 * // Q&A 리스트 뷰 요청 처리, TOP5
	 * 
	 * @RequestMapping("/selTop.pro") public ModelAndView selTop(ModelAndView mv,
	 * HttpSession session, QnaVO qVO) { String sid = (String)
	 * session.getAttribute("SID"); ArrayList<QnaVO> list =
	 * (ArrayList<QnaVO>)qDAO.getTop(); mv.addObject("LIST",list);
	 * mv.setViewName("qna/qnaList"); return mv; }
	 */
	
	// Q&A 글쓰기 뷰 요청 처리
	@RequestMapping("/qnaWrite.pro")
	public ModelAndView qnaWrite(HttpSession session, ModelAndView mv) {
		
		String sid = (String)session.getAttribute("SID");
		
		String name = qDAO.getName(sid);
		String view = "/qna/qnaWrite";
		
		mv.addObject("NAME", name);
		mv.setViewName(view);
		return mv;
	}
	
	// Q&A 디테일 요청 처리
	@RequestMapping(value="/qnaDetail.pro", method=RequestMethod.GET, params= "qno")
	public ModelAndView qnaDetail(ModelAndView mv, QnaVO qVO, int qno, HttpServletRequest request, HttpServletResponse response, HttpSession session ) throws Exception {
		String view = "/qna/qnaDetail";
		 QnaVO vo = service.getDetail(qno);
		
		 qVO = qDAO.getDetail(qVO.getQno()); 
		qVO.setQorno(qno);
		qVO.setQno(qno);
		/* qDAO.hits(qVO.getQno()); */
		 ArrayList<QnaVO> list = (ArrayList<QnaVO>)qDAO.qornoData(qVO.getQorno());
		mv.addObject("LIST", list);
		mv.addObject("DETAIL", qVO);
		mv.addObject("qno", qno);
		mv.setViewName(view);
		
		Cookie[] cookies = request.getCookies();
		
		// 비교하기 위해 새로운 쿠키
		Cookie viewCookie = null;
		
		// 쿠키가 있을 경우
		if (cookies != null && cookies.length > 0)
		{
			for (int i = 0 ; i < cookies.length; i++)
			{
				// Cookie의 name이 cookie + qno와 일치하는 쿠키를 viewCookie에 넣어줌
				if (cookies[i].getName().equals("cookie" +qno))
				{
					System.out.println("처음 쿠키가 생성한 뒤 들어옴");
					viewCookie = cookies[i];
				}
			}
		}
		if(vo != null) {
			System.out.println("System - 해당 상세 리뷰페이지로 넘어감");
			mv.addObject("DATA", vo);
			
			// 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함.
			if(viewCookie == null) {
				System.out.println("cookie 없음");
			
				// 쿠키 생성(이름, 값)
				Cookie newCookie = new Cookie("cookie"+qno, "|" + qno + "|");
				
				// 쿠키 추가
				response.addCookie(newCookie);
				
				// 쿠키를 추가 시키고 조회수 증가시킴
				 int result = service.hits(qno);
				 if(result>0){
					 System.out.println("조회수 증가");
				}else {
					System.out.println("조회수 증가 에러");
				}
			}
			// viewCookie가 null이 아닐경우 쿠키가 있으므로 조회수 증가 로직을 처리하지 않음.
			else{
				System.out.println("cookie 있음");
				
				// 쿠키 값 받아옴.
				String value = viewCookie.getValue();
				
				System.out.println("cookie 값:" + value);
			}
			mv.setViewName(view);
		}
		return mv;
	}
	
	// Q&A 글쓰기
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
	
	// Q&A 글삭제
	@RequestMapping(value="/qnaDelProc.pro", method=RequestMethod.POST, params="qno")
	public ModelAndView qnaDelProc(ModelAndView mv, int qno) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		int cnt = qDAO.delData(qno);

		mv.setView(rv);
		return mv;
	}

	
	  // Q&A 관리자 글 삭제
	  
	  @RequestMapping(value="/qnaDel2Proc.pro", method=RequestMethod.POST,params="qno")
	  public ModelAndView qnaDel2Proc(ModelAndView mv, int qno) {
	  RedirectView rv = new RedirectView("/pro/qna/qnaList.pro"); 
	  int cnt = qDAO.deiData(qno);
	  mv.setView(rv);
	  return mv; 
	  
	  }
			  
	// Q&A 글 수정
	@RequestMapping(value="/mobtnProc.pro", method=RequestMethod.POST, params= {"qtt","qip"})
	public ModelAndView mobtnProc(ModelAndView mv, QnaVO qVO) {
		RedirectView rv = new RedirectView("/pro/qna/qnaList.pro");
		int cnt = qDAO.mobData(qVO);
		mv.setView(rv);
		return mv;
	}
	// Q&A 답변 해주기  , 답변 확인 유무
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
//			qDAO.qnaokData(qVO);
//		}
		int cnt = qDAO.qnaData(qVO);
		mv.addObject("DETAIL", qVO);
		mv.setView(rv);
		return mv;
	}
}