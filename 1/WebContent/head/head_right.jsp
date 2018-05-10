<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:useBean id="discussDao" scope="page" class="com.zxj.dao.DiscussDao"></jsp:useBean>
<%@page import="com.zxj.form.*" %>
<%@page import="com.zxj.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前端右侧界面</title>
</head>
<body onselectstart="return false">
	<!-- 右侧第一个标题首页 -->
	<table width="184" height="35" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_09.jpg">
		<!-- 第一行 -->
		<tr>
			<!-- 第一行，第一列 -->
			<td valign="top">
				<table width="146" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="23" height="28">&nbsp;</td>
						<td width="123" valign="bottom"><a href="/1/head/head_main.jsp"
							class="head-01"><strong>首页</strong></a> <span class="style5 ">[HOME]
						</span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!-- 右侧第二个标题说明 -->
	<table width="184" height="30" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_15.jpg">
		<tr>
			<td valign="top"><table width="146" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="23" height="24">&nbsp;</td>
						<td width="123" valign="bottom"><a href="/1/head/head_explain/head_explain.jsp"
							class="head-01"><strong>说明</strong></a> <span class="style5 ">[EXPLAIN]
						</span></td>
					</tr>
				</table></td>
		</tr>
	</table>

	<!-- 右侧第三个标题文章 -->
	<table width="184" height="29" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_11.jpg">
		<tr>
			<td valign="top"><table width="146" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="23" height="24">&nbsp;</td>
						
						<td width="123" valign="bottom"><a
							href="/1/head/head_article/head_ArticleList.jsp" class="head-01"><strong>文章</strong></a>
							<span class="style5 ">[ARTICLE] </span></td>
					</tr>
				</table></td>
		</tr>
	</table>

	<!-- 右侧第三个标题公告 -->
	<table width="184" height="29" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_15.jpg">
		<tr>
			<td valign="top"><table width="146" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="23" height="24">&nbsp;</td>
						<td width="123" valign="bottom"><a href="/1/head/head_disussList/head_disussList.jsp"
							class="head-01"><strong>公告</strong></a> <span
							class="style5 style1">[DISCUSS] </span></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<!-- 右侧第四个标题相册 -->
	<table width="184" height="29" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_11.jpg">
		<tr>
			<td valign="top"><table width="146" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="23" height="24">&nbsp;</td>
						<td width="123" valign="bottom"><a
							href="/1/head/head_photo/head_photoSelect.jsp" class="head-01"><strong>相册</strong></a>
							<span class="style5 style1">[PHOTO] </span></td>
					</tr>
				</table></td>
		</tr>
	</table>
	
	
	<!-- 右侧第五个标题音乐 -->
	<table width="184" height="28" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_15.jpg">
		<tr>
			<td valign="top"><table width="146" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="23" height="24">&nbsp;</td>
						<td width="123" valign="bottom"><a href="/1/head/head_music/head_MusicList.jsp"
							class="head-01"><strong>音乐</strong></a> <span
							class="style5 style1">[MUSIC] </span></td>
					</tr>
				</table></td>
		</tr>
	</table>
	
	<!-- 网络日历的标题 -->
	<table width="184" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><img src="/1/images/head_picture/head_16.jpg" width="184" height="16"></td>
		</tr>
		<tr>
			<td><img src="/1/images/head_picture/head_17.jpg" width="184" height="17"></td>
		</tr>
	</table>


<!--网络日历的内容 -->
	<%!String days[];%>
	<%
		days = new String[42];
		for (int i = 0; i < 42; i++) {
			days[i] = "";
		}
	%>
	<%
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, month);
		thisMonth.set(Calendar.YEAR, year);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);//从这个月的第一天开始算
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		//out.print(firstIndex);
		//out.print(maxIndex);
		for (int i = 0; i < maxIndex; i++) {
			days[firstIndex + i] = String.valueOf(i + 1);
		}
	%>
	<table width="184" height="179" border="0" cellpadding="0"
		cellspacing="0" background="/1/images/head_picture/head_18.jpg" bgcolor="#FAFAFA">
		<tr>
			<td>
				<table width="180" height="81" border="1" align="center"
					cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
					bgcolor="CBB180">

					<tr bgcolor="FFFCF1">
						<td height="15" colspan="7" align="center"><%=year%>年<%=month+1%>月</td>
					</tr>
					<tr bgcolor="ECF5FF">
						<td width="25" height="16" align="center"><strong><font color="red">日</font></strong>
						</td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><strong><font
								color="#000000">一</font></strong></td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><strong><font
								color="#000000">二</font></strong></td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><strong><font
								color="#000000">三</font></strong></td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><font
								color="#000000">四</font></td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><font
								color="#000000">五</font></td>
						<td width="25" height="16" bgcolor="ECF5FF" align="center"><strong><font
							color="red">六</font></strong></td>
					</tr>
