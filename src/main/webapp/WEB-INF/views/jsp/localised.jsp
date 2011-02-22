<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/localised</title>
</head>
<body>
	<p>
		<c:out value="${localisedMessage}" />
	</p>
</body>
</html>