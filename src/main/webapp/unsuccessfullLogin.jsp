<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>INVALID DETAILS</h1>
<%String id=(String)request.getSession().getAttribute("user_name");
out.print(id);%>
<input type="submit" value="Logout"/>
</form>
</body>