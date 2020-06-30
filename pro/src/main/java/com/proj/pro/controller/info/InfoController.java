package com.proj.pro.controller.info;

import java.util.*;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proj.pro.dao.InfoDAO;
import com.proj.pro.service.InfoService;
import com.proj.pro.vo.InfoVO;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	InfoDAO iDAO;
	
	@Inject
	private InfoService service;
	
	
	// infoAC 뷰 처리
	@RequestMapping("/infoAC.pro")
	public ModelAndView getViewAC(ModelAndView mv) {
		try {
			String view = "info/infoAC";
			ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getAC_List();
			mv.addObject("AC_NAME_LIST", list);
			mv.setViewName(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
		
	// infoAC 디테일 ajax 처리
	@RequestMapping(value="/infoAC_Detail", method=RequestMethod.POST , params= {"ifno"})
	@ResponseBody
	public InfoVO infoDetail(int ifno, ModelAndView mv, InfoVO iVO) {
		try {
		  	iVO = service.getAC_Detail(ifno);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return iVO;
	}
	
	// infoAC_Review List ajax 처리
	@RequestMapping(value="/infoAC_ReviewList", method=RequestMethod.POST, params={"ifno"})
	@ResponseBody
	public ArrayList<InfoVO> AC_ReviewList(int ifno) throws Exception{
			ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getAC_Review_List(ifno);
			return list;
	}
	
	// infoAC Review Write ajax 처리
	@RequestMapping(value="/infoAC_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
	@ResponseBody
	public InfoVO AC_ReviewWrite(InfoVO iVO) {
		try {
		  int cnt = service.addAC_Review_Write(iVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return iVO;
	}
	
	// infoAC Review Modi ajax 처리
	@RequestMapping(value="/infoAC_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
	@ResponseBody
	public Integer AC_ReviewMod(InfoVO iVO) {
		int cnt = 0;
		try {
			cnt = service.modAC_Review(iVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// infoAC Review Del ajax 처리
	@RequestMapping(value="/infoAC_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
	@ResponseBody
	public Integer AC_ReviewDel(int ifrno) {
		System.out.println("왔니?");
		int cnt = 0;
		try {
			cnt = service.delAC_Review(ifrno);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
		
		
	// infoCT 뷰 처리
	@RequestMapping("/infoCT.pro")
	public ModelAndView getViewCT(ModelAndView mv) {
		String view = "info/infoCT";
		mv.setViewName(view);
		return mv;
	}
	
	
	
	// infoDT 뷰 처리
	@RequestMapping("/infoDT.pro")
	public ModelAndView getViewDT(ModelAndView mv) {
		String view = "info/infoDT";
		mv.setViewName(view);
		return mv;
	}

}
