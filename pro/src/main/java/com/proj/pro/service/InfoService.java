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
}
