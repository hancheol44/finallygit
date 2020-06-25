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
}
