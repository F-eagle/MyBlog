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
			<table border="0" align="center">
				<caption>修改博文</caption>
				<%
					LiuyanBean liuyanBean = (LiuyanBean) request.getAttribute("update");
					String mess = "";
					if (liuyanBean == null) {
						mess = "请选择要修改的博文！";
				%>
				<tr class="trheight">
					<td class="format" colspan="2"><%=mess%></td>

				</tr>
				<%
					} else {
				%>


				<form action="DoUUpdateServlet?updateId=<%=liuyanBean.getId()%>"
					method="post">

					<tr class="trheight">
						<td class="format"><span>*</span>标题:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="title"
							value="<%=liuyanBean.getTitle()%>" /></td>
					</tr>
					<tr class="trheight">
						<td class="format"><span>*</span>内容:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="content"
							value="<%=liuyanBean.getContent()%>" /></td>
					</tr>

					<tr class="trheight">
						<td class="format"><span>*</span>作者:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="author"
							value="<%=liuyanBean.getAuthor()%>" /></td>

					</tr>
					<tr class="trheight">
						<td class="format"><span>*</span>发表日期:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="author"
							value="<%=liuyanBean.getDate()%>" /></td>

					</tr>
					<tr class="trheight">

						<td colspan="2" align="center"><input type="submit"
							value="修改博文" /></td>
					</tr>
				</form>
				<%
					}
				%>
			</table>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="footer.html" />
	</div>
</body>
</html>