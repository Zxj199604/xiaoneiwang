<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户投票内容的增加</title>
<link href="/1/CSS/head_CSS/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function voteAdd(){
	if(document.form.voteName.value==""){
		alert("请输入投票内容");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<jsp:include page="../back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0" background="/1/images/back_picture/back1.gif">
		<tr>
			<td width="227" valign="top"><jsp:include page="../back_Left.jsp"
					flush="true" /></td>
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
							<td valign="top" align="center">	
							 <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=/1/images/icon.gif width=10 height=10>&nbsp;&nbsp;投票内容添加</p>");%>
          <form name="form" method="post" action="VoteServlet?method=0" onSubmit="return voteAdd()">
          <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#ACD6FF">
          <tr>
                <td width="77" height="30"><div align="center">投票内容：</div></td>
                <td width="250" bgcolor="#FFFFFF"><div align="center">
                  <input name="voteName" type="text" class="inputinput"  size="30">
                </div></td>
              </tr>
            <tr>
                <td height="30"><div align="center">票数：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                 0
                </div></td>
              </tr>
          </table>
           <br>
 <input type="image" class="inputinputinput" src="/1/images/save.gif">
&nbsp;&nbsp;
 <a href="#" onClick="javascript:form.reset()"><img src="/1/images/reset.gif"></a>
          </form>
          <%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %>	
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
<jsp:include page="../back_Down.jsp" flush="true" />
</body>
</html>