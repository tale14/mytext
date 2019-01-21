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
 * Servlet implementation class Servlet_Course
 */
@WebServlet("/Servlet_Course")
public class Servlet_Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    public Servlet_Course() {
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
		String name = request.getParameter("courseName");
		String time = request.getParameter("courseTime");
		String period = request.getParameter("coursePeriod");
		if(name.equals("")||time.equals("")||period.equals("")) {					
			request.getRequestDispatcher("course_fail.jsp").forward(request, response);
		}else {		
			try {
				con = DButil.GetConnection();
				String sql = "update course set courseName = '"+name+"',courseTime = '"+time +"' , coursePeriod = '"+period+"'";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
				request.getRequestDispatcher("course.jsp").forward(request, response);
			}		
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				DButil.close(con, pstmt);
			}
		}
	}

}
