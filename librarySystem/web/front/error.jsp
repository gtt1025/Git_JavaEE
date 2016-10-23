<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title><bean:message key="front.lable.unlogin"/></title>
</head>

<body>
<table width="520" border=0 align=center cellpadding=3 cellspacing=1 style="border: 1px #3795D2 solid ; background-color: #FFFFFF;font: 12px;">
<tr>
	<th style="background-color: #3795D2;color: white;font-size: 20px;font-weight:bold;height: 26;">出错了！～！</th>
</tr>
<tr>
	<td style="background-color:#F7F7F7;font-size: 12px;height: 20;color:blue">&nbsp;</td>
</tr>
<tr>
	<td style="background-color:#F7F7F7;font-size: 12px;height: 40; text-align:center">


 <h2 align="center"> <bean:message key="front.lable.unlogin"/><a href="operatorLogin.jsp"><bean:message key="front.lable.login"/></a></h2>

</td>
</tr>
<tr>
  <td align=center style="background-color:#F0F0F0;font-size: 12px;height: 20;">【<a href='javascript:onclick=history.go(-1)'>返回</a>】</td>
</tr>
</table>
</body>
</html>

