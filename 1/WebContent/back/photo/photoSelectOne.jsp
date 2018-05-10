<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个图片的显示</title>
</head>
<body>
<table width="422" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="318"><img src="/1/<%=request.getParameter("image")%>" height="700" width="600">&nbsp;</td>
  </tr>
</table>
</body>
</html>