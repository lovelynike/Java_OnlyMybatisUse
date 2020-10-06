<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>${result1}</P>
<P>${result2.idx}/${result2.content}</P>
<P>${result3.idx}/${result3.content}</P>

<P>
	<c:forEach var="dummy" items="${result4}">
		${dummy.idx}/${dummy.content}
		<a href="delete?idx=${dummy.idx}">delete</a>
		<br>
	</c:forEach>
</P>

<form action="insert" method="post">
	ID<input type="text" name="id">
	PW<input type="text" name="pw">
	Content<input type="text" name="content">
	<input type="submit">
</form>

</body>
</html>
