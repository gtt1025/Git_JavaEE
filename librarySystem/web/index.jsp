<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="tile.lable.welcomemessages"/></title>
	</head>
	<body>
		<br />
		<br />
		<table width="520" border=0 align=center cellpadding=3 cellspacing=1
			style="border: 1px #3795D2 solid; background-color: #FFFFFF; font: 12px;">
			<tr>
				<th
					style="background-color: #3795D2; color: white; font-size: 20px; font-weight: bold; height: 26;">
					<bean:message key="tile.lable.welcomemessage"/>
				</th>
			</tr>
			<tr>
				<td
					style="background-color: #F7F7F7; font-size: 12px; height: 20; color: blue">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td
					style="background-color: #F7F7F7; font-size: 12px; height: 40; text-align: center">
					<li>
						<a href="front/reader.do?method=showLiberInfo">进入前台页面</a>
					</li>
					<br />
					<li>
						<a href="back/operatorLogin.jsp">进入后台页面</a>
					</li>
				</td>
			</tr>
			<tr>
				<td align=center
					style="background-color: #F0F0F0; font-size: 12px; height: 20;">
					<span
						style="background-color: #F7F7F7; font-size: 12px; height: 20; color: blue">&nbsp;&nbsp;<span
						id="jump">15</span> 秒钟后本窗口将自动关闭</span>
				</td>
			</tr>
			<tr>
				<td align=center
					style="background-color: #F0F0F0; font-size: 12px; height: 20;">
					【
					<a href='javascript:onclick=window.close()'>关闭本窗口</a>】
				</td>
			</tr>
		</table>
		<script language="JavaScript">
		function countDown(secs){
			jump.innerText=secs;if(--secs>0)setTimeout("countDown("+secs+")",1000);
		}
		countDown(15);
		setTimeout('window.close();', 15000);
		</script>
	</body>
</html>
