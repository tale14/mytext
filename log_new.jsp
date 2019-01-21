<%@ page contentType ="text/html;charset=UTF-8" language = "java" pageEncoding = "UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>登录页面</title>
	</head>	
	<body >
	<center>					
		<div>
			<form  action = "servlet_login" method = "post">
				<table class = "a" width = 900px align = center border = 0 cellSpacing = 0 cellPadding = 0>	
					<tr>
						<td height = "105"><img alt = "" src = "image/login_1.gif"></td>
					</tr>
					<tr>
						<td background = image/login_2.jpg height = 300>
							<table height = 300 cellPadding = 0 width = 900 border = 0>
								<tr>
									<td width = 360>										
									</td>
									<td>
										<table cellSpacing=0 cellPadding=2 border= 0>
											<tr>
												<td height = 28 width = 80>用户名:</td>
												<td height = 28 width = 150><input type = "text" name = "username" width = 130px></td>
												<td height = 28 width = 370></td>
											</tr>
											<tr>
												<td height = 28 width = 80>密码:</td>
												<td height = 28 width = 150><input type = "password" name = "password" width = 130px></td>
												<td height = 28 width = 370></td>
											</tr>
											<tr>
												<td height = 28 width = 80></td>
												<td height = 28 width = 150><input type = "image" src = "image/login_button.gif"></td>
												<td height = 28 width = 370></td>
											</tr>										
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td><img src = "image/login_3.jpg"></td>
					</tr>																		
				</table>
			</form>
		</div>			
		</center>	
	</body>

</html>