package com.proj.pro.controller.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.proj.pro.dao.BoardDAO;
import com.proj.pro.service.BoardService;
import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.BoardVO;
import com.proj.pro.vo.SalesVO;

@Controller
@RequestMapping("/board")
public class Board {
	@Autowired
	BoardDAO bDAO;
	@Inject
	private BoardService service;
	
	@RequestMapping("/cocnt.pro")
	public void cocnt(BoardVO bVO) throws Exception{
	}

	@RequestMapping(value = "/board.pro", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getList(ModelAndView mv, BoardVO bVO, PageUtil page) throws Exception {
		String view = "board/board";
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) service.getList(bVO);
		mv.addObject("LIST", list);
		System.out.println(list.size());
		mv.setViewName(view);
		return mv;
	}
	
	
	@RequestMapping(value = "/reBoard.pro")
	@ResponseBody
	public ArrayList<BoardVO> reBoard(ModelAndView mv,BoardVO bVO, int bdno) throws Exception{
		ArrayList<BoardVO> rest =(ArrayList<BoardVO>) service.rest(bdno);
		System.out.println(rest.size());
		return rest;
	}
	@RequestMapping(value = "/boardDetail.pro", method = RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv, BoardVO bVO,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		String view = "board/boardDetail";
		BoardVO vo = service.bDetail(bVO);
		System.out.println(bVO.getBdno());
		Cookie[] cookies = request.getCookies();
        
        // 비교하기 위해 새로운 쿠키
        Cookie viewCookie = null;
 
        // 쿠키가 있을 경우 
        if (cookies != null && cookies.length > 0) 
        {
            for (int i = 0; i < cookies.length; i++)
            {
                // Cookie의 name이 cookie + bdno와 일치하는 쿠키를 viewCookie에 넣어줌 
                if (cookies[i].getName().equals("cookie"+bVO.getBdno()))
                { 
                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
                    viewCookie = cookies[i];
                }
            }
        }
        
        if (vo != null) {
            System.out.println("System - 해당 상세 리뷰페이지로 넘어감");
            
            mv.addObject("DATA", vo);
 
            // 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함.
            if (viewCookie == null) {    
                System.out.println("cookie 없음");
                
                // 쿠키 생성(이름, 값)
                Cookie newCookie = new Cookie("cookie"+bVO.getBdno(), "|" + bVO.getBdno() + "|");
                                
                // 쿠키 추가
                response.addCookie(newCookie);
 
                // 쿠키를 추가 시키고 조회수 증가시킴
                int result = service.cnt(bVO.getBdno());
                
                if(result>0) {
                    System.out.println("조회수 증가");
                }else {
                    System.out.println("조회수 증가 에러");
                }
            }
            // viewCookie가 null이 아닐경우 쿠키가 있으므로 조회수 증가 로직을 처리하지 않음.
            else {
                System.out.println("cookie 있음");
                
                // 쿠키 값 받아옴.
                String value = viewCookie.getValue();
                
                System.out.println("cookie 값 : " + value);
        
            }
		
		mv.setViewName(view);
        }
        return mv;
	}

	@RequestMapping("/boardWrite.pro")
	public ModelAndView boardWrite(HttpSession session, ModelAndView mv) {
		String view = "board/boardWrite";
		mv.setViewName(view);
		return mv;
	}
	
	
	@RequestMapping(value = "/boardWriteProc.pro", method = RequestMethod.POST)
	public String writeProc( BoardVO bVO, HttpSession session) throws Exception {
		String memid = (String) session.getAttribute("SID");
		service.boardWrite(bVO, memid);
		return "redirect:board.pro";
	}
	
	@RequestMapping(value = "/boardEdit.pro", method = RequestMethod.GET, params = "bdno")
	public ModelAndView EditView(ModelAndView mv, BoardVO bVO, int bdno) throws Exception{
		String view = "board/boardWrite";
		
		BoardVO vo= service.EditView(bVO);
		mv.addObject("EDIT", vo);
		mv.addObject("bdno", bdno);
		mv.setViewName(view);
		return mv;
	}
	
	@RequestMapping(value = "/boardEditProc.pro", method = RequestMethod.POST)
	public String editProc(BoardVO bVO, HttpSession session) throws Exception{
		service.BoardEdit(bVO);
		return "redirect:board.pro";
	}
	@RequestMapping(value = "/boardDelete.pro", method = RequestMethod.GET, params = "bdno")
	public String Delete(int bdno) throws Exception{
		System.out.println("컨트롤러 도착");
		service.BoardDelete(bdno);
		System.out.println("컨트롤러 끝");
		return "redirect:board.pro";
		
	}
	@RequestMapping(value = "/reDelete.pro", method = RequestMethod.POST)
	@ResponseBody
	public void reDelete(int bdno) throws Exception{
		System.out.println("컨트롤러 도착");
		System.out.println("re" + bdno);
		service.BoardDelete(bdno);
		System.out.println("컨트롤러 끝");
		
	}
	
	@RequestMapping(value="/likeCheck.pro", method=RequestMethod.POST)
	@ResponseBody
	public BoardVO like(BoardVO bVO) {
//		BoardVO vo = service.likeCheck(bVO);
		return bVO;
	}

	@RequestMapping(value="/boardComment.pro", method = RequestMethod.POST)
	@ResponseBody
	public BoardVO comment(BoardVO bVO, HttpSession session) throws Exception{
		System.out.println("bVO " + bVO.getBorino());
		String memid = (String)session.getAttribute("SID");
		service.comment(bVO, memid);
		
		
		System.out.println("컨트롤러 " + bVO);
		return bVO;
	}
	@RequestMapping(value = "/starRanking.pro")
	@ResponseBody
	public ArrayList<SalesVO> starRanking(SalesVO sVO) throws Exception{
		ArrayList<SalesVO> starlist =(ArrayList<SalesVO>) service.starRanking(sVO);
		System.out.println(starlist.size());
		return starlist;
		
	}

}
