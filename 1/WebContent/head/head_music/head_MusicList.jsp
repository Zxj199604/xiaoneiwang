
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zxj.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script src="/1/JS/move.js" language="javascript" type="text/javascript"></script>
<title>首页音乐</title>
</head>
<jsp:useBean id="songTypeDao" scope="session" class="com.zxj.dao.SongTypeDao"></jsp:useBean>
<jsp:useBean id="songDao" scope="session" class="com.zxj.dao.SongDao"></jsp:useBean>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="songrestoreDao" scope="session" class="com.zxj.dao.songResoreDao"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
	<div id="to_top"><img  src="/1/images/head_picture/sst.gif"  style ="width: 40px;height:30px;"></div><!-- 随鼠标移动的蝴蝶 -->
	<!-- 中间部分,为一张大的表格，分为5列其中第二列分为三个部分 -->
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
		<!--第二列-->
			<td height="868" valign="top" background="">
				<br>
				<table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
					  <tr>
					    <td align="center">
					     <%
					    List list=songTypeDao.querySongType();
					    for(int i=0;i<list.size();i++){
					    SongTypeForm songTypeForm=(SongTypeForm)list.get(i);
					    %>
					   <a href="head_MusicList.jsp?typeId=<%=songTypeForm.getId()%>"> [<%=songTypeForm.getTypeName()%>]</a>&nbsp;
					    <%}%>
					    </td>
					    </tr>
  				</table>
  				<br>
  	
			<form action="head_SearchMusicList.jsp" method="post" style=" margin:0px;" >	
				<table align="center">
				<tr>
				<td>
			搜索：<input type="text" name="key" id="key">
						  <select name="leixing">
								  <option value ="songName"> 歌曲名</option>
								  <option value ="specialName">专辑</option>
								  <option value="singer">歌手</option>
							</select>
  			<input name="Submit" type="submit" class="btn_bg" value="搜 索">	
  			</td>
  			</tr>
  				</table>
			</form>
			
			<%
  Integer typeId=null;
  if(request.getParameter("typeId")!=null){
  typeId=Integer.valueOf(request.getParameter("typeId"));
  }
  String str=(String)request.getParameter("Page");
  int Page=1;
  List songList=null;
  if(str==null){
	  songList=songDao.querySong(typeId);
  	int pagesize=6;      //指定每页显示的记录数
  	songList=pagination.getInitPage(songList,Page,pagesize);     //初始化分页信息
  }else{
  	Page=pagination.getPage(str);
  	songList=pagination.getAppointPage(Page);     //获取指定页的数据
  }
  %>
     <%
 	for (int songI = 0; songI < songList.size(); songI++) {
 		SongForm songForm = (SongForm) songList.get(songI);	
 %>
			<table width="380" border="0" align="center">
			<tr>
					<td width="377" height="22"><font color="BE9110"><b><%=songForm.getSongName()%></b></font></td>
				</tr>
				<tr>
						<td valign="top" ><span>歌手：<%=songForm.getSinger()%>&nbsp;&nbsp;
						专辑：<%=songForm.getSpecialName()%></span>&nbsp;&nbsp;
						<a target="_Blank" href="playtrysong.jsp?address=<%=songForm.getFileURL()%>&id=<%=songForm.getId()%>"><img alt="试听" src="/1/images/head_picture/tryListen.gif" style="width: 20px;height: 20px;" ></a>&nbsp;|&nbsp;
						<a  href="musicload.jsp?address=<%=songForm.getFileURL()%>&name=<%=songForm.getSongName()%>&format=<%=songForm.getFormat()%>&id=<%=songForm.getId()%>"><img alt="下载" src="/1/images/head_picture/down.png" style="width: 20px;height: 20px;"></a>		
						</td>
				</tr>	
						<tr>
						<td height="17" class="head-02"><a
							href="head_SongForm.jsp?id=<%=songForm.getId()%>"
							class="head-02">详请及评论&gt;&gt;</a></td>
					</tr>
					<tr>
						<td height="17" align="left"><%=songForm.getUpTime()%>&nbsp;|&nbsp;试听（<%=songForm.getHits()%>）&nbsp;|&nbsp;下载（<%=songForm.getDownload()%>）&nbsp;|&nbsp;
						评论（<%=songrestoreDao.queryRestore(songForm.getId()).size() %>）
						</td>
					</tr>
				</table>
				<div align="right">
					<hr>
				</div> 	
<%
 	}
 %>
  <%if(request.getParameter("typeId")==null){ %>
 <%=pagination.printCtrl1(Page) %>
 <%} else {%>
 <%=pagination.printCtrl3(Page,request.getParameter("typeId")) %>
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