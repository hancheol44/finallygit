package com.proj.pro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.pro.dao.QnaDAO;
import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.QnaVO;


@Service("QnaService")
public class QnaService {

	private QnaDAO qDAO;
	
	@Autowired
	public void setqDAO(QnaDAO qDAO) {
		this.qDAO = qDAO;
	}
	public QnaVO getDetail(int qno) throws Exception{
		return qDAO.getDetail(qno);
	}
	public int hits(int qno) throws Exception{
		
		return qDAO.hits(qno);
	}

}
