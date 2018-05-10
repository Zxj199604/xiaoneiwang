<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>用户视频的上传</title>
<script type="text/javascript">
function addVideo() {
	if(document.form.videoAddress.value==""){
		alert("请选着上传视频");
		return false;
	}
	if(document.form.videoTite.value==""){
		alert("请输入视频名称");
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
							  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;视频上传</p>");
		  						%>
							 <form action="VideoSerlvet?method=2" method="post"  name="form" onSubmit="return addVideo()" enctype="multipart/form-data">
		  
            <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
              <tr>
                <td width="72" height="30"><div align="center">上传地址：</div></td>
                <td width="255" bgcolor="#FFFFFF">
                    <div align="left">
                      <input name="videoAddress" type="file" class="inputinput"  size="30">
                  </div></td></tr>
                 <tr>
                <td height="30"><div align="center">视频名称：</div></td>
                <td bgcolor="#FFFFFF">
                    <div align="left">
                      <input name="videoTite" type="text" class="inputinput"  size="30">
                  </div></td></tr>
              <tr>
              <tr>
                <td height="30"><div align="center">视频简介：</div></td>
                <td bgcolor="#FFFFFF">
                    <div align="left">
                    <textarea name="videoIntroduction" cols="30" rows="12" class="inputinput"></textarea>
                  </div></td></tr>
              <tr>
                <td height="30"><div align="center">上传时间：</div></td>
                <td bgcolor="#FFFFFF">
                  <div align="left">
                     <input name="accountId"   value="<%=consumerForm1.getId() %>  "    type="hidden"  >
                     <input name="videoTime" type="text" class="inputinput" onclick="alert('此文本框已设为只读，用户不能修改')" value="<%=countTime.currentlyTime() %>" size="30" readonly="readonly">
                  </div></td></tr>
            </table>
            <table width="494" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="494">
				<br>
				<div align="center" class="style1">注意：视频的格式只能为：“MP4” 格式</div></td>
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
			  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;<a href='back_PhotoInsert1.jsp'>添加图片</a></p>");
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