package com.proj.pro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.pro.vo.FileVO;
import com.proj.pro.vo.SalesVO;

@Repository
public class SalesDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// sales list
	public List getSaList() {
		return sqlSession.selectList("sSQL.saList");
	}
	// sales detail
	public SalesVO saDetail(SalesVO sVO) {
		return sqlSession.selectOne("sSQL.saDetail", sVO);
	}
	// sales bcnt
		public void saBcnt(int bpno) {
			sqlSession.update("sSQL.saBcnt", bpno);
		}
	// sales write
	public SalesVO saWrite(SalesVO sVO) {
		sqlSession.insert("sSQL.saWrite", sVO);
		return sVO;
	}
	// sales delete
	public int saDelete(int spno) {
		return sqlSession.update("sSQL.saDelete", spno);
	}
	// sales edit
	public SalesVO saEdit(SalesVO sVO) {
		sqlSession.update("sSQL.saEdit", sVO);
		return sVO;
	}
	// review add
	public SalesVO reWrite(SalesVO sVO) {
		sqlSession.insert("sSQL.reWrite", sVO);
		return sVO;
	}
	// review list
	public List reList(int pno) {
		return sqlSession.selectList("sSQL.reList", pno);
	}
	// review delete
	public int reDelete(SalesVO sVO) {
		return sqlSession.update("sSQL.reDelete", sVO);
	}
	// sales add image
	public int saImage(FileVO fVO) {
		return sqlSession.insert("sSQL.saImage", fVO);
	}
}
