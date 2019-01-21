<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding = "UTF-8" import = "java.sql.*"%>  
<%@ page import = "com.gxwuz.call.bean.Stu" %>
<%@ page import = "com.gxwuz.call.util.DButil" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<title>点名系统</title>
		
		<style >
 			/* 头顶标题   */
			.top-div{
 				margin:apx; 
 				padding:0; 
				width:100%;
				height:40px;
				top:0px;
				background-color:#323625;
				text-align:center;
				font-color:#FDFDFD;
			}
 			/* 大容器div*/
			.content{						 
				width:100%;
				height:480px;
				top:0px;
			}	
			/* 左边导航栏div*/		
			.left-div{
				width:20%;
				height:300px;
				top:0px;
				float:left;	
				text-align:center;					
			}
			/* 左边导航栏div里面的表格 */	
			.left-table{
				width:100%;
				height:260px;	
																		
			}
			.center-div{
				float:left;
				width:80%;
				height:300px;
			}
			.center-table{
				width:30%;
				height:140px;
				text-align:center;
			}
			.bottom-div	{
				float:left;
				width:100%;
				height:40px;
				background-color:#323625;
				text-align:center;
				font-color:#FDFDFD;		
			}						
			a{
				text-decoration:none;
			}
			tr.left-tr:hover{
				background-color:blue;				
			}

		</style>
		
	</head>
	<body>
		<div class = "top-div" >
			<h3 style = "font-size:30px">梧院教务点名系统</h3>				
		</div>
		<div class = "content">
			<div class = "left-div">
				<table class = "left-table" border = "0" >
					<tr class = "left-tr">
						<td><a href = "personal.html" style = "color:black">个人信息管理</a> </td>
					</tr>
					<tr class = "left-tr">
						<td><a href = "classmanage.jsp" style = "color:black">班级信息管理</a> </td>
					</tr>
					<tr class = "left-tr">
						<td><a href = "importjsp.jsp" style = "color:black">导入学生信息</a> </td>
					</tr>
					<tr class = "left-tr">
						<td><a href = "course.jsp" style = "color:black">课程信息管理</a></td>
					</tr>
					<tr class = "left-tr">
						<td><a href = "call.jsp" style = "color:black">点名</a>  </td>
					</tr>
					<tr class = "left-tr">
						<td><a href = "score.jsp" style = "color:black">学生成绩</a> </td>
					</tr>			
				</table>
			</div>	
				<h3 style = "text-align:center">课程信息管理界面</h3>
			<div class = "center-div">
				<form action = "Servlet_Course" method = "post">
					<table class = "center-table">
						<tr>	
							<td>课程名称:</td>
							<td><input type = "text" name = "courseName"></td>							
						</tr>
						<tr>	
							<td>上课时间:</td>
							<td><input type = "text" name = courseTime></td>							
						</tr>
						<tr>	
							<td>上课周期:</td>
							<td><input type = "text" name = "coursePeriod"></td>							
						</tr>
						<tr>
							<td><input type = "submit" value = "提交"></td>
							<td><input type = "reset" value = "重置"></td>
						</tr>
					</table>				
				</form>
			
			</div>										
		</div>	
		<div class = "bottom-div" >
			<h3 style = "font-size:14px">miracle@创奇科技有限公司</h3>				
		</div>																														
	</body>

</html>