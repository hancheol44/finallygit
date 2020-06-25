package com.proj.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.pro.dao.BoardDAO;
import com.proj.pro.vo.BoardVO;


@Service("BoardService")
public class BoardService {
	
	private BoardDAO bDAO;

	@Autowired
	public void setbDAO(BoardDAO bDAO) {
		this.bDAO = bDAO;
	}

	// Board List
	public List<BoardVO> getList() throws Exception {
		return bDAO.getList();
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
	public void comment(BoardVO bVO, String memid) throws Exception{
		String bd = bVO.getBdbd();
		
		bVO.setBdbd(bd);
		bVO.setMemid(memid);
		bDAO.comment(bVO);
	}
	
	// BOard Edit View
	public BoardVO EditView(BoardVO bVO) throws Exception{
	
		return bDAO.EditView(bVO);
	}
	
	// Board Edit
	public void BoardEdit(BoardVO bVO, int bno) throws Exception{
		String ct = bVO.getBdct();
		String tt = bVO.getBdtt();
		String bd = bVO.getBdbd();
		System.out.println("ct : " + ct);
		System.out.println("tt : " + tt);
		System.out.println("bd : " + bd);
		System.out.println("no : " + bno);
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
	

	
}
