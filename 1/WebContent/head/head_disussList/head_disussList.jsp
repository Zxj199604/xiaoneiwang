<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="com.zxj.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台-公告信息查询</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="discussDao" class="com.zxj.dao.DiscussDao" scope="page"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
		<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
		<!--第二列-->
			<td height="868" valign="top" background="">
			<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;查询所有公告信息</p>");
%>
<table width="387" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
 <tr>
    <td width="112" height="30"><div align="center">题目</div></td>
    <td width="161"><div align="center">发布时间</div></td>
    <td width="96"><div align="center">操作</div></td>
  </tr>
 <%
 String str=(String)request.getParameter("Page");
 int Page=1;
 List list=null;
 if(str==null){
 	list=discussDao.queryDiscuss();
 	int pagesize=22;      //指定每页显示的记录数
 	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
 }else{
 	Page=pagination.getPage(str);
 	list=pagination.getAppointPage(Page);     //获取指定页的数据
 }
 %>
 <%
 for(int i=0;i<list.size();i++){
	  DiscussForm discussForm=(DiscussForm)list.get(i);
	      String title=discussForm.getDiscussTitle();
	            if(title.length()>6){
	            title=title.substring(0,6)+"......";
	             }
 %>
  <tr bgcolor="#FFFFFF">
    <td height="30"><div align="center"><%=title%></div></td>
    <td><div align="center"><%=discussForm.getDiscussTime()%></div></td>
    <td><div align="center"><a href="head_disussForm.jsp?id=<%=discussForm.getId()%>">详细查询</a></div></td>
  </tr>
  <%} %>
</table>

<%=pagination.printCtrl1(Page) %>
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