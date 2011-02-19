<%@ page import="java.util.Enumeration,
                 java.io.PrintWriter"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>${pageContext.servletContext.contextPath}/protected</title></head>
  <body>
  <%
    String name, value;
    PrintWriter p = response.getWriter();
    Enumeration e = request.getHeaderNames();
    while (e.hasMoreElements()) {
      name = (String)e.nextElement();
      value = request.getHeader(name);
      if (name.startsWith("HTTP_")) {
        p.print(name + " --> " + value + "<br>");
      }
    }
    p.flush();
    p.close();
  %>
  </body>
</html>