<%@ page contentType="text/html; charset=UTF-8"
	import="java.sql.*,java.util.*,model.*"%>
<html>
<head>
<title>新用户注册</title>
<link href="CSS/style.css" type="text/css" rel="stylesheet" />
<link href="CSS/register.css" type="text/css" rel="stylesheet" />
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
			<div>
				<h3 align="center">博文信息列表</h3>
				<div style="text-align: right;">
					<a href="addBlog.jsp">新增博文</a>
				</div>
			</div>
			<%
				String deleteResult=(String)request.getAttribute("deleteResult"); 
				if(deleteResult==null)
					deleteResult="";
				%>
			<div><%=deleteResult%></div>

			<table align="center" border="1" width="550px">
				<tr>
					<th>编号</th>
					<th>标题</th>
					<th>内容</th>
					<th>作者</th>
					<th>日期</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
				<%
					ArrayList arrayList = (ArrayList) request.getAttribute("article");
					if (arrayList == null) {
						out.print("查询博文列表失败！");
					} else {
						ArticleBean articleBean = new ArticleBean();
						for (int i = 0; i < arrayList.size(); i++) {
							articleBean = (ArticleBean) arrayList.get(i);
				%>
				
				<tr>
					<td><%=articleBean.getId()%></td>
					<td><%=articleBean.getTitle()%></td>
					<td><%=articleBean.getContent()%></td>
					<td><%=articleBean.getAuthor()%></td>
					<td><%=articleBean.getDate()%></td>
					<td><a href="UpdateServlet?updateId=<%=articleBean.getId()%>">修改</a>
					</td>
					<td><a href="DeleteServlet?deleteId=<%=articleBean.getId()%>">删除</a></td>
				</tr>
				<%
				} } %>
			</table>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="footer.html" />
	</div>
</body>
</html>