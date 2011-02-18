<html>
<head>
	<title>${pageContext.servletContext.contextPath}/upload</title>
</head>
<body>
	<p>
		<form action="uploadaction" method="post" enctype="multipart/form-data">
			<input type="file" name="file" size="50" />
			<input type="submit" value="Upload" />
		</form>
	</p>
</body>
</html>