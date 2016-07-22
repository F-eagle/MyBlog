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
				<h3 align="center">留言信息列表</h3>
				<div style="text-align: right;">
					<a href="addliuyan.jsp">新增留言</a>
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
					ArrayList arrayList = (ArrayList) request.getAttribute("liuyanban");
					if (arrayList == null) {
						out.print("查询留言列表失败！");
					} else {
						LiuyanBean liuyanBean = new LiuyanBean();
						for (int i = 0; i < arrayList.size(); i++) {
							liuyanBean = (LiuyanBean) arrayList.get(i);
				%>
				
				<tr>
					<td><%=liuyanBean.getId()%></td>
					<td><%=liuyanBean.getTitle()%></td>
					<td><%=liuyanBean.getContent()%></td>
					<td><%=liuyanBean.getAuthor()%></td>
					<td><%=liuyanBean.getDate()%></td>
					<td><a href="UUpdateServlet?updateId=<%=liuyanBean.getId()%>">修改</a>
					</td>
					<td><a href="DDeleteServlet?deleteId=<%=liuyanBean.getId()%>">删除</a></td>
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