package com.proj.pro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.vo.LoginVO;
import com.proj.pro.vo.SalesVO;


public class LoginDAO {
	@Autowired
	
	SqlSessionTemplate sqlSession;
	
	public LoginDAO() {}
	
	public int idCheck(String id) {
		return sqlSession.selectOne("lSQL.idCount", id);
	}
	
	public int kidCheck(int kid) {
		return sqlSession.selectOne("lSQL.kidCount", kid);
	}
	
	public int login(LoginVO lVO) { 
		  return sqlSession.selectOne("lSQL.Login",lVO); 
	}
	
	public int join(LoginVO lVO) {
		return sqlSession.insert("lSQL.join",lVO);
	}
	
	public String sid(int memno) {
		return sqlSession.selectOne("lSQL.kakasid", memno);
	}
	
	public int eidtInfo(LoginVO lVO) {
		return sqlSession.update("lSQL.editInfo", lVO);
	}

	public List getList(int memno) {
		return sqlSession.selectList("lSQL.selInfo", memno);
	}
	
	public int busiInfo(LoginVO lVO) {
		return sqlSession.update("lSQL.busiInfo", lVO);
	}
	
	public List SalList(SalesVO sVO) {
		return sqlSession.selectList("lSQL.salList", sVO);
	}
	
}
