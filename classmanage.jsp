<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding = "UTF-8" import = "java.sql.*"%>  
<%@ page import = "com.gxwuz.call.bean.*"%>

<%@ page import = "com.gxwuz.call.dao.Prepared_Class" %>
<%@ page import = "java.util.List" %>


<!DOCTYPE html>
<html>
	<head>
		<title>班级信息管理</title>						
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
				overflow-y:auto;
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
				<h3 style = "text-align:center">班级信息管理界面</h3>
			<div class = "center-div">
				<form action = "">
					<table class = "center-table" border = "1">
						<tr>
							<th>名字</th>
							<th>班级</th>
							<th>缺勤</th>
							<th>早退</th>
						</tr>
						<% 	
							Prepared_Class a = new Prepared_Class();
							List<Stu> list = a.GetStu();
							for(Stu all:list)
							
							{%>
						<tr>	
							<td><%=all.getName() %></td>
							<td><%=all.getClassNo() %></td>
							<td><%=all.getMark() %></td>
							<td><%=all.getLast() %></td>
						</tr>
						
							<%} 
						
						%>									 
					</table>
<!-- 					<table border = "0"> -->
<!-- 						<tr> -->
<!-- 							<td><input type = "button" value = "修改" onclick = "window.location.href('class.jsp')"></td> -->
<!-- 						</tr> -->
<!-- 					</table> -->
				</form>
				<form action = "class.jsp">
                	<input type="submit" value="修改" >
            	</form>
			</div>											
		</div>	
		<div class = "bottom-div" >
			<h3 style = "font-size:14px">miracle@创奇科技有限公司</h3>				
		</div>																													
	</body>


</html>