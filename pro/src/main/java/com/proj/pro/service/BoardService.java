package com.proj.pro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.pro.dao.BoardDAO;
import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.BoardVO;
import com.proj.pro.vo.SalesVO;


@Service("BoardService")
public class BoardService {
	
	private BoardDAO bDAO;

	@Autowired
	public void setbDAO(BoardDAO bDAO) {
		this.bDAO = bDAO;
	}
//	public int getTotal(BoardVO bVO) throws Exception{
//		
//		String ct = bVO.getBdct();
//		String tp = bVO.getType();
//		String ip = bVO.getInput();
//		System.out.println(ct);
//		
//		bVO.setBdct(ct);
//		bVO.setType(tp);
//		bVO.setInput(ip);
//	
//		
//		return bDAO.getTotal(bVO);
//	}
//	
	public int cnt(int bdno) throws Exception{
		
		return bDAO.cnt(bdno);
	}

	// Board List
	public List<BoardVO> getList(BoardVO bVO) throws Exception {


		
		
		return bDAO.getList(bVO);
	}

	// Board Detail
	public BoardVO bDetail(BoardVO bVO) throws Exception{
		return bDAO.bDetail(bVO);
	}
	
	// Board Write
	public void boardWrite(BoardVO bVO, String memid) throws Exception{
		String ct = bVO.getBdct();
		String tt = bVO.getBdtt();
		String bd = bVO.getBdbd();
		
		System.out.println("ct : " + ct);
		System.out.println("tt : " + tt);
		System.out.println("bd : " + bd);
		bVO.setBdct(ct);
		bVO.setBdtt(tt);
		bVO.setBdbd(bd);
		bVO.setMemid(memid);
		bDAO.write(bVO);
		
	}
	public BoardVO comment(BoardVO bVO, String memid) throws Exception{
		int bori = bVO.getBorino();
		String bd = bVO.getBdbd();
		
		bVO.setMemid(memid);
		bVO.setBorino(bori);
		bVO.setBdbd(bd);
		return bDAO.comment(bVO);
	}
	
	// BOard Edit View
	public BoardVO EditView(BoardVO bVO) throws Exception{
	
		return bDAO.EditView(bVO);
	}
	
	// Board Edit
	public void BoardEdit(BoardVO bVO) throws Exception{
		String ct = bVO.getBdct();
		String tt = bVO.getBdtt();
		String bd = bVO.getBdbd();
		int bno = bVO.getBdno();
		System.out.println("ct : " + ct);
		System.out.println("tt : " + tt);
		System.out.println("bd : " + bd);
		bVO.setBdct(ct);
		bVO.setBdtt(tt);
		bVO.setBdbd(bd);
		bVO.setBdno(bno);
		bDAO.EditProc(bVO);
	}
	
	public void BoardDelete(int bdno) throws Exception{
		System.out.println("���� : " + bdno);
		bDAO.Delete(bdno);
		
	}
	public List<BoardVO> rest(int bdno) throws Exception{
		
		return bDAO.rest(bdno);
	}
	
	public List<SalesVO> starRanking(SalesVO sVO) throws Exception{
		return bDAO.starRanking(sVO);
	}
	


	
}
