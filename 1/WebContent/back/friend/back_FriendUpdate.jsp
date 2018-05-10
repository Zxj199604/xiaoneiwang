<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <jsp:directive.page import="com.zxj.form.FriendForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>后台朋友信息的修改</title>
<script type="text/javascript">
function friendAdd() {
	if(document.form.name.value==""){
		alert("请输入用户名");
		return false;
	}
	if(document.form.QQNumber.value==""){
		alert("请输入QQ号");
		return false;
	}
	if (isNaN(document.form.QQNumber.value)){
		alert("QQ号码必须为数字！");
		return false;
	}
	return true;
}
</script>
</head>
<%FriendForm form=(FriendForm)request.getAttribute("form1");%>
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
							 <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;朋友修改</p>");%>
		  <form name="form" method="post" action="FriendServlet?method=3&id=<%=form.getId()%>" onSubmit="return friendAdd()">
		  
            <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
              <tr>
                <td width="72" height="30"><div align="center">昵称：</div></td>
                <td width="255" bgcolor="#FFFFFF"><div align="center">
                  <input name="name" type="text" class="inputinput"  size="30" value="<%=form.getName()%>">
                </div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">QQ号码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                  <input name="QQNumber" type="text" class="inputinput"  size="30" value="<%=form.getQQNumber()%>">
                </div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">描述：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                  <textarea name="description" cols="28" rows="20" class="inputinput" ><%=form.getDescription()%></textarea>
                </div></td>
              </tr>
            </table>
            <br>
 <input type="image" class="inputinputinput" src="/1/images/modify.gif" width="51" height="20">
&nbsp;&nbsp;
 <a href="#" onClick="javascript:form.reset()"><img src="/1/images/reset.gif"></a>
 &nbsp;&nbsp;
<a href="back_FriendSelect.jsp" ><img src="/1/images/back.gif"></a>
            </form>		
			<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %>
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