package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.gxwuz.call.util.*;
import com.gxwuz.call.bean.*;

/**
 * Servlet implementation class ServletScore
 */
@WebServlet("/ServletScore")
public class ServletScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
    public ServletScore() {
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
			String studentName = request.getParameter("name");
			String className = request.getParameter("classNo");		
			String sql = "select * from student_call where name = ? and classNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentName);
			pstmt.setString(2, className);
			rs = pstmt.executeQuery();
			Stu s = new Stu();	
			if(className == null) {
				request.getRequestDispatcher("inquiry_fail.jsp").forward(request, response);
			}else {
				if(studentName == null) {
					request.getRequestDispatcher("inquiry_fail.jsp").forward(request, response);
				}else {
					while(rs.next()) {
						s.setName(rs.getString(1));
						s.setClassNo(rs.getString(2));
						s.setMark(rs.getInt(3));
						s.setLast(rs.getInt(4));			
					}
					if(s.getName() != null && s.getClassNo() != null) {
						request.setAttribute("s", s);				
						request.getRequestDispatcher("score_inquiry.jsp").forward(request, response);
					}else if(s.getName() == null){
						request.getRequestDispatcher("inquiry_fail.jsp").forward(request, response);
					}
					else if(s.getClassNo() == null){
						request.getRequestDispatcher("inquiry_fail.jsp").forward(request, response);
					}
				}
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {	
			DButil.close(con, pstmt);	
		}	
	}

}
