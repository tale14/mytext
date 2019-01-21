<%@ page contentType ="text/html;charset=UTF-8" language = "java" pageEncoding = "UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>登录页面</title>
	</head>	
	<body style = "background:#83A5D3">
	<center>
	<div class = "top-div" >
			<h2 >梧院点名系统注册界面</h2>				
	</div>
		<h4 style = "color:red" >注册失败！输入为空或两次密码不相同</h4>
	<div>
		<form  action = "Servlet_register" method = "post">
				<table border = "0" >
					<tr>
						<td>用户名:</td>
						<td><input type = "text" name = "username" size = "14"></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type = "password" name = "passwordone" size = "14"></td>
					</tr>
					<tr>
						<td>再次输入:</td>
						<td><input type = "password" name = "passwordtwo" size = "14"></td>
					</tr>
					<tr>
						<td colspan = "2" align = "center" ><input type = "submit" value = "登录">
						<input type = "reset" value = "重置"></td>						
					</tr>				
				</table>
			</form>
		</div>
		</center>
	</body>

</html>