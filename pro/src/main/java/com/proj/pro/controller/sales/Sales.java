package com.proj.pro.controller.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.SalesDAO;
import com.proj.pro.service.SalesService;
import com.proj.pro.vo.FileVO;
import com.proj.pro.vo.SalesVO;

@Controller
@RequestMapping("/sales")
public class Sales {
	@Autowired
	SalesDAO sDAO;
	@Inject
	private SalesService service;
	
	// sales list page
	@RequestMapping("/sales.pro")
	public ModelAndView getList(ModelAndView mv) {
		try {
			String view = "sales/sales";
			ArrayList<SalesVO> list = (ArrayList<SalesVO>)service.getSaList();
			mv.addObject("LIST", list);
			mv.setViewName(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
//	
//	@RequestMapping("/sales.pro")
//	public ModelAndView getList(ModelAndView mv) {
//			String view = "sales/sales";
//				ArrayList<SalesVO> list = (ArrayList<SalesVO>) sDAO.getSaList();
//		return mv;
//	}
	
	// sales detail page
	@RequestMapping(value="/sales_inside.pro", method=RequestMethod.GET)
	public ModelAndView saDetail(ModelAndView mv, SalesVO sVO) {
		try {
			String view = "sales/sales_inside";
			service.saBcnt(sVO.getPno());
			SalesVO vo = service.saDetail(sVO);
//			String vv = service.likeck(sVO);
//			System.out.println("detail.sVO : " + sVO.toString());
			mv.addObject("DATA", vo);
			mv.addObject("PNO", sVO.getPno());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	// sales write page
	@RequestMapping("/sales_write.pro")
	public String saWrite() {
		String view ="sales/sales_write";
		return view;
	}
	
	// sales write action
	@RequestMapping(value="/sales_write.pro", method=RequestMethod.POST)
//	@ResponseBody
	public ModelAndView saWriteProc(SalesVO sVO, ModelAndView mv, FileVO fVO,  HttpSession session) {
		try {
			String view = "sales/sales_write";
			if(session.getAttribute("SID") == null) {
				RedirectView rv = new RedirectView("/pro/login/loginList.pro");
				mv.setView(rv);
				return mv;
			}
				if(sVO.getPbd() != null) {
				service.saWrite(sVO);
				RedirectView rv = new RedirectView("/pro/sales/sales.pro");
				mv.setView(rv);
//					return mv;
				}
				service.saImage(fVO, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// sales delete
	@RequestMapping(value="/sales_inside.pro", method=RequestMethod.POST, params= {"spno"})
	public ModelAndView saDelete(int spno, ModelAndView mv, SalesVO sVO) {
		try {
			String view = "sales/sales_inside.pro";
			int cnt = service.saDelete(spno);
			if(cnt == 1) {
				RedirectView rv = new RedirectView("/pro/sales/sales.pro");
				mv.setView(rv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// sales edit page
	@RequestMapping(value="/sales_modify.pro", method=RequestMethod.POST, params= {"pno", "ptt", "pbd", "cate"})
	public ModelAndView saEdit(int pno, String ptt, String pbd, String cate, SalesVO sVO, ModelAndView mv) {
		try {
			String view = "sales/sales_modify";
			SalesVO vo = service.saEdit(sVO);
			mv.addObject("DATA", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// sales edit redirectview
	@RequestMapping(value="/sales_modifyProc.pro", method=RequestMethod.POST, params= {"pno", "ptt", "pbd", "cate"})
	public ModelAndView saEditProc(int pno, String ptt, String pbd, String cate, SalesVO sVO, ModelAndView mv) {
		try {
			String view = "sales/sales_modify";
			SalesVO vo = service.saEdit(sVO);
			RedirectView rv = new RedirectView("/pro/sales/sales_inside.pro?pno="+sVO.getPno());
			mv.setView(rv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// review add(ajax)
	@RequestMapping(value="/sales_review.pro", method=RequestMethod.POST)
	@ResponseBody
	public SalesVO reWrite(SalesVO sVO, @RequestParam("file")MultipartFile file, HttpSession session, ModelAndView mv) {
		try {
			String view = "sales/sales_inside";
			service.reWrite(sVO);
			if(sVO.getRbd() != null) {
				String ii = file.getOriginalFilename();
				System.out.println("oriname : " + ii);
				sVO.setFile(file);
				service.reImage(sVO, session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sVO;
	}
	// review List(ajax)
	@RequestMapping("/reviewList.pro")
	@ResponseBody
	public ArrayList<SalesVO>  reList(ModelAndView mv,SalesVO sVO, int pno) throws Exception {
		ArrayList<SalesVO> list = (ArrayList<SalesVO>)service.reList(pno);
			mv.addObject("LIST", list);
		return list;
	}
	// review delete
	@RequestMapping(value="/reviewDelete.pro", method=RequestMethod.POST, params= {"rno"})
	@ResponseBody
	public Map reDelete(ModelAndView mv, int rno, SalesVO sVO) {
			String view = null;
			int cnt = 0;
			Map<String, Object> map = new HashMap<String, Object>();
//			ArrayList<SalesVO> list = null;
		try {
			view="sales/sales_inside";
			cnt =  service.reDelete(sVO);
			map.put("result", cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/likeCheck.pro", method=RequestMethod.POST)
	@ResponseBody
	public SalesVO like(SalesVO sVO) {
		SalesVO vo = service.likeCheck(sVO);
		return sVO;
	}
	
}
