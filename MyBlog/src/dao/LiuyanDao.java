package dao;

//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;

import model.LiuyanBean;
import model.InsertBean;
@WebServlet("/liuyanbanDao")
public class LiuyanDao {
private DefaultDao ddobject;
	
	public LiuyanDao(){
		ddobject=new DefaultDao();
	}
	public ResultSet queryBlog(){
		
		String sql="select * from liuyanban";
		ResultSet rs=ddobject.getResult(sql);
		return rs;
	}
	public boolean insertBlog(InsertBean insertBean){
		boolean mark=false;
		if(insertBean!=null){
			Date date=new Date();
	       // SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");//12Ð¡Ê±ÖÆ  
			java.sql.Date newDate=new java.sql.Date(date.getTime());
	        
	        String sql="insert into liuyanban(title,content,author,date) values('"+insertBean.getTitle()+"','"+insertBean.getContent()+"','"+insertBean.getAuthor()+"','"+newDate+"')";
			
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
public ResultSet queryBlogById(int newId){
		
		String sql="select * from liuyanban where id="+newId;
		ResultSet rs=ddobject.getResult(sql);
		return rs;
	}
public boolean updateBlog(LiuyanBean liuyanBean){
	boolean mark=false;
	if(liuyanBean!=null){
				
		String sql="update liuyanban set title='"+liuyanBean.getTitle()+"',content='"+liuyanBean.getContent()+"',author='"+liuyanBean.getAuthor()+"',date='"+liuyanBean.getDate()+"' where id="+liuyanBean.getId();
		try{
			int i=ddobject.doDML(sql);
		if(i==1) mark=true; 
		}catch(Exception e){
			mark=false;
			e.printStackTrace();
		}
		}
		return mark;
	
	
}
public boolean deleteBlogById(int deleteId){
	boolean mark=false;
	String sql="delete from liuyanban where id="+deleteId;
	int num=ddobject.doDML(sql);
	if(num==1){
		mark=true;
	}
	return mark;
}
}
