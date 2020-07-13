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
	
	// Q&A 페이징 처리
	public int getCnt() {
		return sqlSession.selectOne("qSQL.selCnt");
	}
	// Q&A 게시판 리스트 가져오기 전담 처리 함수
	public List getList(PageUtil page) {
		return sqlSession.selectList("qSQL.qnaList",page);
	}
	
	// Q&A 글쓰기 로그인 회원 이름 가져오기 처리 함수
	public String getName(String SID) {
		return sqlSession.selectOne("qSQL.qnaName", SID);
	}
	
	// Q&A 글쓰기 처리 함수
	public int addData(QnaVO qVO) {
		return sqlSession.insert("qSQL.qnaWrite", qVO);
	}
	
	// Q&A Detail 처리 함수
	public QnaVO getDetail(int qno) {
		return sqlSession.selectOne("qSQL.qnaDetail", qno);
	}
	// Q&A 글 삭제 처리
	public int delData(int qno) {
		System.out.println(qno);
		return sqlSession.update("qSQL.qnaDel", qno);
	}
	// Q&A 관리자 답변 삭제 처리
	public int deiData(int qno) {
		System.out.println(qno);
		return sqlSession.update("qSQL.qnaDel2", qno);
	}
	
	// Q&A 글 수정 처리
	public int mobData(QnaVO qVO) {
		return sqlSession.update("qSQL.mobtn", qVO);
	}
	// Q&A 관리자 글 수정 처리
	public int mobbData(QnaVO qVO) {
		return sqlSession.update("qSQL.mobtnn", qVO);
	}
	// Q&A 관리자 답변 처리
	public int qnaData(QnaVO qVO) {
		return sqlSession.insert("qSQL.qnamno", qVO);
	}
	// Q&A 관리자 답변 디테일 리스트
	public List qornoData(int qorno) {
		return sqlSession.selectList("qSQL.qornoList", qorno);
	}
	// Q&A 관리자 답변 확인
	public int qnaokData(QnaVO qVO) {
		return sqlSession.update("qSQL.qnaok", qVO);
	}
	// Q&A 관리자 답변 확인
	 public int anscnt(QnaVO qVO) {
		 return sqlSession.selectOne("qSQL.anscnt", qVO);
	 }
	// Q&A 조회수
	 public int hits(int qno) {
		 return sqlSession.update("qSQL.hits", qno);
	 }
	// Q&A TOP 5 
	 public List getTop() {
		 return sqlSession.selectList("qSQL.selTop");
	 }
}
