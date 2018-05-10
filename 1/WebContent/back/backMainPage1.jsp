<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<title>管理员后台首界面</title>
</head>
<body>
<jsp:include page="back_Top.jsp" flush="true" />
<!-- 中间部分 -->
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<!-- 第一列 -->
<td width="227" valign="top" background="/1/images/back_picture/back1.gif" >
		<jsp:include page="back_Left.jsp" flush="true" />   
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
		 <td width="81" height="88"><a href="/1/back/article/back_ArticleAdd.jsp" ><img src="/1/images/back_picture/article.jpg" width="81" height="72"></a></td>
 		<td width="140" height="88"><a href="/1/back/article/back_ArticleAdd.jsp" class="aaaa">发表文章</a><br>
 		<span class="style4">这里提供最方便的方式来发表你的文章，由你选择。</span></td>
 		<td width="81"><a href="/1/back/discuss/back_DiscussAdd.jsp" ><img src="/1/images/back_picture/review.jpg" width="81" height="72"></a></td>
 		<td width="140"><a href="/1/back/discuss/back_DiscussAdd.jsp" class="aaaa">公告添加</a><br> 
		 <span class="style4">这里提供最方便的方式来发表你的公告，由你选择。</span></td>
</tr>
 <tr>
 			 <td><a href="/1/back/vote/back_VoteAdd.jsp"><img src="/1/images/back_picture/vote.jpg" width="81" height="72"></a></td>
              <td width="140"><a href="/1/back/vote/back_VoteAdd.jsp" class="aaaa">投票内容添加</a><br>
              <span class="style4">这里提供最方便的方式来设置你的投票内容，由你选择。</span></td>
              <td height="76"><a href="/1/back/photo/back_PhotoInsert.jsp"><img src="/1/images/back_picture/photo.jpg" width="81" height="72"></a></td>
              <td width="140" height="88"><a href="/1/back/photo/back_PhotoInsert.jsp" class="aaaa">相册添加</a><br>
              <span class="style4">这里提供最方便的方式来上传你的照片，由你选择。</span></td>
             
</tr>
<tr>
			 <td width="81" height="72"><a href="/1/back/song/back_songAdd.jsp"><img src="/1/images/back_picture/song.png" width="81" height="72"></a></td>
			 <td width="140" height="88"><a href="/1/back/song/back_songAdd.jsp" class="aaaa">上传歌曲</a><br>
			 <span class="style4">这里提供最方便的方式来上传你的歌曲，由你选择。</span></td>	
             <td height="74"><a href="/1/back/personalinformation/personalUpdate.jsp"><img src="/1/images/back_picture/manager.jpg" width="81" height="72"></a></td>
             <td width="140" height="88"><a href="/1/back/personalinformation/personalUpdate.jsp"  class="aaaa">个人信息设置</a><br>
             <span class="style4">这里提供最方便的方式来设置你自己的个人信息，由你选择。</span></td>
   
</tr>
<tr>
				<td><a href="/1/back/friend/back_FriendAdd.jsp"><img src="/1/images/back_picture/friend.jpg" width="81" height="72"></a></td>
              	<td width="140"><a href="/1/back/friend/back_FriendAdd.jsp" class="aaaa">好友添加</a><br>
                <span class="style4">这里提供最方便的方式来设置你好友信息，由你选择。</span></td>
                <td ><a href="ConsumerServlet?method=4"><img src="/1/images/back_picture/account.jpg" width="81" height="72"></a></td>
              	<td width="140" ><a href="/1/back/consumer/back_consumerSelect.jsp" class="aaaa">用户设置</a><br>
                <span class="style4">这里提供最方便的方式来管理用户信息。</span></td>
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