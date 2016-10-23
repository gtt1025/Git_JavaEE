<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List,library.domain.borrow.Borrow"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
		<title><bean:message key="title.BorrowHistory"/></title>
	</head>
	<body>
		<table width=800 border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td colspan="11" class="tb_addbookBgImage">
					<bean:message key="tile.lable.BorrowHistory"/>
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
					<bean:message key="tile.lable.ReaderID"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderRealName"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.BorrowID"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.BorrowBookTime"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.Deadline"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.BorrowPerson"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReturnCondition"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReturnDate"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReturnPerson"/>
				</td>
			</tr>
			<%
				List<Borrow> lbr = (List) request.getAttribute("borrwed");
				for (Borrow br : lbr) {
			%>
			<tr>
				<td class="tb_sabookMain"><%=br.getBarcodeT().getBarcode()%></td>
				<td class="tb_sabookMain"><%=br.getBarcodeT().getBookT().getBookName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getRealName()%></td>
				<td class="tb_sabookMain"><%=br.getReaderT().getIdentiCode()%></td>
				<td class="tb_sabookMain"><%=br.getBorrowTime().toString().substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=br.getForceBackTime().toString().substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=br.getOperatorTByBorrowOperator().getName()%></td>
				<td class="tb_sabookMain">
					<%
						if (br.getGiveback() == 0) {
								out.println("未归还");
							} else {
								out.println("已归还");
					%>
				</td>
				<td class="tb_sabookMain"><%=br.getGivebackTime().toString().substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=br.getOperatorTByGivebackOperator().getName()%></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="11">
					<%
						int pageNum = (Integer) request.getAttribute("pageNum");
						for (int i = 0; i < pageNum; i++) {
					%>
					<a href="borrow.do?method=historyBorrowed&page=<%=i + 1%>">第<%=i + 1%>页</a>
					<%
						}
					%>
				</td>
			</tr>

		</table>

	</body>
</html>
