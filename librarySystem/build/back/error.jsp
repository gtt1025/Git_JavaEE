<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="title.errormessage "/></title>
	</head>

	<body>
		<table width="520" border=0 align=center cellpadding=3 cellspacing=1
			style="border: 1px #3795D2 solid; background-color: #FFFFFF; font: 12px;">
			<tr>
				<th
					style="background-color: #3795D2; color: white; font-size: 20px; font-weight: bold; height: 26;">
					<bean:message key="tile.lable.messages"/>
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
					<%
						String error = (String) request.getAttribute("error");
						if (error != null) {
					%>
					<h2 align="center"><%=error%></h2>

					<%
						}
					%>
				</td>
			</tr>
			<tr>
				<td align=center
					style="background-color: #F0F0F0; font-size: 12px; height: 20;">
				</td>
			</tr>
		</table>
	</body>
</html>
