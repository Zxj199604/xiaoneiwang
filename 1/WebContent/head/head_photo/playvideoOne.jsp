<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放界面</title>
    <link href="http://vjs.zencdn.net/5.0.2/video-js.css" rel="stylesheet">
    <script src="http://vjs.zencdn.net/ie8/1.1.0/videojs-ie8.min.js"></script>
    <script src="http://vjs.zencdn.net/5.0.2/video.js"></script>
<title>视屏播放</title>
<style>
  #instructions { max-width: 640px; text-align: left; margin: 30px auto; }
  #instructions textarea { width: 100%; height: 100px; }
  
  /* Show the controls (hidden at the start by default) */
  .video-js .vjs-control-bar { 
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
  }

  /* Make the demo a little prettier */
  body {
    margin-top: 20px;
    background: #222;
    text-align: center; 
    color: #aaa;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    background: radial-gradient(#333, hsl(200,30%,6%) );
  }
</style>
</head>
<body>
<%
String address=request.getParameter("address");
%>
<body>
<div id="instructions">
  <video id="my_video_1" class="video-js vjs-default-skin" width="640px" height="267px"
      controls preload="none" poster='http://video-js.zencoder.com/oceans-clip.jpg'
      data-setup='{ "aspectRatio":"640:267", "playbackRates": [1, 1.5, 2,2.5,3] }'>
    <source src="/1/<%=address %>"  type='video/mp4' />
  </video>
</div>
</body>
</html>