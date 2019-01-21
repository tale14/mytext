package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxwuz.call.util.*;
import com.gxwuz.call.bean.*;
import java.sql.*;
/**
 * Servlet implementation class Servlet_Class
 */
@WebServlet("/Servlet_Class")
public class Servlet_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
    public Servlet_Class() {
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
		try {
			con = DButil.GetConnection();
			String sql = "select * from student_call";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			Stu s = new Stu();
			while(rs.next()) {
				s.setName(rs.getString(1));
				s.setClassNo(rs.getString(2));			
			}
			request.setAttribute("s", s);
			request.getRequestDispatcher("classmanage.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con == null) {
					con.close();
				}
				if(stmt == null) {
					stmt.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
