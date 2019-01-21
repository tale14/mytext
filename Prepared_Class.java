package com.gxwuz.call.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.gxwuz.call.bean.*;
import com.gxwuz.call.util.DButil;

public class Prepared_Class {
	public static List<Stu> GetStu(){
		List<Stu> list = new ArrayList<Stu>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student_call";
		try {
			con = DButil.GetConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				String className = rs.getString(2);
				int mark = rs.getInt(3);
				int last = rs.getInt(4);
				Stu all = new Stu(name, className, mark, last);
				list.add(all);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return list;
	}
}
