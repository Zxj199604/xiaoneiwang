<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:directive.page import="com.zxj.form.*"/>
  <jsp:directive.page import="com.zxj.dao.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>前台-查询投票结果</title>
</head>
<jsp:useBean id="voteDao" class="com.zxj.dao.VoteDao" scope="page"></jsp:useBean>
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
			<%out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;投票查询结果</p>");%> 
  <table width="369" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="ACD6FF">
  <tr>
    <td height="30"><div align="center">编号</div></td>
    <td><div align="center">投票名称</div></td>
    <td><div align="center">票数</div></td>
  </tr>
  <%
  List voteList=voteDao.queryVoteList();
  for(int votei=0;votei<voteList.size();votei++){
  VoteForm voteForm=(VoteForm)voteList.get(votei);
   %>
  <tr bgcolor="#FFFFFF">
    <td height="30"><div align="center"><%=voteForm.getId()%></div></td>
    <td><div align="center"><%=voteForm.getVoteName()%></div></td>
    <td><div align="center"><%=voteForm.getVoteNumber()%></div></td>
  </tr>
 
  <%} %>
 </table>
 <%out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;我所投票的编号</p>");%> 
<%
ConsumerForm consumerForm=null;
consumerForm=(ConsumerForm)session.getAttribute("form");
VotedDao votedDao=new VotedDao();
VotedForm votedForm=votedDao.getVotedForm(consumerForm.getId().toString());
String votedid=votedForm.getVoteid();
String[] votedids=votedid.split("#");
%>
<table width="369" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
<%for(int i=0;i<votedids.length;i++){ %>
<tr>
	<td height="30"><div align="center"><%=votedids[i]%></div></td>
</tr>
<%} %>

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