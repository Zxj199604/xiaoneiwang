<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>用户后台首界面</title>
</head>
<body>
<jsp:include page="back_Top1.jsp" flush="true" />
<!-- 中间部分 -->
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<!-- 第一列 -->
<td width="227" valign="top" background="/1/images/back_picture/back1.gif" >
		<jsp:include page="back_Left1.jsp" flush="true" />   
</td>
<!-- 第二列 -->
<td width="573" valign="top"   background="/1/images/back_picture/back1.gif">
<table width="227" border="0" cellpadding="0" cellspacing="0">
<tr>
        <td >
        	<img src="/1/images/back_picture/back_noword_03.jpg" width="573" height="25">
        </td>
</tr>
</table>

<table width="573" border="0" cellpadding="0" cellspacing="0" background="/1/images/back_picture/back_noword_05.jpg">
<tr>
<td valign="middle">
<table border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
		<td width="81" height="88"><a href="/1/back/article/back_ArticleAdd1.jsp" ><img src="/1/images/back_picture/article.jpg" width="81" height="72"></a></td>
 		<td width="140" height="88"><a href="/1/back/article/back_ArticleAdd1.jsp" class="aaaa">发表文章</a><br>
 		<span class="style4">这里提供最方便的方式来发表你的文章，由你选择。</span></td>
		 <td height="76"><a href="/1/back/photo/back_PhotoInsert1.jsp"><img src="/1/images/back_picture/photo.jpg" width="81" height="72"></a></td>
              <td width="140" height="88"><a href="/1/back/photo/back_PhotoInsert1.jsp" class="aaaa">相册添加</a><br>
              <span class="style4">这里提供最方便的方式来上传你的照片，由你选择。</span></td>
</tr>
<tr>
			 <td width="81" height="72"><a href="/1/back/song/back_songAdd1.jsp"><img src="/1/images/back_picture/song.png" width="81" height="72"></a></td>
			 <td width="140" height="88"><a href="/1/back/song/back_songAdd1.jsp" class="aaaa">上传歌曲</a><br>
			 <span class="style4">这里提供最方便的方式来上传你的歌曲，由你选择。</span></td>	
			<td height="74"><a href="/1/back/personalinformation/personalUpdate1.jsp"><img src="/1/images/back_picture/manager.jpg" width="81" height="72"></a></td>
             <td width="140" height="88"><a href="/1/back/personalinformation/personalUpdate1.jsp"  class="aaaa">个人信息设置</a><br>
             <span class="style4">这里提供最方便的方式来设置你自己的个人信息，由你选择。</span></td>
</tr>
</table>
</td>
</tr>
</table>
<table width="227" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="/1/images/back_picture/back_noword_18.jpg" width="573" height="21"></td>
        </tr>
</table>

</td>
</tr>
</table>
<jsp:include page="back_Down.jsp" flush="true" />
</body>
</html>