package com.gxwuz.call.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gxwuz.call.bean.Stu;
import com.gxwuz.call.util.DButil;

public class Prepared_course {	
	public static List<Stu> GetStu() {
		List<Stu> list = new ArrayList<Stu>();
		Connection con = DButil.GetConnection();	
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from course";
		try {
			stmt = con.createStatement();			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {		
				String courseName = rs.getString(1);
				String courseTime = rs.getString(2);
				String coursePeriod = rs.getString(3);
				Stu c = new Stu(courseName, courseTime, coursePeriod);
				list.add(c);
			}				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if( con != null) {
					con.close();
				}							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		return list;
	}
}
	
	



