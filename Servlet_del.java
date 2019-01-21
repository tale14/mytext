package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.gxwuz.call.util.*;

/**
 * Servlet implementation class Servlet_del
 */
@WebServlet("/Servlet_del")
public class Servlet_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    public Servlet_del() {
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
		String studentName = request.getParameter("studentName");
		String className = request.getParameter("className");
//		System.out.println(studentName+"+++++++++"+className);
		try {
			con = DButil.GetConnection();
			String sql = "select * from student_call where name = ? and classNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentName);
			pstmt.setString(2, className);
			rs = pstmt.executeQuery();			
			if(rs.next() == false) {		
				request.getRequestDispatcher("Del_class.jsp").forward(request, response);
			}else {
				String SQL = "delete from student_call where name = '"+studentName+"' and classNo = '"+className+"' ";
				pstmt = con.prepareStatement(SQL);
				pstmt.executeUpdate();
				request.getRequestDispatcher("classmanage.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DButil.close(con, pstmt);
		}
	}

}
