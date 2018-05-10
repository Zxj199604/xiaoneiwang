<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.ConsumerForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台个人信息设置</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript"
			src="/1/JS/validate.js"></script>
</head>
<%
ConsumerForm consumerForm=(ConsumerForm)session.getAttribute("form");
%>
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
							 <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;信息详细查询</p>");%>
							  <form name="form" method="post" action="ConsumerServlet?method=5" onSubmit="return personalUpdate()">
		  
            <table width="325" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
              <tr>
                <td width="93" height="30"><div align="center">用户名：</div></td>
                <td width="219" bgcolor="#FFFFFF">
                <div align="center">
                <input name="account" type="text" class="inputinput" size="40" value="<%=consumerForm.getAccount()%>" readonly="readonly" onclick="alert('此文本框已设为只读，不能修改')">
                </div>
                </td>
              </tr>
                 <tr>
                <td height="30"><div align="center">密码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="password" type="password" class="inputinput"  size="40" value="<%=consumerForm.getPassword()%>"></div></td>
              </tr>
			     <tr>
                <td height="30"><div align="center">重复密码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="repeatPassword" type="password" class="inputinput"  size="40" value="<%=consumerForm.getPassword()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">姓名：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="name" type="text" class="inputinput"  size="40" value="<%=consumerForm.getName()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">性别：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
				<input name="sex" type="radio" class="inputinputinput" value="男" <%if(consumerForm.getSex().trim().equals("男")){%>checked<%}%> >
        男
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="sex" type="radio" class="inputinputinput" value="女" <%if(consumerForm.getSex().trim().equals("女")){%>checked<%}%> > 
        女
		</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">QQ号码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="QQnumber" type="text" class="inputinput"  size="40" value="<%=consumerForm.getQQNumber()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">手机号：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="phoneNumber" type="text" class="inputinput"  size="40" value="<%=consumerForm.getPhoneNumber()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">兴趣爱好：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="interest" type="text" class="inputinput"  size="40" value="<%=consumerForm.getInterest()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">电子邮箱：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                <input name="eMail" type="text" class="inputinput" size="40" value="<%=consumerForm.getEMail()%>">
              <input name="id" value="<%=consumerForm.getId()%>" type="hidden" >
				 </div>
                </td>
             	
              </tr>
            </table>
            <br>
 <input type="image" class="inputinputinput" src="/1/images/save.gif">
&nbsp;&nbsp;
 <a href="#" onClick="javascript:form.reset()"><img src="/1/images/reset.gif"></a>
            </form>	
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