<%@ page contentType ="text/html;charset=UTF-8" language = "java" pageEncoding = "UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>登录页面</title>		
	</head>	
	<body style = "background:#83A5D3;">
	<center>
	<div class = "top-div" >
			<h2 >梧院点名系统登录界面</h2>				
	</div>
	<div class = "a">	
		<h3 style = "color:red">登录失败</h3>
		<h5 style = "color:red">用户不存在或密码错误</h5>	
			<form  action = "servlet_login" method = "post">
				<table border = "0" >
					<tr>
						<td>用户名:</td>
						<td><input type = "text" name = "username" size = "14"></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type = "password" name = "password" size = "14"></td>
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