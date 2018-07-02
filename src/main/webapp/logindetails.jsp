<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
input {
	font-family: Cambria(Headings);
	font-size: 20px;
	color: blue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Details</title>
</head>
<body>


	<form action="LoginServlet" method="post">
		<fieldset title="LOGIN">
				<h3>login sucess</h3>
		
			<legend>
				<B>LOGIN</B>
			</legend>
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="user_name"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="login"></td>
					<td><input type="reset" value="reset"></td>
					
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><a href="changepassword.html">Forgot Password?</a></td>
				</tr>
				<td><a href="registration.html">SIGNUP</a></td>
			</table>
		</fieldset>
	</form>
</body>
</html>