<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Logout" method="post">
<h1>WELCOME</h1>
<h2>you can do your works now....</h2>
<%String user_name=(String)request.getSession().getAttribute("user_name");
out.print(user_name);%>
<input type="submit" value="Logout"/>
</form>
</body>
</html>