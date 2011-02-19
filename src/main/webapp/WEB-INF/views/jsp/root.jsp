<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/root</title>
</head>
<body>
	<p>
		Welcome to the Spring Minimal Web Application!
	</p>
	
	<p>
		Interceptor: <c:out value="${requestScope.interceptor}" />
	</p>
</body>
</html>