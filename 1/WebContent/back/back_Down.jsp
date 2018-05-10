<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
if(session.getAttribute("form")==null){
  out.print("<script language=javascript>alert('您已经与服务器断开，请重新登录！！！');window.location.href='index.jsp';</script>");
}
%>
<body>
<table width="227" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="/1/images/back_picture/back_noword_19.jpg" width="800" height="56"></td>
  </tr>
</table>
</body>
</html>