<!-- 日期的循环表示 -->
					<%
						for (int j = 0; j < 6; j++) {
					%>
					<tr bgcolor="FFFCF1">
						<%
							for (int i = j * 7; i < (j + 1) * 7; i++) {
						%>
						<td width="25" height="15" align="center" valign="middle">
							<%
								if ((i - firstIndex + 1) == today) {
							%> <b> <font color="red"><%=days[i]%></font></b> <%
 	} else {
 %> <%=days[i]%> <%
 	}
 %>
						</td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</td>
		</tr>
	</table>

<!-- 最新公告模块 -->
<table width="184" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="/1/images/head_picture/head_19.jpg" width="184" height="27"></td>
        </tr>
</table>


<%
//公告信息
List discussList=discussDao.queryDiscuss();
%>
<table width="184" height="158" border="0" cellpadding="0" cellspacing="0" bgcolor="#FAFAFA">
        <tr>
          <td valign="top">
		  <br>
				
		<table width="93%"  border="0" align="center" cellpadding="0" cellspacing="0">
		<%
           int discussNumber=discussList.size();
           if(discussNumber>6){
           discussNumber=5;
           }
            for(int i=0;i<discussNumber;i++){
            DiscussForm discussForm=(DiscussForm)discussList.get(i);
            String title=discussForm.getDiscussTitle();
            if(title.length()>9){
            title=title.substring(0,9)+"......";
             }
             %>
            <tr>
              <td width="9%" height="22"><img src="/1/images/head_picture/front_17.jpg" width="7" height="7"></td>
              <td width="91%"><a href="/1/head/head_disussList/head_disussForm.jsp?id=<%=discussForm.getId()%>" title="查看详细内容"><%=title%></a></td>
            </tr>
            <%}%>
		</table>
		
		
		<table width="174" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td><div align="right"><a href="/1/head/head_disussList/head_disussList.jsp">更多...</a></div></td>
            </tr>
          </table>	
             
		  
		  </td>
		  </tr>
	</table>
	
	
<!--投票模块  -->
<%
ConsumerForm consumerForm=null;
consumerForm=(ConsumerForm)session.getAttribute("form");
VotedDao votedDao=new VotedDao();
VotedForm votedForm=votedDao.getVotedForm(consumerForm.getId().toString());
//判断投票结果
String src="/1/images/head_picture/vote.png";
String herf="/1/head/head_vote/head_VoteAdd.jsp";
if(votedForm!=null){
src="/1/images/head_picture/result.png";
herf="/1/head/head_vote/head_VoteQuery.jsp";
}
%>
<table width="184" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="/1/images/head_picture/head_21.jpg" width="184" height="33"></td>
        </tr>
 </table>
 
 <table width="184" height="106" border="0" cellpadding="0" cellspacing="0" background="/1/images/head_picture/head_22.jpg">
<tr>
<td>

<table width="135" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td width="10">&nbsp;</td>
 <td width="125">
 <%--用来显示投票图片的代码 --%>
 <a href="<%=herf%>"><img alt="无法显示" src="<%=src %>" style="height:35px; width: 100px;"></a>
 </td>
</tr>
</table>

</td>
</tr>
</table>

<!-- 友情链接 -->
  <table width="184" border="0" cellspacing="0" cellpadding="0">
  <tr>
          <td><img src="/1/images/head_picture/head_23.jpg" width="184" height="34"></td>
  	</tr>
 </table>
<table width="184" height="123" border="0" cellpadding="0" cellspacing="0" background="/1/images/head_picture/head_24.jpg">
<tr>
<td>
<table width="68%" height="24"  border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td  width="16%" height="22"><img src="/1/images/head_picture/front_17.jpg" width="10" height="9"></td>
<td  width="56%"><a href="http://www.baidu.com" title="请单击"  target="_Blank">百度一下</a></td>
<td  width="28%">&nbsp;</td>
</tr>
<tr>
<td  width="16%" height="22"><img src="/1/images/head_picture/front_17.jpg" width="10" height="9"></td>
<td  width="56%"><a href="http://longzhu.com/channels/cf?from=left" title="请单击"  target="_Blank">龙珠直播</a></td>
<td  width="28%">&nbsp;</td>
</tr>
<tr>
<td  width="16%" height="22"><img src="/1/images/head_picture/front_17.jpg" width="10" height="9"></td>
<td  width="56%"><a href="http://www.baidu.com" title="请单击"  target="_Blank">斗鱼直播</a></td>
<td  width="28%">&nbsp;</td>
</tr>
<tr>
<td  width="16%" height="22"><img src="/1/images/head_picture/front_17.jpg" width="10" height="9"></td>
<td  width="56%"><a href="http://www.baidu.com" title="请单击"  target="_Blank">熊猫直播</a></td>
<td  width="28%">&nbsp;</td>
</tr>
</table>
</td>
</tr>
 </table>
 
</body>
</html>
