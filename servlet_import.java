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
 * Servlet implementation class servlet_import
 */
@WebServlet("/servlet_import")
public class servlet_import extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con = null;
	PreparedStatement pstmt = null;

	
    public servlet_import() {
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
			String name = request.getParameter("name");
			String classname = request.getParameter("classname");
			if (name.equals("")||classname.equals("")) {
				request.getRequestDispatcher("import_fail.jsp").forward(request, response);
			}else {							
				String sql = "insert into student_call (name, classNo) values(?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, classname);
				pstmt.executeUpdate();
				request.getRequestDispatcher("import_succeed.jsp").forward(request, response);
			}						
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {	
			DButil.close(con, pstmt);
		}
	}

}
