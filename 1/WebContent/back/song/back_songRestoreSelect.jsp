<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.songRestoreForm"/>
<jsp:directive.page import="com.zxj.form.ConsumerForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>歌曲回复信息操作</title>
<script type="text/javascript">
function deleteForm(id,idd){
if(confirm("确定要删除此回复吗？")){
window.location.href="SongSerlvet?method=6&id="+id+"&idd="+idd;//传递idd这篇文章的id是为了删除此回复后继续返回到此文章相应的回复页面
}
}
</script>
</head>
<jsp:useBean id="songResoreDao" class="com.zxj.dao.songResoreDao" scope="session"></jsp:useBean>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="consumerDao" class="com.zxj.dao.ConsumerDao" scope="request"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=songResoreDao.queryRestore(Integer.valueOf(request.getParameter("id")));
	int pagesize=8;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
<body>
<jsp:include page="../back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0" background="/1/images/back_picture/back1.gif">
		<tr>
			<td width="227" valign="top"><jsp:include page="../back_Left.jsp"
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有回复信息！</p>");
}else{
 out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;回复信息查询</p>");
%>
		<table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
<tr>
              <td width="81" height="25"><div align="center">回复时间</div></td>
              <td>
	              <div align="center">回复内容</div>                
	              <div align="center"></div>
              </td>
              <td width="64"><div align="center">回复人</div></td>
              <td width="98"><div align="center">操作</div></td>
 </tr>
 <%
            for(int i=0;i<list.size();i++){
            	songRestoreForm songrestoreForm=(songRestoreForm)list.get(i);
   %>
   <tr bgcolor="#FFFFFF">
              <td height="30"><div align="center"><%=songrestoreForm.getReTime()%></div></td>
              <td><div align="center"><%=songrestoreForm.getReContent()%></div></td>
              <td><div align="center"><%=consumerDao.getConsumerForm(Integer.valueOf(songrestoreForm.getReAccount()))%></div></td>
              <td><div align="center"><a href="javascript:deleteForm('<%=songrestoreForm.getId()%>','<%=request.getParameter("id") %>')">删除</a></div></td>
   </tr>  
   <%} %>
</table>
<%=pagination.printCtrl1(Page) %>
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