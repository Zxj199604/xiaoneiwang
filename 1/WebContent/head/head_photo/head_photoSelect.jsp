<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="com.zxj.form.PhotoForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="photoDao" class="com.zxj.dao.PhotoDao" scope="session"></jsp:useBean>
<head>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台-相片查询</title>
</head>
<body>
<!--网页头部分-->
	<jsp:include page="../head_top.jsp" flush="true" />

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=photoDao.queryPhoto();
	int pagesize=6;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
<td height="868" valign="top" >
<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;查询所有的相片</p>");
%>
<table width="341" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#ACD6FF">
<%for(int i=0;i<list.size();i++){
	 PhotoForm photoForm=(PhotoForm)list.get(i);
	 if(i % 2 ==0 ){
%>
<!--使照片显示为2个一排，若为奇数张照片则空行补上 -->		
<tr bgcolor="#FFFFFF">
 <td width="166"><div align="center">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="150"><div align="center"><a href="#" onClick="window.open('photoSelectOne.jsp?image=<%=photoForm.getPhotoAddress()%>','','width=600,height=700');"><img src="/1/<%=photoForm.getPhotoAddress()%>" width="160" height="140"></a></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhotoDescription()%></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhtoTime()%></div></td>
              </tr>
            </table>
          </div>
          </td>
	<%}else{%>
	 <td width="162"><div align="center">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="150"><div align="center"><a href="#" onClick="window.open('photoSelectOne.jsp?image=<%=photoForm.getPhotoAddress()%>','','width=600,height=700');"><img src="/1/<%=photoForm.getPhotoAddress()%>" width="160" height="140"></a></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhotoDescription()%></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhtoTime()%></div></td>
              </tr>
            </table>
        </div></td>
      </tr>
	<%}
	 } %>
<%if(list.size()%2 ==1){%>
  <td bgcolor="#FFFFFF">
  <div align="center">
        <table width="141" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="141" height="150"><div align="center"></div></td>
          </tr>
          <tr>
            <td height="20"><div align="center"></div></td>
          </tr>
          <tr>
            <td height="20"><div align="center"></div></td>
          </tr>
        </table>
    </div>
    </td>
  
  <%}%>
 </tr>
</table>
<%=pagination.printCtrl1(Page) %>
<%out.println("<br><br><p align=right><a href='head_videoList.jsp'>查看视频--></a></p>");%>
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