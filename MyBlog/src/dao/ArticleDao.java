package dao;

//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;

import model.ArticleBean;
import model.InsertBean;
@WebServlet("/ArticleDao")
public class ArticleDao {
private DefaultDao ddobject;
	
	public ArticleDao(){
		ddobject=new DefaultDao();
	}
	public ResultSet queryBlog(){
		
		String sql="select * from article";
		ResultSet rs=ddobject.getResult(sql);
		return rs;
	}
	public boolean insertBlog(InsertBean insertBean){
		boolean mark=false;
		if(insertBean!=null){
			Date date=new Date();
	       // SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");//12Ð¡Ê±ÖÆ  
			java.sql.Date newDate=new java.sql.Date(date.getTime());
	        
	        String sql="insert into article(title,content,author,date) values('"+insertBean.getTitle()+"','"+insertBean.getContent()+"','"+insertBean.getAuthor()+"','"+newDate+"')";
			
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
		
		String sql="select * from article where id="+newId;
		ResultSet rs=ddobject.getResult(sql);
		return rs;
	}
public boolean updateBlog(ArticleBean articleBean){
	boolean mark=false;
	if(articleBean!=null){
				
		String sql="update article set title='"+articleBean.getTitle()+"',content='"+articleBean.getContent()+"',author='"+articleBean.getAuthor()+"',date='"+articleBean.getDate()+"' where id="+articleBean.getId();
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
	String sql="delete from article where id="+deleteId;
	int num=ddobject.doDML(sql);
	if(num==1){
		mark=true;
	}
	return mark;
}
}
