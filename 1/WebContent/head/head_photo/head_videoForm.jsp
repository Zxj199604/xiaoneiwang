<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <jsp:directive.page import="com.zxj.form.VideoForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>视频详细查询</title>
</head>
<jsp:useBean id="videoDao" class="com.zxj.dao.VideoDao" scope="page"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
	<%
VideoForm videoForm=videoDao.queryVideo(Integer.valueOf(request.getParameter("id")));
%>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
				<td height="868" valign="top" width="407">
				 <%
out.println("<br><p align=center>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;"+videoForm.getVideoTite()+"</p>");
%>
 <table width="373" border="0" cellspacing="0" cellpadding="0">
 <tr>
    <td height="21" align="right"><%=videoForm.getVideoTime() %></td>
 </tr>
 </table>
 <table width="373" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
        <tr>
          <td valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;简介:<%=videoForm.getVideoIntroduction()%></td>
        </tr>
 </table>
 <table width="373" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="48" align="right"><div align="center"><a href="head_videoList.jsp" ><img src="/1/images/back.gif"></a></div></td>
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
		<!-- 网页结尾 -->
	<jsp:include page="../head_down.jsp" flush="true" />
</body>
</html>