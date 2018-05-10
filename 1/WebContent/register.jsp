<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head> 
    <title>校内用户注册</title>
    <link rel="stylesheet" type="text/css" href="CSS/common.css"/>
	<link rel="stylesheet" type="text/css" href="CSS/register.css"/>
	<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
  </head>
 <body>
   <jsp:include page="head.jsp"/>
   <div class="reg_main_frame">
   		<!-- 加入校内后，可以选择... -->
   		<div class="play_item1">
   				<img src="images/jiaru.jpg" />
		</div>
		 <!-- 注册用的表格 -->
		 <br>
  		 	<span class="font6">简单一步，快速注册</span><hr>
  		 	<br/>
  		 	<div class="play_item2">
       		<form name="form" method="post"
						action="/1/ConsumerServlet?method=1&sign=1"
						onSubmit="return accountADD()">			
						<table class="play_item3">
							<tr>
								<td class="tab_td1">用户名称：</td>
								<td class="tab_td1"><input name="account" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="1">请输入用户名</span></td>
							</tr>
							<tr>
								<td class="tab_td1">密&nbsp;&nbsp;码：</td>
								<td><input name="password" type="password"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="2">请输入密码</span></td>
							</tr>
							<tr>
								<td class="tab_td1">重复密码：</td>
								<td><input name="repeatPassword" type="password"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="3">两次密码输入不一致</span></td>
							</tr>
							<tr>
								<td class="tab_td1">姓&nbsp;&nbsp;名：</td>
								<td><input name="name" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="4">请输入姓名</span></td>
							</tr>
							<tr>
								<td class="tab_td1">性&nbsp;&nbsp;别：</td>
								<td><input name="sex" type="radio" class="inputinputinput"
									value="男" checked> 男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									name="sex" type="radio" class="inputinputinput" value="女">
									女</td>
								<td><span class="spanVal" >请选择性别</span></td>
							</tr>
							<tr>
								<td class="tab_td1">QQ&nbsp;号码：</td>
								<td><input name="QQnumber" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="5">请正确输入QQ号</span></td>
							</tr>
							<tr>
								<td class="tab_td1">手机号码：</td>
								<td><input name="phonenumber" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="6">请正确输入手机号</span></td>
							</tr>
							<tr>
								<td class="tab_td1">兴&nbsp;&nbsp;趣：</td>
								<td><input name="interest" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="7">请输入兴趣爱好</span></td>
							</tr>
							<tr>
								<td class="tab_td1">E&nbsp;-mail：</td>
								<td><input name="eMail" type="text"
									class="inputinput" size="25"></td>
								<td><span class="spanVal" id="8">请正确输入邮箱</span></td>
							</tr>	
							
							<tr>
							<td height="20"></td>
							</tr>
							<tr>
								<td height="30" colspan="2" align="center">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="image" class="inputinputinput" src="images/save.gif">
									&nbsp;&nbsp; <a href="#" onClick="javascript:form.reset()"><img
										src="images/reset.gif"></a> &nbsp;&nbsp; <a href="#"
									onClick="window.location.href='/1/index.jsp'"><img
										src="images/back.gif"></a></td>
							</tr>
						</table>				
			</form>
			</div>
   </div>
 </body>
</html>