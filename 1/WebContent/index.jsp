<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校内网首页</title>
<link rel="stylesheet" href="CSS/common.css" type="text/css"/>
<link rel="stylesheet" href="CSS/index.css" type="text/css"/>
<script type="text/javascript" src="JS/jquery/jquery-3.3.1.js"></script>
<script src="JS/index.js" language="javascript" type="text/javascript"></script>
</head>
<body>
<!-- 引入多页面 -->
 <jsp:include page="head.jsp" />
  	<div class="main">
  	<div class="reg_login">
  	 <div class="logForm">
    	<form id="loginForm"  name="form1" method="post"
								action="ConsumerServlet?method=0&sign=0">
	    <span class="font4">登录账号:</span><br/>
	    <input type="text"  name="email" placeholder="用户名"  id="user"/><br/> 
	    <span  class="font4">登录密码:</span><br/>
	    <input type="password" name="pwd"  placeholder="密码" id="pswd" /><br/>
	    <label><input type="checkbox" id="remember"/> 记住密码</label><br/>
	    <input type="image" src="images/land.gif"  style="margin-top: 3px;"/>
	    &nbsp;&nbsp;<a href="findpassword.jsp" >找回密码</a><br/>
		<span  class="tip" id="tips">账号密码不能为空！</span>
	    </form>
    </div>
  	<div class="reg">
	    <span class="font5">注册</span><br/>
	    <a href="register.jsp">校内网期待你的加入</a>
    </div>
    <div class="mobile_login">
	    <span class="font5">手机登录</span><br/>
	    <a href="#">请访问m.xiaonei.com </a>
    </div>
    </div>
    <!-- 图片的展示 -->
 <div class="banner1">
   <div id="middle_content" class="middle_content">
    	<div class="middle_content_min">
        	<div class="middle_image">
            	<img src="images/carouselPhoto/1.jpg">
        	</div>
        <ul id="tab_btn" class="tab_btn">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
	        <a href="javascript:void(0);" class="click_btnl"></a>
	        <a href="javascript:void(0);" class="click_btnr"></a>
   	 	</div>
	</div>

<script type="text/javascript" src="JS/carouselPhoto.js"></script>
</div>
    
  	<!-- 校内网大致简介 -->
  	 <div  class="intro">
    	<span class="font2">校内网是一个真实社交网络，加入她你可以：</span> 
			<li>交谈朋友，了解他们的最新动态</li> 
			<li>用心感受文章，体验交流的快感</li> 
			<li>欣赏那些赏析悦目的照片</li> 
		  	<li>聆听你所喜欢的音乐</li> 
			<li>自由、安全地控制个人隐私</li> 
    </div>
    <!-- 注册第二个入口 -->
    <div class="reg2">
    <span class="font2">因为真实 所以精彩</span>
    <p>
    校内存知己<br/>
    <input type="image" onclick="javascript:window.location.href='register.jsp'" src="images/register.jpg" />
    </p>
    </div>
    <!-- 寻找你的朋友 -->
    <div class="sea_friend">
    <span class="font2">寻找你的朋友</span>　<input type="text" name="sea_friend" />
    <a href="#" ><img src="images/sou.jpg"  /></a><br/>
    * <span class="font3">校内网目前已开通<font class="font1">海外2000所大学</font>、 <font class="font1">国内3500所大学</font>、 <font class="font1">56000所中学</font>及 <font class="font1">85000家公司</font>。</span>
    </div>
    <!-- 建议 -->
    <div class="advice">
    <span class="font4">我们每天都在快乐地进步着：</span><br/> 
	10月16日 全新界面登场 <br/>
	10月15日 相册预加载和FLASH版上传，浏览相册更快更爽<br/>
	10月14日 留言新增“悄悄话”功能 <br/>
    </div>
  	</div>
<jsp:include page="foot.jsp" />
</body>
</html>