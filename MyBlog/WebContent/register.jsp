<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>新用户注册</title>
<link href="CSS/style.css" type="text/css" rel="stylesheet"/>
<link href="CSS/register.css" type="text/css" rel="stylesheet"/>
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
  <table>
				<%String mess=(String)request.getAttribute("messages"); 
					   if(mess==null||mess.equals("")){
						   mess="<li>欢迎注册！</li>";
					   }
					 %>
					 <form action="RegisterServlet" method="post">
				    <tr class="trheight">
						<td colspan="2" align="center"><%=mess %></td>
						
					</tr>
					<tr class="trheight">
					 
					   
						<td class="format"><span>*</span>用户名:</td>
						<td class="format2">&nbsp;<input type="text" id="user"
							style="font-size: 26px" name="username" /></td>
						
					</tr>

					<tr class="trheight">
						<td class="format"><span>*</span>请设置密码:</td>
						<td class="format2">&nbsp;<input type="password"
							style="font-size: 26px" id="pwd" name="password" /></td>
						
					</tr>

					<tr class="trheight">
						<td class="format"><span>*</span>请输入Email:</td>
						<td class="format2">&nbsp;<input type="text"
							style="font-size: 26px" id="pwd2" name="email" /></td>
						
					</tr>

					

					<tr class="trheight">
						
						<td colspan="2" align="right"><input type="submit" value=""
							style="background-image: url('images/register.png'); width: 270px; height: 35px" /></td>
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