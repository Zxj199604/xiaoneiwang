<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户回复设置</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此回复信息吗？")){
window.location.href="ArticleServlet?method=10&id="+id;
}
}
</script>
</head>
<jsp:useBean id="articleDao" class="com.zxj.dao.ArticleDao"  scope="session"></jsp:useBean>
<jsp:useBean id="restoreDao" class="com.zxj.dao.RestoreDao" scope="session"></jsp:useBean>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<% 
com.zxj.dao.ConsumerDao consumerDao=new com.zxj.dao.ConsumerDao();
com.zxj.form.ConsumerForm consumerForm1=(com.zxj.form.ConsumerForm)session.getAttribute("form");
%>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=restoreDao.queryRestore1(consumerForm1.getId().toString());
	int pagesize=5;      //指定每页显示的记录数
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有回复信息！</p>");
}else{
 out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;回复信息查询</p>");
%>
<table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
<tr>
				<td><div align="center">对应文章</div></td>
              <td width="81" height="25"><div align="center">回复主题</div></td>
              <td width="200">
	              <div align="center">回复内容</div>                
              </td>
              <td width="60"><div align="center">回复人</div></td>
              <td width="30"><div align="center">操作</div></td>
 </tr>
 <%
            for(int i=0;i<list.size();i++){
            RestoreForm restoreForm=(RestoreForm)list.get(i);
   %>
   <tr bgcolor="#FFFFFF">
   			  <td><div align="center"><%=articleDao.selectArticleName(restoreForm.getArticleId()) %></div></td>
              <td height="30"><div align="center"><%=restoreForm.getReTitle()%></div></td>
              <td><div align="center"><%=restoreForm.getReContent()%></div></td>
              <td><div align="center"><%=consumerDao.getConsumerForm(Integer.valueOf(restoreForm.getReAccount()))%></div></td>
              <td><div align="center"><a href="javascript:deleteForm('<%=restoreForm.getId()%>')">删除</a></div></td>
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