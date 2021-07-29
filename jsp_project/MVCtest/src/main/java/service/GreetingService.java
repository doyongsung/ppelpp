package service;

import javax.servlet.http.HttpServletRequest;

public class GreetingService {

	// 사용자 요청을 처리하고 view의 경로를 반환하는 메소드
	public String greeting(HttpServletRequest request) {
		
		// 핵심처리...
		request.setAttribute("result", "안녕하세요");
		
		return "/WEF-INF/views/greeting.jsp";
		
	}
}
