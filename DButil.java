package com.gxwuz.call.util;
import java.sql.*;
public class DButil {
	private static final String uri = "jdbc:mysql://localhost:3306/classmanage?useUnicode=true&characerEncoding = utf-8&serverTimezone=GMT";
	private static final String user = "root";
	private static final String password = "xiao**";
	
	public static Connection GetConnection() {		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection(uri,user,password);
		}		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

}