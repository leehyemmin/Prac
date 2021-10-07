package com.hammall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인증처리작업: HttpSession 로그인생성
public class userLoginInterceptor extends HandlerInterceptorAdapter{

	
	private static final Logger logger = LoggerFactory.getLogger(userLoginInterceptor.class);
	private static final String LOGIN = "loginStatus";
	
	
	// Object handler : URL Mapping주소에 해당하는 메서드 자체를 가리킴
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}
	
	// 컨트롤러의 매핑주소- /member/loginPost(메서드호출) -> postHandle 메서드 -> 뷰(jsp)화면처리 작업이 진행됨(loginPost.jsp)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		// 로그인 인증처리하기 위한 세션객체 확보
		HttpSession session = request.getSession();
		
		// 로그인시 Model정보를 참조하는 작업
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");
		
		if(memberVO != null) {
			
			logger.info("...로그인 성공");
			session.setAttribute(LOGIN, memberVO);
			
			Object targetUrl = session.getAttribute("targetUrl");
			
			response.sendRedirect(targetUrl != null ? (String)targetUrl : "/");
		}
		
		//response.sendRedirect("/"); 이 위치에서는 지원이 안됨
		// ajax요청시 인터셉터는 정상작동되지 않음
	}
	
}
