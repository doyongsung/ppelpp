package service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		int result =0;
		try {
		result	= MemberRegService.getInstance().regMember(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		
		
		return "/WEB-INF/views/reg_view.jsp";
	}

}
