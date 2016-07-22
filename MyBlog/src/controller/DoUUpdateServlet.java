package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LiuyanDao;
import model.LiuyanBean;
import model.InsertBean;

/**
 * Servlet implementation class DoUpdateServlet
 */
@WebServlet("/DoUUpdateServlet")
public class DoUUpdateServlet extends HttpServlet {
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
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String author=request.getParameter("author");
		String strDate=request.getParameter("date");
		if(updateId==null){updateId="";}
		if(title==null){title="";}
		if(content==null){content="";}
		if(author==null){author="";}
		if(strDate==null){strDate="";}
		int id=-1;
		try {
			id=Integer.parseInt(updateId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			id=-1;
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd "); 
		Date date;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date=new Date();
			e.printStackTrace();
		}
		
	    RequestDispatcher rd=null;
	    
		LiuyanDao liuyanDao=new LiuyanDao();
		LiuyanBean liuyanBean=new LiuyanBean();
		liuyanBean.setId(id);
		liuyanBean.setTitle(title);
		liuyanBean.setContent(content);
		liuyanBean.setAuthor(author);
		liuyanBean.setDate(new java.sql.Date(date.getTime()));
		
		
		boolean mark=liuyanDao.updateBlog(liuyanBean);
		if(!mark){//–ﬁ∏ƒ≤©Œƒ ß∞‹
			HttpSession session=request.getSession(true);
			session.setAttribute("messages","<li>¡Ù—‘–ﬁ∏ƒ ß∞‹£°</li>");
			response.sendRedirect("UpdateBlog.jsp");
		}
		else{
		    //request.setAttribute("messages","<li>¡Ù—‘ÃÌº”≥…π¶£°</li>");
			rd=request.getRequestDispatcher("liuyanban");
			rd.forward(request,response);
		}
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
