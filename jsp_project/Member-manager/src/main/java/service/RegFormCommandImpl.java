package service;

import javax.servlet.http.HttpServletRequest;

public class RegFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "regForm.jsp";
	}

}
