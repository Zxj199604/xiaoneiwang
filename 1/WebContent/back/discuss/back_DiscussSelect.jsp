<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:directive.page import="com.zxj.form.DiscussForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此公告信息吗？")){
window.location.href="DiscussServlet?method=1&id="+id;
}
}
</script>
<title>后台公共设置</title>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="discussDao" class="com.zxj.dao.DiscussDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=discussDao.queryDiscuss();
	int pagesize=15;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}%>
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有公告信息查询！</p>");
}else{
		  out.print("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;公告查询</p>");%>
		<table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
		<tr>
              <td width="94" height="25"><div align="center">公告题目</div></td>
              <td width="155"><div align="center">公告内容</div></td>
              <td width="133"><div align="center">发布时间</div></td>
              <td width="81"><div align="center">操作</div></td>
            </tr>
            <%for(int i=0;i<list.size();i++){ 
         DiscussForm discussForm=(DiscussForm)list.get(i);        
         String content=discussForm.getDiscussContent();      
         if(content.length()>6){
         content=content.substring(0,6)+"...";
         }
         %>   
          <tr bgcolor="#FFFFFF">
              <td height="25"><div align="center"><%=discussForm.getDiscussTitle()%></div></td>
              <td><div align="center"><%=content%></div></td>
              <td title="如果想察看详细内容，单击相应的修改链接"><div align="center"><%=discussForm.getDiscussTime()%></div></td>
              <td><div align="center"><a href="back_DiscussUpdate.jsp?id=<%=discussForm.getId()%>" title="可以查看相应的公告内容">修改</a>&nbsp;&nbsp;<a href="javascript:deleteForm('<%=discussForm.getId()%>')">删除</a></div></td>
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