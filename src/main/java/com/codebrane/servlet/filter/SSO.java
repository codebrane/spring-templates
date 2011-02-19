package com.codebrane.servlet.filter;

import com.codebrane.servlet.request.SSORequest;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SSO implements Filter {
	public void init(FilterConfig config) throws ServletException {}
	
	public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain filterChain) throws IOException, ServletException {
		/* This flow is hard wired. Normally it would be automatically handled by a real
		 * Shibboleth or SAML2 Filter, such as the Guanxi::SP::Guard module.
		 * User views protected.jsp
		 * Filter detects there are no credentials in the request so the user is redirected to login.jsp
		 * User logs in at login.jsp
		 * Filter detects credentials in the request this time and injects dummy attributes into the request
		 * Filter redirects to the originally requested page, protected.jsp
		 */

		/* If the SSO process has completed, inject the dummy attributes.
		 * In this case, the request will be destined for:
		 * MainController::doProtected
		 */
		if (request.getParameter("username") != null) {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			SSORequest ssoRequest = new SSORequest(httpRequest);
			request.getRequestDispatcher("/WEB-INF/views/jsp/protected.jsp").forward(ssoRequest, response);
			filterChain.doFilter(ssoRequest, response);
			return;
		}
		
		/* There are no credentials in the request so initiate the SSO process.
		 * Do this by redirecting to the login page. In a real SSO scenario the
		 * login URL would be at a remote site and its location would be determined
		 * using metadata. When you see the login page, imagine it's at your own
		 * organisation's site.
		 */
		request.getRequestDispatcher("/WEB-INF/views/jsp/login.jsp").forward(request, response);
		filterChain.doFilter(request, response);
  }

	public void destroy() {}
}
