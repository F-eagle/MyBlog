package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.UserDao;
import model.ArticleBean;
import model.InsertBean;
import model.RegisterBean;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
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
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String author=request.getParameter("author");
		if(title==null){title="";}
		if(content==null){content="";}
		if(author==null){author="";}
	    RequestDispatcher rd=null;
	    
		ArticleDao articleDao=new ArticleDao();
		InsertBean insertBean=new InsertBean();
		
		insertBean.setTitle(title);
		insertBean.setContent(content);
		insertBean.setAuthor(author);
		
		boolean mark=articleDao.insertBlog(insertBean);
		if(!mark){//ÐÂÔö²©ÎÄÊ§°ÜÊ§°Ü
			request.setAttribute("messages","<li>²©ÎÄÌí¼ÓÊ§°Ü£¡</li>");
			rd=request.getRequestDispatcher("addBlog.jsp");
			rd.forward(request,response);
		}
		else{
		   
			rd=request.getRequestDispatcher("QueryBlogServlet");
			rd.forward(request,response);
		}			
	
	

		
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
