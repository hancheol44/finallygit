package com.proj.pro.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proj.pro.dao.SalesDAO;
import com.proj.pro.util.FileUtil;
import com.proj.pro.vo.FileVO;
import com.proj.pro.vo.SalesVO;

@Service("SalesService")
public class SalesService {
	
	@Autowired
	private SalesDAO sDAO;
	
	// Sales List
	public List<SalesVO> getSaList() throws Exception {
		return sDAO.getSaList();
	}
	// Sales Detail
	public SalesVO saDetail(SalesVO sVO) throws Exception {
		return sDAO.saDetail(sVO);
	}
	// Sales Bcnt
	public void saBcnt(int bpno) throws Exception {
		sDAO.saBcnt(bpno);
	}
	// Sales Write
	public SalesVO saWrite(SalesVO sVO) throws Exception {
		return sDAO.saWrite(sVO);
	}
	// Sales Delete
	public int saDelete(int spno) throws Exception {
		return sDAO.saDelete(spno);
	}
	// Sales Edit
	public SalesVO saEdit(SalesVO sVO) throws Exception {
		return sDAO.saEdit(sVO);
	}
	// Review add(ajax)
	public SalesVO reWrite(SalesVO sVO) throws Exception {
		return sDAO.reWrite(sVO);
	}
	// Review List(ajax)
	public List reList(int pno) throws Exception {
		return sDAO.reList(pno);
	}
	// Review Delete
	public int reDelete(SalesVO sVO) throws Exception{
		return sDAO.reDelete(sVO);
	}
	// Sales Image Add
	public int saImage(FileVO fVO, HttpSession session) {
		try {
			// 중복 파일이 안만들어짐
			MultipartFile file = fVO.getFile();
			String filePath = session.getServletContext().getRealPath("resources/upload");
//			String savename = FileUtil.rename(filePath, fVO.getOriname());
			String savename = FileUtil.getSavename(session, file, "upload");
			fVO.setOriname(file.getOriginalFilename());
			fVO.setSavename(savename);
				file.transferTo(new File(filePath, fVO.getOriname()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sDAO.saImage(fVO);
	}
}
