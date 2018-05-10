<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/common.css" type="text/css"/>
<title>用户找回密码界面</title>
<style type="text/css">
.main{
 width: 1000px;
 height: 600px;
 margin: 0 auto;
}
.font6{
font-size: 30px;
font-weight: bold;
font-family: "华文新魏";
}
.code {
background-image: url(images/code.png);
font-family: Arial;
font-style: italic;
color: Red;
border: 0;
padding: 2px 3px;
letter-spacing: 3px;
font-weight: bolder;
}
.unchanged {
border: 0;
}
</style>
<script language="javascript" type="text/javascript">
var code; //在全局 定义验证码   
function createCode() {
    code = "";
    var codeLength = 6;//验证码的长度   
    var checkCode = document.getElementById("checkCode");
    var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的   
   
    for (var i = 0; i < codeLength; i++) {
        var charIndex = Math.floor(Math.random() * 36);
        code += selectChar[charIndex];
    }
    if (checkCode) {
        checkCode.className = "code";
        checkCode.value = code;
    }
}
function validate() {
    var inputCode = document.getElementById("input1").value;
    if(document.form.account.value == ""){
    	  alert("请输入用户名！");
    	  return false;
    }else if(document.form.email.value == ""){
    	alert("请输入邮箱号码！");
  	  return false;
    } else if (inputCode.length <= 0) {
        alert("请输入验证码！");
        return false;
    } else if (inputCode != code) {
        alert("验证码输入错误！");
	    createCode();//刷新验证码   
	    return false;
    }
    return true;
}
</script>
</head>
<body onload="createCode()">
 <jsp:include page="head.jsp" />
 <div class="main">
 <br>
<div><span class="font6">简单一步，找回密码！</span><hr></div>
<div style="margin-left: 400px">
<form name="form" method="post"
								action="ConsumerServlet?method=7"
								onSubmit="return validate()">
								<br>
		<span class="font4">账户名称:</span><br/>
	    <input type="text"  name="account" /><br/> 
	    <span  class="font4">绑定邮箱:</span><br/>
	  	<input type="text" name="email" /><br/>
	  	<span  class="font4">输入验证码:</span><br/>
		<input type="text" id="input1" /> 
    	<input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 80px" />
    	<br />
    	<br>
    	<input type="image"  src="images/zh.gif">
	&nbsp;&nbsp; <a href="#" onClick="javascript:form.reset()"><img	src="images/reset.gif"></a> 
	&nbsp;&nbsp; <a href="#"onClick="window.location.href='/1/index.jsp'"><img	src="images/back.gif"></a>
	</form>
	</div>
 </div>
</body>
</html>