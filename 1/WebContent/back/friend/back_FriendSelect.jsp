<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.FriendForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>后台朋友信息的设置</title>
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此朋友信息吗？")){
window.location.href="FriendServlet?method=1&id="+id;
}
}
</script>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="friendDao" class="com.zxj.dao.FriendDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=friendDao.queryFriend();
	int pagesize=15;      //指定每页显示的记录数
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有朋友信息！</p>");
}else{



 out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;朋友信息查询</p>");
%>
		  
            <table width="524" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
            <tr align="center" bgcolor="#ACD6FF">
              <td width="91" height="20">昵称</td>
              <td width="74">QQ号码</td>
              <td>描述</td>
              <td width="132">操作</td>
            </tr>
   <%for(int i=0;i<list.size();i++) {
   FriendForm friendForm=(FriendForm)list.get(i);
   %>
            <tr align="center" bgcolor="#FFFFFF">
              <td height="25"><%=friendForm.getName()%></td>
              <td><%=friendForm.getQQNumber()%></td>
              <td><%=friendForm.getDescription()%></td>
              <td><a href="FriendServlet?method=2&id=<%=friendForm.getId()%>">修改</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:deleteForm('<%=friendForm.getId()%>')">删除</a></td>
            </tr>
   <%} %>
          </table>
	<!-- 显示分页导航栏 -->
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