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
 * Servlet implementation class Called_Servlet
 */
@WebServlet("/Called_Servlet")
public class Called_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    public Called_Servlet() {
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
				con  = DButil.GetConnection();
				String sql = "select mark,last from student_call where id = ?";
				int m = 0;
				int n = 0;
				int studentNo =  (int)request.getSession().getAttribute("id");
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,studentNo);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					m = rs.getInt(1);	
					n = rs.getInt(2);
				}
				m = m+1;
				n = n+1;
				String t = request.getParameter("record");
				if(t.equals("1")) {									
					String SQL = "update student_call set mark = ? where id = ?";
					pstmt = con.prepareStatement(SQL);
					pstmt.setInt(1, m);
					pstmt.setInt(2, studentNo);
					pstmt.executeUpdate();
					request.getRequestDispatcher("call.jsp").forward(request, response);
				}else if(t.equals("2")) {
					String S = "update student_call set last = ? where id = ?";
					pstmt = con.prepareStatement(S);
					pstmt.setInt(1, m);
					pstmt.setInt(2, studentNo);
					pstmt.executeUpdate();
					request.getRequestDispatcher("call.jsp").forward(request, response);
				}else if(t.equals("3")) {
					request.getRequestDispatcher("call.jsp").forward(request, response);
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
