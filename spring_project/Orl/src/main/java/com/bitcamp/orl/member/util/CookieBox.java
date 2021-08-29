package com.bitcamp.orl.member.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	// request객체를 이용해서 모든 Cookie객체를 Map에 저장
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	// 생성자를 이용해서 Map에 저장할 데이터를 초기화
	// CookieBox 객체가 생성될 때 모든 쿠키값들이 위에 생성된 Map에 들어가도록 처리
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	// 쿠키 객체를 생성하는 메소드 : 오버 로딩, static 처리
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	
	// 객체 생성 - 쿠키 검색(존재유무), 쿠키 이름으로 쿠키 객체 반환, 쿠키 이름으로 쿠키 값을 반환
	
	// 쿠키 이름으로 쿠키 객체 반환
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	// 쿠키 이름으로 쿠키 값을 반환
	public String getCookieValue(String name) throws UnsupportedEncodingException {
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
	// 이름으로 쿠키가 존재하는지 확인하는 메서드
	public boolean existCookie(String name) {
		// HashMap에서 get(key)하면, value값 가져옴
		// cookieMap에서 key값은 이름이고 value값은 Cookie객체
		// cookie 이름으로 Cookie객체를 찾아보고, null일 경우 false 반환, null이 아닐 경우 true 반한
		return cookieMap.get(name) != null ;
	}
}
