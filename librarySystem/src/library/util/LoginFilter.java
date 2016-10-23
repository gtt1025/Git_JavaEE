package library.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	String noFilterURL = "";

	public void init(FilterConfig filterConfig) throws ServletException {
		noFilterURL = filterConfig.getInitParameter("noFilter");

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String tmpStr = request.getRequestURI().substring(
				request.getRequestURI().indexOf("/") + 1);
		String uri = tmpStr.substring(tmpStr.indexOf("/"));
		if (noFilterURL.indexOf(uri) < 0) {
			HttpSession session = request.getSession();
			if (session.getAttribute("sessionData") == null) {
				request
						.setAttribute("error",
								"ÄúÉÐÎ´µÇÂ¼£¬Çë<a href='operatorLogin.jsp' target='window_name'>µÇÂ¼</a>");
				RequestDispatcher dis = servletRequest
						.getRequestDispatcher("error.jsp");
				dis.forward(request, response);
				return;

			}
		}

		filterChain.doFilter(servletRequest, servletResponse);

	}

	public void destroy() {

	}
}
