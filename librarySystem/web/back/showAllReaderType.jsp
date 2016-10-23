<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List,library.domain.readerType.ReaderType"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<title><bean:message key="title.ShowAllReaderType"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<h2></h2>
		</center>
		<form id="form1" name="form1" method="post" action="">
			<table width="500" height="110" border="0" cellpadding="0"
				cellspacing="0" align="center">
				<tr>
					<td colspan="3" class="tb_showallbook">
						<div align="center">
							<bean:message key="tile.lable.ShowAllReaderType"/>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tb_sabookBorder" width="71">
						<bean:message key="tile.lable.TypeName"/>
					</td>
					<td class="tb_sabookBorder">
						<bean:message key="tile.lable.BorrowBookNum"/>
					</td>
					<td class="tb_sabookBorder" width="61">
						<bean:message key="tile.lable.Operation"/>
					</td>
				</tr>
				<%
					List<ReaderType> lr = (List) request.getAttribute("allReaderType");
					for (ReaderType rt : lr) {
				%>
				<tr>
					<td class="tb_sabookMain"><%=rt.getName()%></td>
					<td class="tb_sabookMain"><%=rt.getQuantity()%></td>
					<td class="tb_sabookMain">
						<a href="readerType.do?method=showReaderType&id=<%=rt.getId()%>">编辑
						</a>
						<a href="readerType.do?method=removeReaderType&id=<%=rt.getId()%>">删除
						</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</body>
</html>
