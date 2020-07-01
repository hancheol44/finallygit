package com.proj.pro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.BoardVO;

public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	public BoardDAO() {
	}
	public void cnt(BoardVO bVO) {
		sqlSession.update("bSQL.cnt", bVO);
	}

	public List getList(BoardVO bVO) {
		return sqlSession.selectList("bSQL.boardList", bVO);
	}
	public List sList(BoardVO bVO) {

		return sqlSession.selectList("bSQL.search",bVO);
	}
	
	public BoardVO bDetail(BoardVO bVO) {
		return sqlSession.selectOne("bSQL.boardDetail", bVO);			
	}
	
	public BoardVO write(BoardVO bVO) {
		 sqlSession.insert("bSQL.boardWrite", bVO);
		 return bVO;
	}
	public BoardVO comment(BoardVO bVO) {
		 sqlSession.insert("bSQL.comment", bVO);
		 return bVO;
	}
	
	public BoardVO EditView(BoardVO bVO) {
		return sqlSession.selectOne("bSQL.boardEditView", bVO);
	}
	public BoardVO EditProc(BoardVO bVO) {
		 sqlSession.update("bSQL.boardEdit", bVO);
		return bVO;
	}
	public int Delete(int bdno) {
		System.out.println("DAO" + bdno);
		return sqlSession.update("bSQL.Delete",bdno);
	}
	public List rest(int bdno) {
		System.out.println("DAO" + bdno);
		return sqlSession.selectList("bSQL.rest",bdno);
	}
	
}
