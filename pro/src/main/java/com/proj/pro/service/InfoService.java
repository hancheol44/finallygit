package com.proj.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.pro.dao.InfoDAO;
import com.proj.pro.vo.InfoVO;

@Service
public class InfoService {
	
	@Autowired
	InfoDAO iDAO;
	// 자동차 캠핑
	
	// InfoAC List
	public List<InfoVO> getAC_List() throws Exception {
		return iDAO.getACList();
	}
	
	// InfoAC Detail
	public InfoVO getAC_Detail(int ifno) throws Exception {
		return iDAO.getAC_Detail(ifno);
	}
	
	// infoAC Review List
	public List<InfoVO> getAC_Review_List(int ifno) throws Exception {
		return iDAO.getAC_Review_List(ifno);
	}
	
	// InfoAC Review Write
	public int addAC_Review_Write(InfoVO iVO) throws Exception {
		return iDAO.addAC_Review(iVO);
	}
	
	// InfoAC Review Del
	public int delAC_Review(int ifrno) throws Exception {
		return iDAO.delAC_Review(ifrno);
	}
	
	// InfoAC Review Modi
	public int modAC_Review(InfoVO iVO) throws Exception{
		return iDAO.modAC_Review(iVO);
	}
	
	// 자동차 극장
	// InfoAC List
		public List<InfoVO> getCT_List() throws Exception {
			return iDAO.getCTList();
		}
		
		// InfoAC Detail
		public InfoVO getCT_Detail(int ifno) throws Exception {
			return iDAO.getCT_Detail(ifno);
		}
		
		// infoAC Review List
		public List<InfoVO> getCT_Review_List(int ifno) throws Exception {
			return iDAO.getCT_Review_List(ifno);
		}
		
		// InfoAC Review Write
		public int addCT_Review_Write(InfoVO iVO) throws Exception {
			return iDAO.addCT_Review(iVO);
		}
		
		// InfoAC Review Del
		public int delCT_Review(int ifrno) throws Exception {
			return iDAO.delCT_Review(ifrno);
		}
		
		// InfoAC Review Modi
		public int modCT_Review(InfoVO iVO) throws Exception{
			return iDAO.modCT_Review(iVO);
		}
		
		
		
		
		// 승차 검진소
		// InfoDT List
			public List<InfoVO> getDT_List() throws Exception {
				return iDAO.getDTList();
			}
			
			// InfoDT Detail
			public InfoVO getDT_Detail(int ifno) throws Exception {
				return iDAO.getDT_Detail(ifno);
			}
			
			// infoDT Review List
			public List<InfoVO> getDT_Review_List(int ifno) throws Exception {
				return iDAO.getDT_Review_List(ifno);
			}
			
			// InfoDT Review Write
			public int addDT_Review_Write(InfoVO iVO) throws Exception {
				return iDAO.addDT_Review(iVO);
			}
			
			// InfoDT Review Del
			public int delDT_Review(int ifrno) throws Exception {
				return iDAO.delDT_Review(ifrno);
			}
			
			// InfoDT Review Modi
			public int modDT_Review(InfoVO iVO) throws Exception{
				return iDAO.modDT_Review(iVO);
			}
}
