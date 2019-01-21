package servlet;

import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxwuz.call.util.DButil;

/**
 * Servlet implementation class servlet_personal
 */
@WebServlet("/servlet_personal")
public class servlet_personal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
    public servlet_personal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		con = DButil.GetConnection();
		String passwordFirst = request.getParameter("newpasswordOne");
		String passwordSecond = request.getParameter("newpasswordTwo");
		String oldPassword = request.getParameter("passwordFirst");
		String password = (String) request.getSession().getAttribute("loginPassword");
		String name = (String) request.getSession().getAttribute("loginName");
		int d = 0;
		if (!password.equals(oldPassword)) {
			request.getRequestDispatcher("personalfail.jsp").forward(request, response);		
		}else {
			if(!passwordFirst.equals(passwordSecond)) {
				request.getRequestDispatcher("personalfail.jsp").forward(request, response);
			}else {						
				try {
					String s = "select id from login where username = ? and password = ? ";
					pstmt = con.prepareStatement(s);
					pstmt.setString(1, name);
					pstmt.setString(2, password);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						d = rs.getInt(1);
					}					
					String sql = "update login set password = '"+passwordFirst+"' where id = '"+d+"'";
					pstmt = con.prepareStatement(sql);				
					pstmt.executeUpdate(sql);				
					request.getRequestDispatcher("personalfinish.jsp").forward(request, response);
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					DButil.close(con, pstmt);
				}	
			}
		}
	}

}
