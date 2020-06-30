package com.proj.pro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.vo.InfoVO;

public class InfoDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public InfoDAO() {}
	// 자동차 캠핑
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
	
	
	// 자동차 극장
		// infoAC 리스트 sql 가져오기
		public List<InfoVO> getCTList() {
			return sqlSession.selectList("iSQL.sel_ct");
		}
		
		// infoAC 디테일 sql 가져오기
		public InfoVO getCT_Detail(int ifno) {
			return sqlSession.selectOne("iSQL.Detail_ct", ifno);
		}
		
		// infoAC_review sql 가져오기
		public List<InfoVO> getCT_Review_List(int ifno) {
			return sqlSession.selectList("iSQL.review_ct", ifno);
		}
		
		// infoAC_review_Write sql 가져오기
		public int addCT_Review(InfoVO iVO) {
			return sqlSession.insert("iSQL.review_ct_add", iVO);
		}
		
		// infoAC_review Del sql 가져오기
		public int delCT_Review(int ifrno) {
			return sqlSession.update("iSQL.review_ct_del", ifrno);
		}
		
		// infoAC_review Modi sql 가져오기
		public int modCT_Review(InfoVO iVO) {
			return sqlSession.update("iSQL.review_ct_mod", iVO);
		}
		
		
// 승차 검진소
		// infoDT 리스트 sql 가져오기
		public List<InfoVO> getDTList() {
			return sqlSession.selectList("iSQL.sel_dt");
		}
		
		// infoAC 디테일 sql 가져오기
		public InfoVO getDT_Detail(int ifno) {
			return sqlSession.selectOne("iSQL.Detail_dt", ifno);
		}
		
		// infoAC_review sql 가져오기
		public List<InfoVO> getDT_Review_List(int ifno) {
			return sqlSession.selectList("iSQL.review_dt", ifno);
		}
		
		// infoAC_review_Write sql 가져오기
		public int addDT_Review(InfoVO iVO) {
			return sqlSession.insert("iSQL.review_dt_add", iVO);
		}
		
		// infoAC_review Del sql 가져오기
		public int delDT_Review(int ifrno) {
			return sqlSession.update("iSQL.review_dt_del", ifrno);
		}
		
		// infoAC_review Modi sql 가져오기
		public int modDT_Review(InfoVO iVO) {
			return sqlSession.update("iSQL.review_dt_mod", iVO);
		}
	
}
