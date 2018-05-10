<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="com.zxj.form.ConsumerForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>管理员查看用户的详细信息</title>
</head>
<%
ConsumerForm consumerForm=(ConsumerForm)request.getAttribute("form2");
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
							<%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;用户详细查询</p>");%>
		  
		  
            <table width="325" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
              <tr>
                <td width="93" height="30"><div align="center">账号：</div></td>
                <td width="219" bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getAccount()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">密码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getPassword()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">姓名：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getName()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">性别：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getSex()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">QQ号码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getQQNumber()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">手机号：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getPhoneNumber()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">兴趣爱好：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getInterest()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">电子邮箱：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getEMail()%></div></td>
              </tr>
            </table><br>
            <a href="back_consumerSelect.jsp" ><img src="/1/images/back.gif"></a>
							
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