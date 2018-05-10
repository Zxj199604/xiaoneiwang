<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/head.css" type="text/css"/>
<script type="text/javascript">
	function changeBG(o){
		o.style.backgroundColor="#5C75AA";
	}
	function changeBG2(o){
		o.style.backgroundColor="";
	}
  </script>
</head>
<body>
<div class="head1">
   <img class="img1" src="images/top1.gif" width="713px"/>
   <img class="img2" src="images/top2.jpg" width="280px"/>
   <img src="images/xnw3.jpg" style="float: left;"/>
   <ul class="navi1">
   <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="register.jsp">注册</a></li>
   <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">设为首页</a></li>
   <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">加入收藏</a></li>
   <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">帮助</a></li>
   </ul>
</div>
</body>
</html>