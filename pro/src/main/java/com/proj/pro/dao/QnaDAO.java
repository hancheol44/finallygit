package com.proj.pro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.util.PageUtil;
import com.proj.pro.vo.QnaVO;

public class QnaDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public QnaDAO() {}
	
	// qna 게시판 리스트 가져오기 전담 처리 함수
	public int getCnt() {
		return sqlSession.selectOne("qSQL.selCnt");
	}
	public List getList(PageUtil page) {
		return sqlSession.selectList("qSQL.qnaList",page);
	}
	
	// 글쓰기 로그인 회원 이름 가져오기 처리 함수
	public String getName(String SID) {
		return sqlSession.selectOne("qSQL.qnaName", SID);
	}
	
	// 글쓰기 처리 함수
	public int addData(QnaVO qVO) {
		return sqlSession.insert("qSQL.qnaWrite", qVO);
	}
	
	// Detail 처리 함수
	public QnaVO getDetail(int qno) {
		return sqlSession.selectOne("qSQL.qnaDetail", qno);
	}
	
	public int delData(int qno) {
		System.out.println(qno);
		return sqlSession.update("qSQL.qnaDel", qno);
	}
}
