<%@page import="com.zxj.form.VideoForm"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台-视屏查询</title>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="videoDao" class="com.zxj.dao.VideoDao" scope="page"></jsp:useBean>
<%
 String str=(String)request.getParameter("Page");
 int Page=1;
 List list=null;
 if(str==null){
 	list=videoDao.queryVideo();
 	int pagesize=22;      //指定每页显示的记录数
 	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
 }else{
 	Page=pagination.getPage(str);
 	list=pagination.getAppointPage(Page);     //获取指定页的数据
 }
 %>
<body>
<!--网页头部分-->
<jsp:include page="../head_top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
<td height="868" valign="top"  >
<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;查询所有视频信息</p>");
%>
<table width="387" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
 <tr>
    <td width="112" height="30"><div align="center">名称</div></td>
    <td width="257"><div align="center">操作</div></td>
 </tr>
 <%
 for(int i=0;i<list.size();i++){
	  VideoForm videoForm=(VideoForm)list.get(i);
	      String title=videoForm.getVideoTite();
	            if(title.length()>6){
	            title=title.substring(0,6)+"......";
	             }
 %>
  <tr bgcolor="#FFFFFF">
    <td height="30"><div align="center"><%=title%></div></td>
    <td>
    <div align="center"><a href="head_videoForm.jsp?id=<%=videoForm.getId()%>">详细查询</a>&nbsp;&nbsp;
    <a target="_Blank"  href="playvideoOne.jsp?address=<%=videoForm.getVideoAddress()%>">在线播放</a>&nbsp;&nbsp;
    <a href="videoLoad.jsp?address=<%=videoForm.getVideoAddress()%>&name=<%=videoForm.getVideoTite()%>">下载视频</a></div>
    </td>
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