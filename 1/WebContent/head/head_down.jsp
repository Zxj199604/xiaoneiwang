<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.zxj.form.FriendForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页底部</title>
</head>
<jsp:useBean id="friendDao" scope="page" class="com.zxj.dao.FriendDao"></jsp:useBean>
<body>
<%
	List friendList = friendDao.queryFriend();
	int friendNumber = friendList.size();
	if (friendNumber > 10) {
		friendNumber = 10;
	}
%>
<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="/1/images/head_picture/head_25.jpg" width="800" height="20"></td>
		</tr>
</table>
<table width="800" height="25" border="0" align="center"
		cellpadding="0" cellspacing="0" background="/1/images/head_picture/head_26.jpg">
		<tr >
			<td width="44">&nbsp;</td>
			<td width="614">
				<div align="center">
					<%
						for (int friendi = 0; friendi < friendNumber; friendi++) {
							FriendForm friendForm = (FriendForm) friendList.get(friendi);
					%>
					<a href="#"
						title="QQ:<%=friendForm.getQQNumber()%>&nbsp;|&nbsp;<%=friendForm.getDescription()%>">
						<%=friendForm.getName()%></a>&nbsp;
					<%
						}
					%>
				</div>
			</td>
			<td width="142">&nbsp;</td>
		</tr>
	</table>
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="/1/images/head_picture/head_27.jpg" width="800" height="63"></td>
		</tr>
	</table>
	
	
</body>
</html>