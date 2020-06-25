package com.proj.pro.controller.info;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	// infoCT 뷰 처리
	@RequestMapping("/infoCT.pro")
	public ModelAndView getViewCT(ModelAndView mv) {
		String view = "info/infoCT";
		mv.setViewName(view);
		return mv;
	}
	
	// infoAC 뷰 처리
	@RequestMapping("/infoAC.pro")
	public ModelAndView getViewAC(ModelAndView mv) {
		try {
			String view = "info/infoAC";
			ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getAC_List();
			mv.addObject("LIST", list);
			mv.setViewName(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
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
