package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
import model.RegisterBean;

public class RegisterServlet extends HttpServlet {

	
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
		register(request,response);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	public boolean validate(HttpServletRequest request, HttpServletResponse response){
		boolean mark=true;
			String messages="";
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			
		
			if(username==null||username.equals("")){
				mark=false;
				messages+="<li>������ <b>�û�����</b></li>";
			}
			if(password==null||password.equals("")){
				mark=false;
				messages+="<li>������ <b>��&nbsp;&nbsp;�룡</b></li>";
			}
			
			
			if(email==null||email.equals("")){
				mark=false;
				messages+="<li>��ѡ�� <b>�Ա�</b></li>";
			}
			
			request.setAttribute("messages",messages);	
		return mark;
	}
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		boolean flag=validate(request,response);
	    RequestDispatcher rd=null;
	    if(flag){//��Ϊ��
		UserDao masterDao=new UserDao();
		RegisterBean register=new RegisterBean();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		if(username==null){username="";}
		if(password==null){password="";}
		if(email==null){email="";}
		
		
		register.setUsername(username);
		register.setPassword(password);
		register.setEmail(email);
		
		boolean mark=masterDao.register(register);
		if(!mark){//ע��ʧ��
			request.setAttribute("messages","<li>ע��ʧ�ܣ�</li>");
			rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request,response);
		}
		else{
			request.setAttribute("messages","<li>ע��ɹ������¼��</li>");
			rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		}			
	}
	else{//Ϊ��
		rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request,response);
	}
	}


}
