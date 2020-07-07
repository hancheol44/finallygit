package com.proj.pro.controller.info;

/**
 * @author 이한철
 * @since  2020.07.01
 * 
 * 	이 클래스는 info 요청에 대한 컨트롤러이다.
 */

import java.util.*;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proj.pro.dao.*;
import com.proj.pro.service.*;
import com.proj.pro.vo.*;


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
	@RequestMapping(value="/infoAC_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
	@ResponseBody
	public InfoVO infoDetail(InfoVO iVO) {
		try {
		  	iVO = service.getAC_Detail(iVO);
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
	
	
	// ajax addr 주소 테스트
	@RequestMapping("/infoAC_Addr")
	@ResponseBody
	public ArrayList<InfoVO> AC_Addr(InfoVO iVO) throws Exception{
			ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getAC_Addr(iVO);
			return list;
	}
		
		
	// infoCT 뷰 처리
	@RequestMapping("/infoCT.pro")
	public ModelAndView getViewCT(ModelAndView mv) {
		try {
			String view = "info/infoCT";
			ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getCT_List();
			mv.addObject("CT_NAME_LIST", list);
			mv.setViewName(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	// infoCT 디테일 ajax 처리
	@RequestMapping(value="/infoCT_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
	@ResponseBody
	public InfoVO infoCTDetail(InfoVO iVO) {
		try {
		  	iVO = service.getCT_Detail(iVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return iVO;
	}
		
		// infoCT_Review List ajax 처리
		@RequestMapping(value="/infoCT_ReviewList", method=RequestMethod.POST, params={"ifno"})
		@ResponseBody
		public ArrayList<InfoVO> CT_ReviewList(int ifno) throws Exception{
				ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getCT_Review_List(ifno);
				return list;
		}
		
		// infoCT Review Write ajax 처리
		@RequestMapping(value="/infoCT_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
		@ResponseBody
		public InfoVO CT_ReviewWrite(InfoVO iVO) {
			try {
			  int cnt = service.addCT_Review_Write(iVO);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return iVO;
		}
		
		// infoCT Review Modi ajax 처리
		@RequestMapping(value="/infoCT_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
		@ResponseBody
		public Integer CT_ReviewMod(InfoVO iVO) {
			int cnt = 0;
			try {
				cnt = service.modCT_Review(iVO);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return cnt;
		}
		
		// infoCT Review Del ajax 처리
		@RequestMapping(value="/infoCT_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
		@ResponseBody
		public Integer CT_ReviewDel(int ifrno) {
			System.out.println("왔니?");
			int cnt = 0;
			try {
				cnt = service.delCT_Review(ifrno);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return cnt;
		}
	
	
		// ajax addr 주소 테스트
		@RequestMapping("/infoCT_Addr")
		@ResponseBody
		public ArrayList<InfoVO> CT_Addr(InfoVO iVO) throws Exception{
				ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getCT_Addr(iVO);
				return list;
		}
	
	
		
		// infoDT 뷰 처리
		@RequestMapping("/infoDT.pro")
		public ModelAndView getViewDT(ModelAndView mv) {
			try {
				String view = "info/infoDT";
				ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getDT_List();
				mv.addObject("DT_NAME_LIST", list);
				mv.setViewName(view);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return mv;
		}
		
		// infoDT 디테일 ajax 처리
		@RequestMapping(value="/infoDT_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
		@ResponseBody
		public InfoVO infoDTDetail(InfoVO iVO) {
			try {
			  	iVO = service.getDT_Detail(iVO);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return iVO;
		}
			
			// infoDT_Review List ajax 처리
			@RequestMapping(value="/infoDT_ReviewList", method=RequestMethod.POST, params={"ifno"})
			@ResponseBody
			public ArrayList<InfoVO> DT_ReviewList(int ifno) throws Exception{
					ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getDT_Review_List(ifno);
					return list;
			}
			
			// infoDT Review Write ajax 처리
			@RequestMapping(value="/infoDT_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
			@ResponseBody
			public InfoVO DT_ReviewWrite(InfoVO iVO) {
				try {
				  int cnt = service.addDT_Review_Write(iVO);
				} catch(Exception e) {
					e.printStackTrace();
				}
				return iVO;
			}
			
			// infoDT Review Modi ajax 처리
			@RequestMapping(value="/infoDT_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
			@ResponseBody
			public Integer DT_ReviewMod(InfoVO iVO) {
				int cnt = 0;
				try {
					cnt = service.modDT_Review(iVO);
				} catch(Exception e) {
					e.printStackTrace();
				}
				return cnt;
			}
			
			// infoDT Review Del ajax 처리
			@RequestMapping(value="/infoDT_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
			@ResponseBody
			public Integer DT_ReviewDel(int ifrno) {
				System.out.println("왔니?");
				int cnt = 0;
				try {
					cnt = service.delDT_Review(ifrno);
				} catch(Exception e) {
					e.printStackTrace();
				}
				return cnt;
			}
			
			// ajax addr 주소 테스트
			@RequestMapping("/infoDT_Addr")
			@ResponseBody
			public ArrayList<InfoVO> DT_Addr(InfoVO iVO) throws Exception{
					ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getDT_Addr(iVO);
					return list;
			}
			
			
			// 좋아요 기능 ajax 처리
			@RequestMapping("/infoLike")
			@ResponseBody
			public InfoVO infolike(InfoVO iVO) throws Exception {
				iVO = service.likeproc(iVO);
				return iVO;
			}
			
			
			// 메인페이지 팝니당 위치정보 ajax 처리
			//@RequestMapping("/main_Addr")
			//@ResponseBody
			//public ArrayList<SalesVO> main_Addr(SalesVO sVO) throws Exception{
				//ArrayList<SalesVO> list = (ArrayList<SalesVO>) service.getMain_Addr(sVO);
				//return list;
			//}

}
