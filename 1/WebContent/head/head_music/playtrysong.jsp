<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>音乐试听</title>
<head>
</head>
<jsp:useBean id="songDao" scope="session" class="com.zxj.dao.SongDao"></jsp:useBean>
<body>
<%String address=request.getParameter("address") ;
	String id=request.getParameter("id");
%>
<!-- 试听量加1 -->
<%
songDao.optionsong("试听", id);
%>
<audio controls="controls">
      <source src="/1/<%=address %>" type="audio/mpeg">
    </audio>
</body>
</html>