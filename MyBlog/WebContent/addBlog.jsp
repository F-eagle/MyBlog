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
		<%String mess=(String)request.getAttribute("messages"); 
					   if(mess==null||mess.equals("")){
						   mess="";
					   }
					 %>
					 
			<table border="0" align="center">
			<caption>新增博文</caption>
				<form action="InsertServlet" method="post">
				<tr class="trheight">
						<td colspan="2" align="center"><%=mess %></td>
						
					</tr>
					<tr class="trheight">
						<td class="format"><span>*</span>标题:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="title" /></td>
					</tr>
					<tr class="trheight">
						<td class="format"><span>*</span>内容:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="content" /></td>
					</tr>

					<tr class="trheight">
						<td class="format"><span>*</span>作者:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" name="author" /></td>

					</tr>
					<tr class="trheight">

						<td colspan="2" align="center"><input type="submit" value="增加" /></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="footer.html" />
	</div>
</body>
</html>