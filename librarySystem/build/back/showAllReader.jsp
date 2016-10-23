<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List,library.domain.reader.Reader"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<title><bean:message key="title.showAllReader"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<table width="1000" height="100" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td colspan="13" class="tb_showallbook">
					<div align="center">
						<bean:message key="tile.lable.readerList"/>
					</div>
				</td>
			</tr>
			<tr>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.userid"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.password"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderType"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderRealName"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.sex"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.borrowbooknum"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.cardtype"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.cardmun"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderPhone"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.ReaderEmail"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.registertime"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.remark"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.operate"/>
				</td>
				<%
					List<Reader> lr = (List) request.getAttribute("allReaderList");
					for (Reader r : lr) {
				%>
			
			<tr>


				<td class="tb_sabookMain"><%=r.getName()%></td>
				<td class="tb_sabookMain"><%=r.getPassword()%></td>
				<td class="tb_sabookMain"><%=r.getReaderTypeT().getName()%></td>
				<td class="tb_sabookMain"><%=r.getRealName()%></td>
				<td class="tb_sabookMain">
					<%
						if (r.getSex() == 1) {
								out.println("男");
							} else {
								out.println("女");
							}
					%>
				</td>
				<td class="tb_sabookMain"><%=r.getIdentiCode()%></td>
				<td class="tb_sabookMain"><%=r.getPapertype()%></td>
				<td class="tb_sabookMain"><%=r.getPaperNo()%></td>
				<td class="tb_sabookMain"><%=r.getTel()%></td>
				<td class="tb_sabookMain"><%=r.getEmail()%></td>
				<td class="tb_sabookMain"><%=r.getRegistTime().toString().substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=r.getDescription()%></td>
				<td class="tb_sabookMain">
					<a href="readerInfo.do?method=showReader&id=<%=r.getId()%>">编辑</a>
					<a href="readerInfo.do?method=removeReader&id=<%=r.getId()%>">删除</a>
				</td>
			</tr>

			<%
				}
			%>
			<tr>
				<td colspan="13">
					<%
						int pageNum = (Integer) request.getAttribute("pageNum");
						for (int i = 0; i < pageNum; i++) {
					%>
					<a href="readerInfo.do?method=findReader&page=<%=i + 1%>">第<%=i + 1%>页</a>
					<%
						}
					%>
				</td>
			</tr>
		</table>


	</body>
</html>
