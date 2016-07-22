<%@ page language="java" contentType="text/html; charset=UTF-8" import="model.LoginBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>博客首页</title>
<link href="CSS/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="header">
  <jsp:include page="header.html" />
</div>
<div id="father">
  <div id="left">
     <jsp:include page="left.html" />
  </div>
  <div id="right">
    <table id="right-table">
      <tr height="40px">
        <td colspan="2">
         <%
         LoginBean loginer=(LoginBean)session.getAttribute("loginer");
         if(loginer==null){
        	 request.setAttribute("messages","您还未登录,请先登录！");
         %>
        	<jsp:forward page="login.jsp" />
        <%
         }
       
         out.print("你好,"+loginer.getUsername()+".");
         %>
         <a href="QueryBlogServlet">查看博文列表</a>
         <a href="liuyanban">查看留言板</a>
        </td>
      </tr>
      <tr height="40px">
        <td>【我的文章】</td>
        <td align="right"><a href="">更多..</a></td>
      </tr>
      <tr height="50px">
        <td colspan="2">▲前言【摘自】</td>
      </tr>
      <tr>
        <td colspan="2">随着计算机技术的飞速发展，各种应用办公软件也在社会各领域得到广泛应用，软件的设计和开发也成为日常工作中... </td>
      </tr>
      <tr>
        <td  colspan="2"><a href="">阅读全文</a></td>
      </tr>
      <tr>
        <td align="right" colspan="2"> 发表时间：2014年09月20日12:47 |
          评论：1 |
          阅读：2 次 </td>
      </tr>
      <tr height="20px">
        <td background="images/line.jpg" colspan="2"></td>
      </tr>
    </table>
    <table>
      <tr height="50px">
        <td> ▲保护环境，爱护地球！[原创] </td>
      </tr>
      <tr >
        <td> 人类好比瞬间流星，<br />
          自然才是永远夜空，<br />
        </td>
      </tr>
      <tr>
        <td><a href="">阅读全文</a> </td>
      </tr>
      <tr>
        <td align="right"> 发表时间：2014年09月20日12:47 |
          评论：1 |
          阅读：2 次 </td>
      </tr>
      <tr height="20">
        <td background="images/line.jpg" colspan="2"></td>
      </tr>
    </table>
    <table>
      <tr height="50px">
        <td> ▲心中最向往的一顿大餐！【原创】 </td>
      </tr>
      <tr>
        <td> 天上飞的、地上跑的、水里游的！<br />
          鱼和熊掌、天鹅肉，再加一瓶二锅头！<br />
          天上飞的、地上跑的... </td>
      </tr>
      <tr>
        <td><a href="">阅读全文</a> </td>
      </tr>
      <tr>
        <td align="right"> 发表时间：2014年09月20日12:47 |
          评论：1 |
          阅读：2 次 </td>
      </tr>
      <tr height="20">
        <td background="images/line.jpg"></td>
      </tr>
    </table>
  </div>
</div>
<div id="footer">
  <jsp:include page="footer.html" />					
</div>
</body>
</html>