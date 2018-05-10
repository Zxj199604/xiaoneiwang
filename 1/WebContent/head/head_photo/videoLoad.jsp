<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.io.*,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频下载</title>
</head>
<%
String filepath="";
String filename="";
filepath=request.getParameter("address");
filename=request.getParameter("name");
%>
<body bgcolor="cyan">
<font size="2">
<%
try{
//获得响应客户的输出流： 
OutputStream   o=response.getOutputStream();        
//输出文件用的字节数组,每次发送500个字节到输出流：  
         byte   b[]=new   byte[500];            //下载的文件：   
		String photoDir = application.getRealPath("/");
         filepath=photoDir+"/"+filepath;
         File   fileLoad=new   File(filepath);        
         //客户使用保存文件的对话框：           
         response.setHeader("Content-disposition","attachment;filename="+URLEncoder.encode(filename, "UTF-8")+".mp4");       
          response.setContentType("application/force-download");         
         //通知客户文件的长度：              
         long   fileLength=fileLoad.length();           
         String   length=String.valueOf(fileLength); 
         response.setHeader("Content_Length",length);         
         //读取文件,并发送给客户下载:        
        	 FileInputStream   in=new   FileInputStream(fileLoad);    
         int   n=0;             
         while((n=in.read(b))!=-1)          
         {  
        	 o.write(b,0,n);            
         }   
         o.close();
         in.close();
         out.clear();
         out = pageContext.pushBody();
}catch(Exception exp){
	
}
%>
</font>
</body>
</html>