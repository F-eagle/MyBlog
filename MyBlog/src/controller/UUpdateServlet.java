package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LiuyanDao;
import model.LiuyanBean;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UUpdateServlet")
public class UUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		String updateId=request.getParameter("updateId");
		if(updateId==null)updateId="-1";
		int id=-1;
		try {
			id = Integer.parseInt(updateId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			id=-1;
			e.printStackTrace();
		}
		LiuyanDao liuyanDao=new LiuyanDao();
		ResultSet rs=liuyanDao.queryBlogById(id);
		LiuyanBean liuyanBean=new LiuyanBean();
		try {
			if(rs!=null&&rs.next())
			{
				liuyanBean.setId(rs.getInt("id"));
				liuyanBean.setTitle(rs.getString("title"));
				liuyanBean.setContent(rs.getString("content"));
				liuyanBean.setAuthor(rs.getString("author"));
				liuyanBean.setDate(rs.getDate("date"));
				request.setAttribute("update", liuyanBean);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("UpdateLiuyan.jsp");
		rd.forward(request,response);
		
		/*HttpSession session=request.getSession(true);
		session.setAttribute("update", articleBean);
		response.sendRedirect("UpdateBlog.jsp");*/
		
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
