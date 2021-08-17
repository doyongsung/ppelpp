package com.bitcamp.op.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutoCheckInterceptor {

	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws IOException {
		
		System.out.println("AutoCheckInterceptor preHandle() 진입");
		
		// 1. 로그인 여부 확인
		// 2 .로그인 상태에 따라 true / false 로 return
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		// 로그인 상태 확인
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			return true;
		}
		
		// header의 referer 없이 이전 페이지로 이동하도록 처리
		// rarameter로 이전 uri 전달
		response.sendRedirect(request.getContextPath()+"/member/login?referer="+request.getRequestURI());
				return false;
		
	}
	
	
}
