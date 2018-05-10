<!-- 对图片进行删除 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.VideoForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台视频的删除</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此视频信息吗？")){
window.location.href="VideoSerlvet?method=1&id="+id;
}
}
</script>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="videoDao" class="com.zxj.dao.VideoDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=videoDao.queryVideo();
	int pagesize=15;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}%>
<body onselectstart="return false">
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有视频信息查询！</p>");
}else{
		  out.print("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;视频查询"
				  +"&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;<a href='back_	PhotoSelect.jsp'>照片删除</a></p>");%>
		<table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
		<tr>
              <td width="94" height="25"><div align="center">视频名称</div></td>
              <td width="170"><div align="center">视频简介</div></td>
              <td width="140"><div align="center">发布时间</div></td>
              <td width="80"><div align="center">操作</div></td>
            </tr>
            <%for(int i=0;i<list.size();i++){ 
         VideoForm videoForm=(VideoForm)list.get(i);        
         String content=videoForm.getVideoIntroduction();    
         if(content.length()>15){
         content=content.substring(0,6)+"...";
         }
         %>   
          <tr bgcolor="#FFFFFF">
              <td height="25"><div align="center"><%=videoForm.getVideoTite()%></div></td>
              <td><div align="center"><%=content%></div></td>
              <td ><div align="center"><%=videoForm.getVideoTime()%></div></td>
              <td><div align="center"><a href="javascript:deleteForm('<%=videoForm.getId()%>')">删除</a></div></td>
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