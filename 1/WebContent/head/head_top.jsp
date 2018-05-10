<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页头部</title>
<style type="text/css">
.style1 {color: #c97802}
.style2 {color: #976600}
</style>
</head>
<%
//判断服务器form是否存在
if(session.getAttribute("form")==null){
out.print("<script language=javascript>alert('您已经与服务器断开，请重新登录！');window.location.href='/1/index.jsp';</script>");
}
//个人基本信息
com.zxj.dao.ConsumerDao consumerDao=new com.zxj.dao.ConsumerDao();
com.zxj.form.ConsumerForm consumerForm1=(com.zxj.form.ConsumerForm)session.getAttribute("form");
%>
<!-- 头部页面第一部分 -->
<body>
<table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="/1/images/head_picture/111.png" width="800"></td>
  </tr>
</table>
<!-- 头部页面第二部分 -->
<table width="800" height="71" border="0" align="center" cellpadding="0" cellspacing="0" background="/1/images/head_picture/head_04.jpg">
  <tr>
    <td width="31">&nbsp;</td>
    <td width="640"><table width="619" border="0" align="center" cellpadding="0" cellspacing="0">
      <!-- 显示用户的基本信息 -->
      <%
      com.zxj.form.ConsumerForm consumerHostForm = consumerDao.getConsumerForm(consumerForm1.getAccount());
         %>
      <tr>
        <td  height="20"><span class="style1">个人基本信息&nbsp;【<a href="/1/dealwith.jsp?sign=2">重新登录</a>】</span></td>
        <td colspan="2">
          <%if(consumerForm1.getManageLevel().equals("高级")){%>
          <div align="right"><span class="style2">【</span><a href="/1/back/backMainPage1.jsp" class="in">进入后台</a><span class="style2">】</span></div>
          <%}else{%>
           <div align="right"><span class="style2">【</span><a href="/1/back/backMainPage2.jsp" class="in">进入后台</a><span class="style2">】</span></div>
     	<%  } %>
        </td>
      </tr>
      <tr>
        <td height="20"><span class="style3 style2">姓名：<%=consumerHostForm.getName()%></span></td>
        <td width="212"><span class="style3 style2">性别：<%=consumerHostForm.getSex()%></span></td>
        <td width="195"><span class="style3 style2">兴趣：<%=consumerHostForm.getInterest()%></span></td>
      </tr>
      <tr>
        <td height="20"><span class="style3 style2">QQ号码：<%=consumerHostForm.getQQNumber()%></span></td>
        <td><span class="style3 style2">E-Mail：<%=consumerHostForm.getEMail()%></span></td>
        <td><span class="style3 style2">手机号：<%=consumerHostForm.getPhoneNumber() %></span></td>
      </tr>
    </table>
    </td>
    <td width="129">&nbsp;</td>
  </tr>
</table>
<!-- 头部页面第三部分 -->
<table width="800" height="26" border="0" align="center" cellpadding="0" cellspacing="0" background="/1/images/head_picture/head_05.jpg">
  <tr>
    <td width="37">&nbsp;</td>
    <td width="626">
	   <marquee direction="left"  scrollAmount="1" scrollDelay="1" class="tdtd">
            <span class="style4 style1">欢迎您光临校内网，您可以尽情地欣赏你喜欢的文章视频音乐等</span>
      </marquee>	</td>
    <td width="137">&nbsp;</td>
  </tr>
</table>
</body>
</html>