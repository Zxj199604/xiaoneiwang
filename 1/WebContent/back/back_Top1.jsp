<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>后台-头部</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/1/JS/onclock.js"></script>
</head>
<%
if(session.getAttribute("form")==null){
out.print("<script language=javascript>alert('您已经与服务器断开，请重新登录！');window.location.href='/1/index.jsp';</script>");
}
%>
<body onselectstart="return false" onLoad="clockon(bgclock)">
<table width="800" height="65" border="0" align="center" cellpadding="0" cellspacing="0" background="/1/images/back_picture/back_noword_01.jpg">
  <tr>
    <td width="500">&nbsp;</td>
    <td width="299"><p>&nbsp;</p>
    <p><a href="/1/head/head_main.jsp" class="backTop">返回首页</a>&nbsp;<font color="#FFFFFF">|</font>&nbsp; <a href="/1/back/backMainPage2.jsp" class="backTop">管理信息</a>&nbsp;<font color="#FFFFFF">|</font>&nbsp; <a href="/1/dealwith.jsp?sign=2" class="backTop">安全退出</a>&nbsp;<font color="#FFFFFF"></font>&nbsp; &nbsp;&nbsp;</p></td>
  </tr>
</table>

<table width="800" height="29" border="0" align="center" cellpadding="0" cellspacing="0" background="/1/images/back_picture/back_noword_011.jpg">
  <tr>
    <td valign="top">
    <table width="379" height="23" border="0" cellpadding="0" cellspacing="0">
      <tr align="center"  >
        <td><font color="#805717"><div id="bgclock"></div></font></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>