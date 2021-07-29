package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter implements Filter {

	private String encoding;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding(encoding);

		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paramValue = fConfig.getInitParameter("encoding");
		if (paramValue != null) {
			this.encoding = "utf-8";
		} else {
			this.encoding = paramValue;
		}
	}

}