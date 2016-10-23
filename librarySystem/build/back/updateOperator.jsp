<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="library.domain.operator.Operator"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<title><bean:message key="title.ModefyAdminRight"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form id="form" name="form1" method="post"
			action="sysOperator.do?method=updateAuthority">
			<table border="0" cellpadding="0" cellspacing="0" align="center">
				<%
					Operator o = (Operator) request.getAttribute("operator");
				%>
				<input type="hidden" name="id" value="<%=o.getId()%>" />
				<tr>

					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.ModefyAdminRight"/>
					</td>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.adminid"/>
					</td>
					<td class="tb_addbookRight">
						<%=o.getName()%></td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.rightoption"/>
					</td>
					<td class="tb_addbookRight">
						<input type="checkbox" name="bookOper" value="1"
							<%if(o.getBook()==1)out.println("checked"); %> />
						<bean:message key="tile.lable.bookoperareright"/>
						<input type="checkbox" name="borrowOper" value="1"
							<%if(o.getBorrow()==1)out.println("checked"); %> />
						<bean:message key="tile.lable.borrowright"/>
						<input type="checkbox" name="queryOper" value="1"
							<%if(o.getQuery()==1)out.println("checked"); %> />
						<bean:message key="tile.lable.searchright"/>
						<input type="checkbox" name="readerOper" value="1"
							<%if(o.getReader()==1)out.println("checked"); %> />
						<bean:message key="tile.lable.readeroperaterright"/>
						<input type="checkbox" name="sysOper" value="1"
							<%if(o.getSystem()==1)out.println("checked"); %> />
						<bean:message key="tile.lable.systemoperateright"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="tb_addbookall">

						<div align="center">
							<input class="input_bg" type="submit" name="Submit" value="提交" />
							&nbsp;&nbsp;

							<input class="input_bg" type="reset" name="Reset" value="重置" />
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
