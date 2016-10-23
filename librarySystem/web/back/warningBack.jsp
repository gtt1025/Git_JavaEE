<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,library.domain.borrow.Borrow"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
		<title><bean:message key="title.EndBook"/></title>
	</head>

	<body>
		<table width="1000" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td colspan="11" class="tb_addbookBgImage">
					<div align="center">
						<bean:message key="tile.lable.EndBooklist"/>
					</div>
				</td>
			</tr>
			<tr>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.BookNumber"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.BookName"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderName"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderDocumentsType"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderDocumentsNumber"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderRealName"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderEmail"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderPhone"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderType"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.BorrowBookTime"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.Deadline"/>
				</td>
			</tr>
			<%
				List<Borrow> list = (List) request.getAttribute("lb");
				for (Borrow br : list) {
			%>
			<tr>
				<td class="tb_sabookMain"><%=br.getBarcodeT().getBarcode()%></td>
				<td class="tb_sabookMain"><%=br.getBarcodeT().getBookT().getBookName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getPapertype()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getPaperNo()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getRealName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getEmail()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getTel()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getReaderTypeT().getName()%></td>
				<td class="tb_sabookMain"><%=br.getBorrowTime().toString().substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=br.getForceBackTime().toString().substring(0, 10)%></td>
			</tr>
			<%
				}
			%>
		</table>

	</body>
</html>
