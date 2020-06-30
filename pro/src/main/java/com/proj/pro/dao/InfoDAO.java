package com.proj.pro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.vo.InfoVO;

public class InfoDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public InfoDAO() {}
	
	// infoAC 리스트 sql 가져오기
	public List<InfoVO> getACList() {
		return sqlSession.selectList("iSQL.sel_ac");
	}
	
	// infoAC 디테일 sql 가져오기
	public InfoVO getAC_Detail(int ifno) {
		return sqlSession.selectOne("iSQL.Detail_ac", ifno);
	}
	
	// infoAC_review sql 가져오기
	public List<InfoVO> getAC_Review_List(int ifno) {
		return sqlSession.selectList("iSQL.review_ac", ifno);
	}
	
	// infoAC_review_Write sql 가져오기
	public int addAC_Review(InfoVO iVO) {
		return sqlSession.insert("iSQL.review_ac_add", iVO);
	}
	
	// infoAC_review Del sql 가져오기
	public int delAC_Review(int ifrno) {
		return sqlSession.update("iSQL.review_ac_del", ifrno);
	}
	
	// infoAC_review Modi sql 가져오기
	public int modAC_Review(InfoVO iVO) {
		return sqlSession.update("iSQL.review_ac_mod", iVO);
	}
	
}
