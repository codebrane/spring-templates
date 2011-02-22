<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/uploadresult</title>
</head>
<body>
	
	<p>
		<c:out value="${error}" />
	</p>
	
	<p>
		The file named <c:out value="${uploadedFileName}" /> of type <c:out value="${contentType}" /> was uploaded!
	</p>  
	
</body>
</html>