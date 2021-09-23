package com.hammall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminAuthInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(AdminAuthInterceptor.class);
	private static final String LOGIN = "adLoginStatus";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		
		// 인증체크작업
		if(session.getAttribute(LOGIN) == null) {
			logger.info("로그인 안되어있음");
			
			targetSave(request);
			
			response.sendRedirect("/admin/");
			return false; // controller로 제어가 넘어가지 않음
		}
		
		return true; // controller로 제어가 넘어감
	}

	// 세션이 소멸된 상태이거나 비로그인시 요청한 주소를 저장
	// 사용자가 로그인이 진행되면, 요청한 주소가 있으면 그곳으로 이동. 없으면 루트로 이동
	private void targetSave(HttpServletRequest request) {
		
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		
		if(queryString == null || queryString.equals("null")) {
			queryString = "";
		}else {
			queryString ="?" + queryString;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("targetSave: " + (uri + queryString));
			request.getSession().setAttribute("targetURI", uri + queryString);
		}
	}
	
	
}
