package com.proj.pro.controller.board;

import java.util.ArrayList;

import javax.inject.Inject;
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

@Controller
@RequestMapping("/board")
public class Board {
	@Autowired
	BoardDAO bDAO;
	@Inject
	private BoardService service;
	
	@RequestMapping("/cnt.pro")
	public void cnt(BoardVO bVO) throws Exception{
		service.cnt(bVO);
	}
	
	@RequestMapping(value = "/board.pro", method =RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv, BoardVO bVO) throws Exception {

		String view = "board/board";
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) service.getList(bVO);
		mv.addObject("LIST", list);
		System.out.println(list.size());
		mv.setViewName(view);
		return mv;
	}
	@RequestMapping(value = "/search.pro", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView mv, BoardVO bVO) throws Exception {
		String view = "board/board";
		System.out.println("�꽌移�");
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
		mv.addObject("LIST", rest);
		System.out.println(rest.size());
		return rest;
	}
	@RequestMapping(value = "/boardDetail.pro", method = RequestMethod.GET, params = "bdno")
	public ModelAndView boardDetail(ModelAndView mv, BoardVO bVO, int bdno) throws Exception {
		String view = "board/boardDetail";
		BoardVO vo = service.bDetail(bVO);
		mv.addObject("DATA", vo);
		
		mv.setViewName(view);
		return mv;
	}

	@RequestMapping("/boardWrite.pro")
	public ModelAndView boardWrite(HttpSession session, ModelAndView mv) {
		String view = "board/boardWrite";
		mv.setViewName(view);
		return mv;
	}
	
	@RequestMapping(value="boardComment.pro", method = RequestMethod.POST)
	@ResponseBody
	public BoardVO comment( BoardVO bVO, HttpSession session) throws Exception{
		try {
			String memid = (String) session.getAttribute("SID");
			System.out.println(bVO);
			service.comment(bVO, memid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return bVO;
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
		service.BoardDelete(bdno);
		return "redirect:board.pro";
		
	}
	
	

 

}
