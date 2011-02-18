<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/modeltest</title>
</head>
<body>
	<p>
		Testing expression language support:<br />
		2 + 2 = ${2 + 2}
	</p>
	
	<p>
		Testing the Model:<br />
		firstAttributeName = <c:out value="${firstAttributeName}" /><br />
		secondAttributeName = <c:out value="${secondAttributeName}" />
	</p>
</body>
</html>