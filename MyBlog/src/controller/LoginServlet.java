package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
import model.LoginBean;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		login(request,response);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	


public boolean validateLogin(HttpServletRequest request, HttpServletResponse response){
boolean mark=true;
	String messages="";
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null||username.equals("")){
		mark=false;
		messages+="<li>请输入 <b>用户名！</b></li>";
	}
	if(password==null||password.equals("")){
		mark=false;
		messages+="<li>请输入 <b>密&nbsp;&nbsp;码！</b></li>";
	}
	request.setAttribute("messages",messages);	
return mark;
}
public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	boolean flag=validateLogin(request,response);
    RequestDispatcher rd=null;
    if(flag){
	UserDao masterDao=new UserDao();
	LoginBean loginer=new LoginBean();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null){username="";}
	if(password==null){password="";}
	loginer.setUsername(username);
	loginer.setPassword(password);
	boolean mark=masterDao.login(loginer);
	if(!mark){//登陆失败
		request.setAttribute("messages","<li>输入的用户名或密码错误！</li>");
		rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request,response);
	}
	else{//登录成功
		HttpSession session=request.getSession();
		session.setAttribute("loginer",loginer);
		response.sendRedirect("index.jsp");
	}			
}
else{
	rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request,response);
}
}



}
