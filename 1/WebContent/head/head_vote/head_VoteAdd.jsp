<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@page import="com.zxj.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台-用户投票</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
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
			 <%
List voteList=voteDao.queryVoteList();
%>
 <%
	if(voteList.size()<=0){
	out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;没有投票内容</p>");
	}else{
%>
 <br>
 <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;用户进行投票</p>");%>
 <br>
 <form name="form" method="post" action="/1/dealwith.jsp?sign=3">
   <table width="340" height="28" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td height="20" colspan="2">&nbsp;</td>
</tr>
   <%for(int voteNumber=0;voteNumber<voteList.size();voteNumber++){
          VoteForm voteForm=(VoteForm)voteList.get(voteNumber);
          %>
           <tr>
            <td width="45" height="20">&nbsp;</td>
            <td width="295" height="20"><input type="checkbox" name="voteID" value="<%=voteForm.getId()%>">&nbsp;&nbsp;<%=voteForm.getVoteName()%>
             &nbsp;</td>
          </tr>
          <%} %>
 </table>
 <br>
  <div align="center">
  <input type="image" class="inputinputinput" src="/1/images/vote.gif" width="51" height="20">
&nbsp;&nbsp;
<a href="#" onClick="javascript:form.reset()"><img src="/1/images/reset.gif"></a>
 </div>
 </form>
 <%} %>	
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