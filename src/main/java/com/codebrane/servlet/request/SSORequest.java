package com.codebrane.servlet.request;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.*;

public class SSORequest extends HttpServletRequestWrapper {
  private Hashtable<String, String> headers = null;
  private Cookie[] cookies = null;

  public SSORequest(HttpServletRequest request) {
    super(request);

    headers = new Hashtable<String, String>();

    cookies = new Cookie[super.getCookies().length];
    cookies = super.getCookies();

		// Copy the original headers from the request
    String buffer = null;
    Enumeration<String> requestHeaderNames = super.getHeaderNames();
    while (requestHeaderNames.hasMoreElements()) {
      buffer = (String)requestHeaderNames.nextElement();
      // Servlet spec states that header names are case insensitive
      headers.put(buffer.toLowerCase(), super.getHeader(buffer));
    }

		/* Add attributes from a dummy SSO conversation. Normally, we would
		 * reach here after being redirected through the SSO process, such
		 * as Shibboleth or SAML2, in which case there will be an implementation
		 * dependent injection of attributes into the process.
		 */
		headers.put("HTTP_fullname", "Harry McDesperate");
		headers.put("HTTP_email", "harrymcd@jumpingupanddown.net");
  }

  public String getHeader(String name) {
    // Look for the header name as is. If it's not there, try all lower case
    return (headers.get(name) != null) ? (String)headers.get(name) : (String)headers.get(name.toLowerCase());
  }

  public boolean headersContain(String name) {
	  return headers.containsKey(name);
  }

  public Enumeration<String> getHeaderNames() {
    return headers.keys();
  }
}
