package com.proj.pro.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
// 이거 풀커밋햇는데;
public class HomeInterceptor2 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String sid = (String) request.getSession().getAttribute("SID");
		
		
		if(sid == null || sid.length() == 0) {
			response.sendRedirect("https://accounts.kakao.com/login?continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fclient_id%3D1c4b9b851fe834e6428dd0977d0c3cbc%26redirect_uri%3Dhttp%3A%2F%2Flocalhost%3A80%2Fpro%2Fkakao%2FkakaoLogin.pro%26response_type%3Dcode");
		} else {
			return true;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


	
}
