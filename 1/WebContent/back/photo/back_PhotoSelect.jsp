<!-- 对图片进行删除 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.PhotoForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<jsp:useBean id="pagination" class="com.zxj.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="photoDao" class="com.zxj.dao.PhotoDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=photoDao.queryPhoto();
	int pagesize=4;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
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
							<%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;相片查询" 
          		+"&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;<a href='back_VideoSelect.jsp'>视频删除</a></p>");
          		
          		%>
					<table width="455" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#ACD6FF">
          		  <%for(int i=0;i<list.size();i++){
  PhotoForm photoForm=(PhotoForm)list.get(i);
if(i % 2 ==0 ){
%>
<tr bgcolor="#FFFFFF">
<td width="230">
<div align="center">
<table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="150"><div align="center"><a href="#" onClick="window.open('photoSelectOne.jsp?image=<%=photoForm.getPhotoAddress()%>','','width=600,height=700');"><img src="/1/<%=photoForm.getPhotoAddress()%>" width="160" height="140"></a></div></td>
                    </tr>
                    <tr>
                      <td height="20"><div align="center"><%=photoForm.getPhotoDescription()%></div></td>
                    </tr>
                    <tr>
                      <td height="20"><div align="center"><a href="PhotoSerlvet?method=1&id=<%=photoForm.getId()%>">删除</a></div></td>
                    </tr>
</table>
</div>
</td>
<%} else{%>
<td width="212"><div align="center">
                <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="150"><div align="center"><a href="#" onClick="window.open('photoSelectOne.jsp?image=<%=photoForm.getPhotoAddress()%>','','width=600,height=700');"><img src="/1/<%=photoForm.getPhotoAddress()%>" width="160" height="140"></a></div></td>
                  </tr>
                  <tr>
                    <td height="20"><div align="center"><%=photoForm.getPhotoDescription()%></div></td>
                  </tr>
                  <tr>
                    <td height="20"><div align="center"><a href="PhotoSerlvet?method=1&id=<%=photoForm.getId()%>">删除</a></div></td>
                  </tr>
                </table>
                </div>              
</td>
</tr>
<%} }%>
<%if(list.size()%2 ==1){%>
  <td bgcolor="#FFFFFF"><div align="center">
    <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="150"><div align="center"></div></td>
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