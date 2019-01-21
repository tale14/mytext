package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.gxwuz.call.bean.*;
import com.gxwuz.call.util.*;

/**
 * Servlet implementation class Servlet_Calling
 */
@WebServlet("/Servlet_Calling")
public class Servlet_Calling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
    public Servlet_Calling() {
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
		int id = 0;
		try {
			con = DButil.GetConnection();						
			String sql = "select * from student_call order by rand() limit 1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			Stu s = new Stu();
			if(rs != null) {							
				while(rs.next()) {
					s.setName(rs.getString(1));
					s.setClassNo(rs.getString(2));		
					id = rs.getInt(5);
				}				
				request.setAttribute("s", s);
				request.getSession().setAttribute("id", id);
				request.getRequestDispatcher("callResult.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(con != null) {
					con.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}
