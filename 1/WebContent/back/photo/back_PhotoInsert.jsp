<!-- 后台相册的添加 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
<script type="text/javascript">
function addPhoto() {
	if(document.form.photoAddress.value==""){
		alert("请选着上传图片");
		return false;
	}
	return true;
}
</script>
</head>
<% 
com.zxj.dao.ConsumerDao consumerDao=new com.zxj.dao.ConsumerDao();
com.zxj.form.ConsumerForm consumerForm1=(com.zxj.form.ConsumerForm)session.getAttribute("form");
%>
<jsp:useBean id="countTime" scope="page" class="com.zxj.tool.CountTime"></jsp:useBean>
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
							 <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;照片上传</p>");
		  						%>
								 <form action="PhotoSerlvet?method=0" method="post"  name="form" onSubmit="return addPhoto()" enctype="multipart/form-data">
									 <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
								              <tr>
								                <td width="72" height="30"><div align="center">上传地址：</div></td>
								                <td width="255" bgcolor="#FFFFFF">
								                    <div align="left">
								                      <input name="photoAddress" type="file" class="inputinput"  size="30">
								                  </div></td></tr>
								              <tr>
								                <td height="30"><div align="center">相片描述：</div></td>
								                <td bgcolor="#FFFFFF">
								                    <div align="left">
								                      <input name="photoDescription" type="text" class="inputinput"  size="30">
								                  </div></td></tr>
								              <tr>
								                <td height="30"><div align="center">上传时间：</div></td>
								                <td bgcolor="#FFFFFF">
										                  <div align="left">
										                     <input name="phtoTime" type="text" class="inputinput" onclick="alert('此文本框已设为只读，用户不能修改')" value="<%=countTime.currentlyTime() %>" size="30" readonly="readonly">
										                  	<input name="accountId"   value="<%=consumerForm1.getId() %>  "    type="hidden"  >
										                  </div>
								                  </td>  
								                </tr>
								            </table>
											<table width="494" border="0" cellspacing="0" cellpadding="0">
										              <tr>
										                <td width="494">
														<br>
														<div align="center" class="style1">注意：图片的格式只能为：“JPG”,“jpg”,“gif”,“bmp”,“BMP”格式</div></td>
										              </tr>
				            				</table>
											 <br>
											  <input type="image" class="inputinputinput" src="/1/images/save.gif">
												&nbsp;&nbsp;
 												<a href="#" onClick="javascript:form.reset()"><img src="/1/images/reset.gif"></a>
	
								</form>
								<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %>
			  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;<a href='back_VideoInsert.jsp'>添加视频</a></p>");
		  %>
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