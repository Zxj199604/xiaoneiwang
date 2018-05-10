<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script src="/1/JS/validate.js" language="javascript" type="text/javascript"></script>
<title>前台文章的详细查询及回复内容</title>
</head>
<jsp:useBean id="articleDao" class="com.zxj.dao.ArticleDao" scope="request"></jsp:useBean>
<jsp:useBean id="restoreDao" class="com.zxj.dao.RestoreDao" scope="session"></jsp:useBean>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="consumerDao" class="com.zxj.dao.ConsumerDao" scope="request"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
	<!-- 中间部分,为一张大的表格，分为5列其中第二列分为三个部分 -->
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
				<%
String id=request.getParameter("id");//得到这篇文章的id
ArticleForm articleForm=articleDao.queryArticleForm(Integer.valueOf(id));
%>
		<!--第二列-->
			<td height="868" valign="top" background="">
 <%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;"+articleForm.getTitle()+"</p>");
%>
<!-- 显示文章的内容 -->
<table width="373" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
	<tr>
          <td valign="top" bgcolor="#FFFFFF">
          <textarea style="width:99%; height:200px; ">&nbsp;&nbsp;&nbsp;&nbsp;<%=articleForm.getContent() %></textarea>
          </td>
	</tr>
</table>			
<!--时间,阅读量及回复数量的显示 -->
<table width="373"  border="0">
        <tr>
          <td align="right"><%=articleForm.getPhTime()%>&nbsp;&nbsp;|&nbsp;&nbsp;阅读（<%=articleForm.getNumber()%>）&nbsp;&nbsp;|&nbsp;&nbsp;回复（<%=restoreDao.queryRestore(articleForm.getId()).size()%>）</td>
        </tr>
</table>		
<table width="373" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="36" align="right"><div align="center"><a href="head_ArticleList.jsp" "><img src="/1/images/back.gif"></a></div></td>
        </tr>
</table>  
<!-- 显示已经回复的信息,对回复的内容进行分页显示-->
<%
ConsumerForm consumerForm=(ConsumerForm)session.getAttribute("form");
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=restoreDao.queryRestore(articleForm.getId());
	int pagesize=3;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
<%if(pagination.getRecordSize()>0){
	for(int i=0;i<list.size();i++){
		RestoreForm restoreForm=(RestoreForm)list.get(i);
%>
<table width="345"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
<tr>
          <td width="47" bgcolor="#FFFFFF">题目：</td>
          <td width="285" bgcolor="#FFFFFF"><%=restoreForm.getReTitle() %></td>
</tr>
<tr>
          <td bgcolor="#FFFFFF">内容：</td>
          <td bgcolor="#FFFFFF"><%=restoreForm.getReContent() %></td>
 </tr>
 <tr>
 		<%  ConsumerForm consumerForm1= consumerDao.getConsumerForm1(Integer.valueOf(restoreForm.getReAccount()));%>	
          <td colspan="2" bgcolor="#FFFFFF"><div align="right">回复人:<a href="#" title="QQ:<%=consumerForm1.getQQNumber()%>&nbsp;|&nbsp;E-mail:<%=consumerForm1.getEMail()%>"><%=consumerForm1.getName()%></a></div></td>
</tr>
</table>
<%}
	out.print(pagination.printCtrl2(Page,id));
	} %>	
	
			<!-- 如果用户要进行回复进填写相关的 信息-->
			<form name="form2" method="post" action="ArticleServlet?method=7"  onSubmit="return addRestore()">
 <table width="261"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
  <tr>
          <td width="88" bgcolor="#FFFFFF" >回复主题： </td>
          <td width="183" bgcolor="#FFFFFF"><input name="reTitle" type="text" class="inputinput" size="26"></td>
  </tr>
   <tr>
          <td height="139" bgcolor="#FFFFFF">回复内容：</td>
          <td bgcolor="#FFFFFF"><textarea name="reContent" rows="10" class="inputinput"></textarea></td>
 </tr>
 <tr>
          <td bgcolor="#FFFFFF">回&nbsp;复&nbsp;人：</td>
          <td bgcolor="#FFFFFF">
          <input name="articleId" type="hidden" size="26" value="<%=articleForm.getId()%>">
          <input name="accountId" type="hidden" size="26" value="<%=consumerForm.getId()%>">
          <%=consumerForm.getName()%>
          </td>
  </tr>
 </table>
  <table width="284"  border="0" align="center">
         <tr>
          	 <td>
             	<div align="center">
 <input type="image" class="inputinputinput" src="/1/images/save.gif">
&nbsp;&nbsp;
<a href="#" onClick="javascript:form2.reset()"><img src="/1/images/reset.gif"></a></div>
			</td>		
         </tr>
</table>
 </form>
 <br>
 <center><span class="tip" id="ts">内容不能为空！</span></center>
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