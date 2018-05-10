<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <jsp:directive.page import="com.zxj.form.DiscussForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台-公告信息详细查询</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
</head>
<jsp:useBean id="discussDao" class="com.zxj.dao.DiscussDao" scope="page"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
	<%
DiscussForm discussForm=discussDao.queryDiscuss(Integer.valueOf(request.getParameter("id")));
%>
		<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
		<!--第二列-->
			<td height="868" valign="top" background="">
			 <%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;"+discussForm.getDiscussTitle()+"</p>");
%>
<table width="373" border="0" cellspacing="0" cellpadding="0">
<tr>
    <td height="21" align="right"><%=discussForm.getDiscussTime() %></td>
 </tr>
</table>
<table width="373" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
        <tr>
          <td valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<%=discussForm.getDiscussContent()%></td>
        </tr>
 </table>
<table width="373" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="48" align="right"><div align="center"><a href="head_disussList.jsp" ><img src="/1/images/back.gif"></a></div></td>
        </tr>
      </table>		
			</td>
				<!--第三列-->
			<td width="10"><img src="/1/images/head_picture/head_08.jpg" width="13"
				height="868">
			</td>
			<!--第四列，关于内容的基本分类、日历和最新公告部分-->
			<td width="184" valign="top">
				<jsp:include page="../head_right.jsp" flush="true" />
			</td>
			<!--第五列-->
			<td width="122"><img src="/1/images/head_picture/head_10.jpg" width="122"
				height="875">
			</td>
			</tr>
			</table>
</body>
</html>