<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.zxj.form.ArticleTypeForm" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript"
			src="/1/JS/validate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台文章添加</title>
</head>
<% 
com.zxj.dao.ConsumerDao consumerDao=new com.zxj.dao.ConsumerDao();
com.zxj.form.ConsumerForm consumerForm1=(com.zxj.form.ConsumerForm)session.getAttribute("form");
%>
<jsp:useBean id="articleTypeDao" scope="page"
	class="com.zxj.dao.ArticleTypeDao"></jsp:useBean>
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
								<%
								out.println(
										"<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;文章添加</p>");
							%>
							<form name="form" method="post" action="ArticleServlet?method=9"
								onSubmit="return sendInformation()">
								<table width="340" border="1" cellpadding="1" cellspacing="1"
									bordercolor="#FFFFFF" bgcolor="#ACD6FF">
									<tr>
										<td width="77" height="30">
											<div align="center">文章主题：</div>
										</td>
										<td width="250" bgcolor="#FFFFFF">
											<div align="center">
												<input name="title" type="text" class="inputinput" size="30">
											</div>
										</td>
									</tr>
									<tr>
										<td height="30">
											<div align="center">文章类别：</div>
										</td>
										<td bgcolor="#FFFFFF">
											<div align="center">

												<select name="typeId" class="inputinput">
													<%
														List list = articleTypeDao.queryArticleType();
														if(list.size()==0){
														out.print("<script language=javascript>alert('文章类型还没有添加，请添加！');window.location.href='back_ArticleTypeAdd.jsp';</script>");
														}
														for (int i = 0; i < list.size(); i++) {
															ArticleTypeForm form = (ArticleTypeForm) list.get(i);
													%>
													<option value="<%=form.getId()%>"><%=form.getTypeName()%></option>
													<%
														}
													%>
												</select>
											</div>
										</td>
									</tr>
									
									<tr>
										<td height="30">
											<div align="center">文章内容：</div>
										</td>
										<td bgcolor="#FFFFFF">
											<div align="center">
												<textarea name="content" cols="28" rows="20"
													class="inputinput"></textarea>
											</div>
										</td>
									</tr>
									
											<tr>
											<td height="30">
												<div align="center">
													发布时间：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<input name="phTime" type="text" class="inputinput"
														value="<%=countTime.currentlyTime()%>" size="30"
														readonly="readonly" onclick="alert('此文本框已设为只读，用户不能修改')">
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													访问次数：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<input name="number" type="text" class="inputinput"
														value="0" size="30" readonly="readonly"
														onclick="alert('此文本框已设为只读，用户不能修改')">
												</div>
												<input name="accountId"   value="<%=consumerForm1.getId() %>  "    type="hidden"  >
											</td>
										</tr>
										
									</table>
									<br>
									<input type="image" class="inputinputinput"
										src="/1/images/save.gif">
								&nbsp;&nbsp;
									<a href="#" onClick="javascript:form.reset()"><img
											src="/1/images/reset.gif">
									</a>		
							</form>
								<%
										if (request.getAttribute("result") != null) {
										out.print(request.getAttribute("result"));
									}
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