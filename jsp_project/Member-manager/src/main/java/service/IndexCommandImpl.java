package service;

import javax.servlet.http.HttpServletRequest;

public class IndexCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "/WEB-INF/views/index.jsp";

	}

}
