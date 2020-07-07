package com.proj.pro.controller.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proj.pro.service.InfoService;
import com.proj.pro.vo.InfoVO;

@Controller
public class MainController {
	
	@Inject
	InfoService service;
	
	
	@RequestMapping("/main.pro")
	public ModelAndView getMain(ModelAndView mv, InfoVO iVO) {
				try{
		            //파일 객체 생성
		            File file = new File("C:\\spring\\log\\log1.log");
		            //입력 스트림 생성
		            FileReader filereader = new FileReader(file);
		            //입력 버퍼 생성
		            BufferedReader bufReader = new BufferedReader(filereader);
		            String line = "";
		            int linecnt = 0;
		            while((line = bufReader.readLine()) != null){
		                System.out.println(line);
		                linecnt++;
		            }
		            mv.addObject("LCNT", linecnt);
		            //.readLine()은 끝에 개행문자를 읽지 않는다.            
		            bufReader.close();
		        }catch (FileNotFoundException e) {
		            // TODO: handle exception
		        }catch(IOException e){
		            System.out.println(e);
		        }
	    
		        try {
        	iVO = service.getCnt_Main();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mv.addObject("CNT", iVO);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/head.pro")
	public String test02() {
		return "/side/head";
	}

	@RequestMapping("/left.pro")
	public String test03() {
		return "/side/left";
	}

	@RequestMapping("/right.pro")
	public String test04() {
		return "/side/right";
	}

	@RequestMapping("/welcome.pro")
	public String test05() {
		return "/welcome";
	}

	
}
