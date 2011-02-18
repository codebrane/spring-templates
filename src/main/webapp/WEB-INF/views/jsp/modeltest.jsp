<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/modeltest</title>
</head>
<body>
	<p>
		<fmt:message key="modeltest.expression.text"/><br />
		2 + 2 = ${2 + 2}
	</p>
	
	<p>
		<fmt:message key="modeltest.testing.model.text"/><br />
		firstAttributeName = <c:out value="${firstAttributeName}" /><br />
		secondAttributeName = <c:out value="${secondAttributeName}" />
	</p>
</body>
</html>