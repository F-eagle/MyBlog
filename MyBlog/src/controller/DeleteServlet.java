package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.LiuyanDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		String deleteId=request.getParameter("deleteId");
		if(deleteId==null)deleteId="-1";
		int id=-1;
		try {
			id = Integer.parseInt(deleteId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			id=-1;
			e.printStackTrace();
		}
		ArticleDao articleDao=new ArticleDao();
		boolean mark=articleDao.deleteBlogById(id);
		if(mark){
			response.sendRedirect("QueryBlogServlet");
		}else{
			request.setAttribute("deleteResult","É¾³ýµÚ"+deleteId+"Ìõ¼ÇÂ¼Ê§°Ü£¡" );
			response.sendRedirect("QueryBlogServlet");
			
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	
	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		String ddeleteId=request.getParameter("ddeleteId");
		if(ddeleteId==null)ddeleteId="-1";
		int id=-1;
		try {
			id = Integer.parseInt(ddeleteId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			id=-1;
			e.printStackTrace();
		}
		LiuyanDao liuyanDao=new LiuyanDao();
		boolean mark=liuyanDao.deleteBlogById(id);
		if(mark){
			response.sendRedirect("liuyanban");
		}else{
			request.setAttribute("deleteResult","É¾³ýµÚ"+ddeleteId+"Ìõ¼ÇÂ¼Ê§°Ü£¡" );
			response.sendRedirect("liuyanban");
			
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
