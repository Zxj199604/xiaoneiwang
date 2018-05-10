<%@page import="java.text.Normalizer.Form"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.zxj.form.*" %>
    <%@page import="com.zxj.tool.*" %>
    <%@page import="com.zxj.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html;charset=utf-8");
request.setCharacterEncoding("utf-8");
Integer sign = Integer.valueOf(request.getParameter("sign"));
//0 用户登录的处理页面
if (sign == 0){
	if (request.getAttribute("information") != null) {
		String information = (String) request
		.getAttribute("information");
		out.print("<script language=javascript>alert('"
		+ information + "');history.go(-1);</script>");
	} else{
		session.setAttribute("form", request.getAttribute("form"));
		out
		.print("<script language=javascript>alert('用户登录成功！');window.location.href='/1/head/head_main.jsp';</script>");
	}
}
//1用户注册的处理页面
if (sign == 1) {
		String result = (String) request.getAttribute("result");
		if (result.equals("success")) {
			session.setAttribute("form", request.getAttribute("form"));
			out
			.print("<script language=javascript>alert('用户注册成功！');window.location.href='/1/head/head_main.jsp';</script>");
		}
		if (result.equals("fail")) {
			out
			.print("<script language=javascript>alert('用户注册失败,用户名已存在！');history.go(-1);</script>");
		}
	}
//2用户进行重新登录
if(sign==2){
		session.invalidate();
		response.sendRedirect("index.jsp");
}
//3处理投票结果
if(sign==3){
	//得到投票选项的iD
	com.zxj.form.VoteForm voteForm = new com.zxj.form.VoteForm();
	com.zxj.dao.VoteDao voteDao =new com.zxj.dao.VoteDao();
	Boolean flag=false;
	String votedid="";
	String[] voteID = request.getParameterValues("voteID");
	if (voteID == null) {
		out.print("<script language=javascript>alert('请进行投票！');history.go(-1);</script>");
	}else {
		for (int i = 0; i < voteID.length; i++){
			votedid=votedid+voteID[i]+"#";//记录写所选内容的编号
			voteForm.setId(Integer.valueOf(voteID[i]));
			flag=voteDao.operationVote("投票", voteForm);
		}
	}
	if(flag){
		//记录下此用户已经投过票
		if(session.getAttribute("form")!=null){
			ConsumerForm consumerForm=(ConsumerForm)session.getAttribute("form");
			VotedForm votedForm=new VotedForm();
			VotedDao votedDao=new VotedDao();
			votedForm.setAccountId(consumerForm.getId().toString());
			votedForm.setVoteid(Chinese.toChinese(votedid));	
			votedDao.addvoteds(votedForm);
		}
		application.setAttribute("vote","voteSuccess");
		out.print("<script language=javascript>alert('投票成功，请看投票结果！');window.location.href='/1/head/head_vote/head_VoteQuery.jsp';</script>");
	}
}	
%>
</body>
</html>