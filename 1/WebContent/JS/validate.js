


function accountADD() { // 用户注册验证
	if (document.form.account.value == "") {
		document.getElementById('1').style.display="inline";
		return false;
	}else{
		document.getElementById('1').style.display="none";
	}
	
	if (document.form.password.value == "") {
		document.getElementById('2').style.display="inline";
		return false;
	}else{
		document.getElementById('2').style.display="none";
	}
	if (document.form.repeatPassword.value == "") {
		document.getElementById('3').style.display="inline";
		return false;
	}else{
		document.getElementById('3').style.display="none";
	}
	if (form.password.value != form.repeatPassword.value) {
		document.getElementById('3').style.display="inline";
		return false;
	}else{
		document.getElementById('3').style.display="none";
	}
	if (document.form.name.value == "") {
		document.getElementById('4').style.display="inline";
		return false;
	}else{
		document.getElementById('4').style.display="none";
	}
	
	if (document.form.QQnumber.value == "") {
		document.getElementById('5').style.display="inline";
		return false;
	}else{
		document.getElementById('5').style.display="none";
	}
	if (isNaN(document.form.QQnumber.value)) {
		document.getElementById('5').style.display="inline";
		return false;
	}else{
		document.getElementById('5').style.display="none";
	}
	if(isNaN(document.form.phonenumber.value)){
		document.getElementById('6').style.display="inline";
		return false;
	}else{
		document.getElementById('6').style.display="none";
	}
	if (document.form.interest.value == "") {
		document.getElementById('7').style.display="inline";
		return false;
	}else{
		document.getElementById('7').style.display="none";
	}
	if (document.form.eMail.value == "") {
		document.getElementById('8').style.display="inline";
		return false;
	}else{
		document.getElementById('8').style.display="none";
	}
	var i = form.eMail.value.indexOf("@");
	var j = form.eMail.value.indexOf(".");
	if ((i < 0) || (i - j > 0) || (j < 0)) {
		document.getElementById('8').style.display="inline";
		return false;
	}
	return true;
}
function userCheck(){//用户账号密码是否为空的检查
	if(document.form1.email.value==""){
		document.getElementById('tips').style.display="inline";
		return false;
	}else{
		document.getElementById('tips').style.display="none";
	}
	if(document.form1.pwd.value==""){
		document.getElementById('tips').style.display="inline";
		return false;
	}else{
		document.getElementById('tips').style.display="none";
	}
	return true;	
}

//文章回复的提示信息
function addRestore(){
	if(document.form2.reTitle.value==""||document.form2.reContent.value==""){
		document.getElementById('ts').style.display="inline";
		return false;
	}
	return true;
}

function addsongRestore(){
	if(document.form3.reContent.value==""){
		document.getElementById('ts').style.display="inline";
		return false;
	}
	return true;
	
}
function sendInformation() { // 主题发布//添加文章的back_articleadd
	if (document.form.title.value == "") {
		window.alert("请输入主题名称");
		return false;
	}
	if (document.form.content.value == "") {
		window.alert("请输入主题内容");
		return false;
	}
	if (form.content.value.length > 1600) {
		alert("内容至多为1600位，请重新输入！");
		return false;
	}
	return true;
}

function personalUpdate(){//后台用户个人信息修改
	if (document.form.password.value == "") {
		window.alert("请输入用户登录密码！");
		return false;
	}
	if (document.form.repeatPassword.value == "") {
		window.alert("请输入重复登录密码！");
		return false;
	}
	if (form.password.value != form.repeatPassword.value) {
		alert("您两次输入的密码不一致，请重新输入！");
		return false;
	}
	if (document.form.name.value == "") {
		window.alert("请输入用户姓名！");
		return false;
	}
	if (document.form.QQnumber.value == "") {
		window.alert("请输入QQ号码！");
		return false;
	}
	if (isNaN(document.form.QQnumber.value)) {
		window.alert("QQ号码必须为数字！");
		return false;
	}
	if(document.form.phoneNumber.value==""){
		window.alert("请输入手机号");
		return false;
	}
	if (document.form.interest.value == "") {
		window.alert("请输入兴趣内容！");
		return false;
	}
	if (document.form.eMail.value == "") {
		window.alert("请输入eMail地址内容！");
		return false;
	}
	var i = form.eMail.value.indexOf("@");
	var j = form.eMail.value.indexOf(".");
	if ((i < 0) || (i - j > 0) || (j < 0)) {
		alert("您输入的Email地址不正确，请重新输入！");
		return false;
	}
	return true;
}





