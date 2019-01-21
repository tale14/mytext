package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxwuz.call.util.DButil;

import java.sql.*;
/**
 * Servlet implementation class Servlet_register
 */
@WebServlet("/Servlet_register")
public class Servlet_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
    public Servlet_register() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		try {
			con = DButil.GetConnection();
			String name = request.getParameter("username");
			String firstPassword = request.getParameter("passwordone");
			String secondPassword = request.getParameter("passwordtwo");
			String sql = "insert into login (username, password) values(?, ?)";
			if (name.equals("")||firstPassword.equals("")) {		
				request.getRequestDispatcher("register_fail.jsp").forward(request, response);
			}			
			else{
				if(!firstPassword.equals(secondPassword)) {
					request.getRequestDispatcher("register_fail.jsp").forward(request, response);
				}else {				
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, firstPassword);
					pstmt.executeUpdate();
					request.getRequestDispatcher("register_succeed.jsp").forward(request, response);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DButil.close(con, pstmt);
		}
	}

}
