<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding = "UTF-8" import = "java.sql.*"%>  
<%@ page import = "com.gxwuz.call.bean.Stu" %>
<%@ page import = "com.gxwuz.call.dao.Prepared_course" %>
<%@ page import = "com.gxwuz.call.util.DButil" %>
<%@ page import = "java.util.List"%>

<!DOCTYPE html>
<html>
	<head>
		<title>课程信息管理</title>					
		<style >
			/* 头顶标题   */
			.top-div{
 				margin:0; 
 				padding:0; 
				width:100%;
				height:40px;
				top:0px;
				background-color:#323625;
				text-align:center;
				font-color:#FDFDFD:
			}
 			/* 大容器div*/
			.content{	
 				margin:0; 
				padding:0;			 
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
				width:50%;
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
		<div class = "content" >
			<div class = "left-div">
				<table class = "left-table" >
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
				<h4>您的任课信息:</h4>
				<form action = "courese_modify.jsp">
					<table class = "center-table" border = "1">
						<tr>
							<th>课程名称</th>
							<th>上课时间</th>
							<th>上课周期</th>
						</tr>
						<%
							Prepared_course p = new Prepared_course();
							List<Stu> list = p.GetStu();
							for(Stu c:list)
							{%>		
						<tr>
							<td><%=c.getCourseName() %></td>
							<td><%=c.getCourseTime() %></td>
							<td><%=c.getCoursePeriod() %></td>
						</tr>
							<%}
						%>										
					</table>
					<input type="submit" value="修改" >
				</form>
			</div>											
		</div>
		<div class = "bottom-div" >
			<h3 style = "font-size:14px">miracle@创奇科技有限公司</h3>				
		</div>																														
	</body>


</html>