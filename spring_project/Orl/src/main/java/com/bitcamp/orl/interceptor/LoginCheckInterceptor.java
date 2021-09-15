package com.bitcamp.orl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Interceptor prehandle in");

		// 1. 로그인 여부 확인
		// 2. 로그인 상태에 따라 true/false로 return
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		
		// getSession() == getSession(true) : 세션이 생성되어 있으면 해당 세션 리턴,
		// 생성되어 있지 않으면 새로운 세션을 생성하여 리턴
		// getSession(false) : 세션이 생성되어 있으면 해당 세션 리턴,
		// 생성되어 있지 않으면 null을 리턴, 즉 객체가 생성되어있을 때만 사용 가능함
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("memberVo") != null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/member/login?referer=" + request.getRequestURI());
		return false;
	}

}
