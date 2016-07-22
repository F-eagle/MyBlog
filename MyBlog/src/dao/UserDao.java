package dao;
import model.RegisterBean;
import java.sql.*;

import javax.servlet.annotation.WebServlet;

import model.LoginBean;
@WebServlet("/UserDao")
public class UserDao {
	private DefaultDao ddobject;
	
	public UserDao(){
		ddobject=new DefaultDao();
	}
	
	public boolean register(RegisterBean register){
		boolean mark=false;
		if(register!=null){
		String sql="insert into user(username,password,email) values('"+register.getUsername()+"','"+register.getPassword()+"','"+register.getEmail()+"')";
		
		try{
			int i=ddobject.doDML(sql);
		if(i>0) mark=true; 
		}catch(Exception e){
			mark=false;
			e.printStackTrace();
		}
		}
		return mark;
	}
	
	public boolean login(LoginBean login){
		boolean mark=false;
		if(login!=null){
		String sql="select * from user where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'";
		ResultSet rs=ddobject.getResult(sql);
		
			try {
				if(rs!=null&&rs.next())
					  mark=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return mark;
		
	}
	
	}

