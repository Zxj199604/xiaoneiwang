<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="com.zxj.form.SongForm"/>
<jsp:directive.page import="com.zxj.form.SongTypeForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户歌曲的删除</title>
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此歌曲及其相关评论吗？")){
window.location.href="SongSerlvet?method=5&id="+id;
}
}
</script>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="songDao" class="com.zxj.dao.SongDao" scope="session"></jsp:useBean>
<jsp:useBean id="songTypeDao" class="com.zxj.dao.SongTypeDao" scope="session"></jsp:useBean>
<jsp:useBean id="songResoreDao" class="com.zxj.dao.songResoreDao" scope="session"></jsp:useBean>
<%
com.zxj.dao.ConsumerDao consumerDao=new com.zxj.dao.ConsumerDao();
com.zxj.form.ConsumerForm consumerForm1=(com.zxj.form.ConsumerForm)session.getAttribute("form");
%>
<%
Integer typeId=null;
if(request.getParameter("typeId")!=null){
typeId=Integer.valueOf(request.getParameter("typeId"));
}
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=songDao.querySong1(typeId,consumerForm1.getId());
	int pagesize=3;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
<body>
<jsp:include page="../back_Top1.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0" background="/1/images/back_picture/back1.gif">
		<tr>
			<td width="227" valign="top"><jsp:include page="../back_Left1.jsp"
					flush="true" /></td>
				<!-- 第二列 -->	
					<td width="573" valign="top"   background="/1/images/back_picture/back1.gif">
						<table width="227" border="0" cellpadding="0" cellspacing="0">
									<tr>
									        <td >
									        	<img src="/1/images/back_picture/back_noword_03.jpg" width="573" height="25">
									        </td>
									</tr>
						</table>
						<table width="573" border="0" cellpadding="0" cellspacing="0" background="/1/images/back_picture/back_noword_05.jpg">
							<tr>
							<td valign="top" align="center">
							<%
if(pagination.getRecordSize()<=0){
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有歌曲查询，请后退！</p>");
	}else{%>
		<% out.print("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;歌曲查询</p>");
	%>
		<table width="500" border="0">
	 <tr>
        <td>
        <div align="center">
          <%
    List songTypeList=songTypeDao.querySongType();
    for(int i=0;i<songTypeList.size();i++){
    	SongTypeForm songTypeForm=(SongTypeForm)songTypeList.get(i);
    %>
    <a href="back_songSelect1.jsp?typeId=<%=songTypeForm.getId()%>"> [<%=songTypeForm.getTypeName()%>]</a>&nbsp;
<%} %>
    </div>
	</td>
	</tr>
	</table>					
	<br>   					
	  <table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
    <tr>
              <td width="81" height="20"><div align="center">歌曲名</div></td>
              <td width="73"><div align="center">歌曲类别</div></td>
              <td width="142"><div align="center">发布时间</div></td>
              <td width="64"><div align="center">回复数量</div></td>
              <td width="98"><div align="center">操作</div></td>
     </tr>
     <%for(int i=0;i<list.size();i++){ 
    	 SongForm songForm=(SongForm)list.get(i);
         %>   
         <tr bgcolor="#FFFFFF">
              <td height="30"><div align="center">
			  <%=songForm.getSongName()%>
			  </div></td>
              <td><div align="center"><%=songTypeDao.querySongTypeName(songForm.getSongType())%></div></td>
              <td><div align="center"><%=songForm.getUpTime()%></div></td>
              <td><div align="center"><%=songResoreDao.queryRestore(songForm.getId()).size()%></div></td>
              <td><div align="center"><a href="javascript:deleteForm('<%=songForm.getId()%>')">删除</a></div></td>
            </tr>
         <%} %>
    </table>						
						<%if(request.getParameter("typeId")==null){ %>
 <%=pagination.printCtrl1(Page) %>
 <%} else {%>
 <%=pagination.printCtrl3(Page,request.getParameter("typeId")) %>
 <%}%>
 <%} %>
								
							</td>
							</tr>
						</table>
						<table width="227" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td><img src="/1/images/back_picture/back_noword_18.jpg" width="573" height="21"></td>
					        </tr>
						</table>					
					</td>			
		</tr>
</table>
<jsp:include page="../back_Down.jsp" flush="true" />
</body>
</html>