<!--
This page is always hosted at the remote Identity Provider. When
you login here, imagine you're on your own login page at your
own organisation.
-->

<html>
<head>
	<title>${pageContext.servletContext.contextPath}/login</title>
</head>
<body>
	<p>
		<form action="protected" method="post">
			<input type="text" name="username" value="sdf" /><br />
			<input type="password" name="password" value="sdf" /><br />
			<input type="submit" name="submit" value="Login" />
		</form>
	</p>
</body>
</html>