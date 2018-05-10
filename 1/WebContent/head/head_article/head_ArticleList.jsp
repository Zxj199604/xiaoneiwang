<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.zxj.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前端文章显示</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
</head>
<jsp:useBean id="articleTypeDao" scope="session" class="com.zxj.dao.ArticleTypeDao"></jsp:useBean>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="articleDao" scope="session" class="com.zxj.dao.ArticleDao"></jsp:useBean>
<jsp:useBean id="restoreDao" scope="session" class="com.zxj.dao.RestoreDao"></jsp:useBean>
<body>
<!-- 网页头部 -->
	<jsp:include page="../head_top.jsp" flush="true" />
		<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
		<!--第二列-->
			<td height="868" valign="top" background="">
			<br>
  <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
     <%
    List list=articleTypeDao.queryArticleType();
    for(int i=0;i<list.size();i++){
    ArticleTypeForm articleTypeForm=(ArticleTypeForm)list.get(i);
    %>
   <a href="head_ArticleList.jsp?typeId=<%=articleTypeForm.getId()%>"> [<%=articleTypeForm.getTypeName()%>]</a>&nbsp;
    <%}%>
    </td>
    </tr>
  </table>
  
  <!-- 文章内容 -->
  <%
  Integer typeId=null;
  if(request.getParameter("typeId")!=null){
  typeId=Integer.valueOf(request.getParameter("typeId"));
  }
  String str=(String)request.getParameter("Page");
  int Page=1;
  List articleList=null;
  if(str==null){
  	articleList=articleDao.queryArticle(typeId);
  	int pagesize=5;      //指定每页显示的记录数
  	articleList=pagination.getInitPage(articleList,Page,pagesize);     //初始化分页信息
  }else{
  	Page=pagination.getPage(str);
  	articleList=pagination.getAppointPage(Page);     //获取指定页的数据
  }
  %>
   <%
 	for (int articleI = 0; articleI < articleList.size(); articleI++) {
 		ArticleForm articleForm = (ArticleForm) articleList.get(articleI);
 		String articleContent = articleForm.getContent();
 		if (articleContent.length() > 100) {
 			articleContent = articleContent.substring(0, 100) + "...";
 		}
 		
 %>
				<table width="380" border="0" align="center">
					<tr>
						<td width="377" height="22"><font color="BE9110"><b><%=articleForm.getTitle()%></b></font></td>
					</tr>
					<tr>
						<td valign="top"><span><%=articleContent%></span></td>
					</tr>
					<tr>
						<td height="17" class="head-02"><a
							href="head_ArticleForm.jsp?id=<%=articleForm.getId()%>"
							class="head-02">阅读全文&gt;&gt;</a></td>
					</tr>
					<tr>
						<td height="17" align="right"><%=articleForm.getPhTime()%>&nbsp;|&nbsp;阅读（<%=articleForm.getNumber()%>）&nbsp;|&nbsp;回复（<%=restoreDao.queryRestore(articleForm.getId()).size()%>）</td>
					</tr>
				</table>
				<div align="right">
					<hr>
				</div> <%
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