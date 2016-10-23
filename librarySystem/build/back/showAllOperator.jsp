<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,library.domain.operator.Operator"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>

		<title><bean:message key="title.adminInfo"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<h2>
				&nbsp;
			</h2>
		</center>
		<form id="form1" name="form1" method="post" action="">
			<table border="0" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td colspan="8" class="tb_showallbook">
						<div align="center">
							<bean:message key="tile.lable.adminInfo"/>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.adminName"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.password"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.bookoperareright"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.borrowright"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.searchright"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.readeroperaterright"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.systemoperateright"/>
						</div>
					</td>
					<td class="tb_sabookBorder">
						<div align="center">
							<bean:message key="tile.lable.operate"/>
						</div>
					</td>
				</tr>
				<%
					List<Operator> lof = (List) request.getAttribute("lof");
					for (Operator o : lof) {
				%>
				<tr>
					<td class="tb_sabookMain">
						<div align="center"><%=o.getName()%></div>
					</td>
					<td class="tb_sabookMain">
						<div align="center"><%=o.getPassword()%></div>
					</td>
					<td class="tb_sabookMain">
						<div align="center">
							<%
								if (o.getBook() == 1) {
										out.println("是");
									} else {
										out.println("否");
									}
							%>
						</div>
					</td>
					<td class="tb_sabookMain">
						<div align="center">
							<%
								if (o.getBorrow() == 1) {
										out.println("是");
									} else {
										out.println("否");
									}
							%>
						</div>
					</td>
					<td class="tb_sabookMain">
						<div align="center">
							<%
								if (o.getQuery() == 1) {
										out.println("是");
									} else {
										out.println("否");
									}
							%>
						</div>
					</td>
					<td class="tb_sabookMain">
						<div align="center">
							<%
								if (o.getReader() == 1) {
										out.println("是");
									} else {
										out.println("否");
									}
							%>
						</div>
					</td>
					<td class="tb_sabookMain">
						<div align="center">
							<%
								if (o.getSystem() == 1) {
										out.println("是");
									} else {
										out.println("否");
									}
							%>
						</div>
					</td>
					<td class="tb_sabookMain">
						<a href="sysOperator.do?method=showAuthority&id=<%=o.getId()%>">修改</a>
						<a href="sysOperator.do?method=removeOperator&id=<%=o.getId()%>">删除</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</body>
</html>
