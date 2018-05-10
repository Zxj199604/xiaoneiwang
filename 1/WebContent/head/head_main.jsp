<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script src="/1/JS/move.js" language="javascript" type="text/javascript"></script>
<script src="js/prefixfree.min.js"></script>
<title>前端首页面</title>
<style>
.gallery {
  width: 400px;
  margin: 30px auto;
  padding: 2px;
  background: #FFFFFF;
}

.gallery > div {
  position: relative;
  float: left;
  padding: 10px;
}

.gallery > div >a> img {
  width: 380px;
  height:250px;
  transition: .1s transform;
  transform: translateZ(0);
  /* hack */
}
.gallery >div:hover {
  z-index: 1;
}
.gallery > div:hover>a > img {
  transform: scale(1.5, 1.5);
  transition: .3s transform;
}
.cf:before, .cf:after {
  display: table;
  content: "";
  line-height: 0;
}
.cf:after {
  clear: both;
}
</style>
</head>
<body>
<!-- 网页头部 -->
	<jsp:include page="head_top.jsp" flush="true" />
	<div id="to_top"><img  src="/1/images/head_picture/sst.gif"  style ="width: 40px;height:30px;"></div><!-- 随鼠标移动的蝴蝶 -->
	<!-- 中间部分,为一张大的表格，分为5列其中第二列分为三个部分 -->
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
		<!--第一列-->
			<td width="74"><img src="/1/images/head_picture/head_06.jpg" width="74"
				height="875"></td>
		<!--第二列-->
			<td height="868" valign="top" >
			<div class="gallery cf">
				  <div>
				     <a href="/1/head/head_article/head_ArticleList.jsp" title="文章"><img src="/1/images/head_picture/read.png" /></a>
				  </div>
				  <div>
				    <a href="/1/head/head_photo/head_photoSelect.jsp" title="相册"> <img src="/1/images/head_picture/photo.png" /></a>
				  </div>
				  <div>
				    <a href="/1/head/head_music/head_MusicList.jsp" title="音乐"><img src="/1/images/head_picture/music.jpg" />  </a>
				  </div>
				</div>
			</td>
			<!--第三列-->
			<td width="10"><img src="/1/images/head_picture/head_08.jpg" width="13"
				height="868">
			</td>
			<!--第四列，关于内容的基本分类、日历和最新公告部分-->
			<td width="184" valign="top">
				<jsp:include page="head_right.jsp" flush="true" />
			</td>
			<!--第五列-->
			<td width="122"><img src="/1/images/head_picture/head_10.jpg" width="122"
				height="875">
			</td>
		</tr>	
	</table>
		<!-- 网页结尾 -->
	<jsp:include page="head_down.jsp" flush="true" />
</body>
</html>