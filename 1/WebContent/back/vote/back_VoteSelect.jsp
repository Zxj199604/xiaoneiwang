<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <jsp:directive.page import="com.zxj.form.VoteForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>后台投票内容的删除</title>
<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此投票信息吗?用户将进行重新投票！")){
window.location.href="VoteServlet?method=1&id="+id;
}
}
</script>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="voteDao" class="com.zxj.dao.VoteDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=voteDao.queryVoteList();
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
	out.println("<p align=center><img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;没有投票内容！</p>");
}else{
		  
		  
		  out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;投票内容设置</p>");%>
		  
			
			<table border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr bgcolor="#ACD6FF">
                <td width="50" height="20"><div align="center">编号</div></td>
                <td width="100"><div align="center">投票内容</div></td>
                <td width="100"><div align="center">票数</div></td>
                <td width="80"><div align="center">操作</div></td>
              </tr>
              <%
              for(int i=0;i<list.size();i++){
              VoteForm voteForm=(VoteForm)list.get(i);
              %>
              <tr bgcolor="#FFFFFF">
                <td height="20"><div align="center"><%=voteForm.getId()%></div></td>
                <td><div align="center"><%=voteForm.getVoteName()%></div></td>
                <td><div align="center"><%=voteForm.getVoteNumber()%></div></td>
                <td><div align="center"><a href="javascript:deleteForm('<%=voteForm.getId()%>')">删除</a></div></td>
              </tr>
              <%}%>
            </table>
			<%=pagination.printCtrl1(Page) %>
			<%}%>
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