package servlet;

import java.sql.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gxwuz.call.util.*;

/**
 * Servlet implementation class servlet_login
 */

@WebServlet("/servlet_login")
public class servlet_login extends HttpServlet {     
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    public servlet_login() {
        super();
      
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doPost(request, response);
	   }  
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		try {
			con = DButil.GetConnection();	
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String sql = "select * from login where username = '"+name+"' and password = '"+password+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next() == true){	
				request.getSession().setAttribute("loginName", name);		
				request.getSession().setAttribute("loginPassword", password);			
				request.getRequestDispatcher( "loginsucceed.jsp").forward(request,response);				
			}else{			
				request.getRequestDispatcher( "login_fail.jsp").forward(request,response);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {	
			
			DButil.close(con, pstmt);	
		}							
}
}