<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>

	<%
		response.setContentType("text/html");
		out.print("<h3>successfully logged out</h3>");
		request.getRequestDispatcher("index2.jsp").include(request, response);
	%>

</body>
</html>