<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,library.domain.barcode.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title><bean:message key="title.showAllBook"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" language="JavaScript">
		function checkNum(numValue){
			//对数量的验证
			var numStr = /^[1-9]+[0-9]*$/;
			if(!numStr.test(numValue.value)){
				alert('提示\n\n请输入正确的数量');
				numValue.focus();
				return false;
			}
		}
		</script>
	</head>
	<body>
		<table width="910" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td colspan="10" class="tb_showallbook">
					<div align="center">
						<bean:message key="tile.lable.bookList"/>
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
					<bean:message key="tile.lable.author"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.publisher"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.price"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.incomedate"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.bookType"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.admin"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.operate"/>
				</td>
				<td class="tb_sabookBorder">
					<bean:message key="tile.lable.addnum"/>
				</td>
			</tr>
			<%
				List<Barcode> list = (List) request.getAttribute("allBookList");
				for (Barcode bc : list) {
			%>
			<tr>
				<td class="tb_sabookMain"><%=bc.getBarcode()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getBookName()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getAuthor()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getPublisher()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getPrice()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getInTime().toString()
										.substring(0, 10)%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getBooktypeT().getName()%></td>
				<td class="tb_sabookMain"><%=bc.getBookT().getOperatorT().getName()%></td>
				<td class="tb_sabookMain">
					<a href="bookInfo.do?method=showBook&id=<%=bc.getId()%>">编辑</a>
					<a href="bookInfo.do?method=removeBookBarcode&id=<%=bc.getId()%>">删除</a>
				</td>
				<td class="tb_sabookMain">
					<form
						action="bookInfo.do?method=addNum&id=<%=bc.getBookT().getId()%>"
						method="post" onsubmit="return checkNum(this.num);">
						<input type="text" name="num" size="4" />
						<input type="submit" name="nsubmit" value="添加" />
					</form>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="10">
					<%
						int pageNum = (Integer) request.getAttribute("pageNum");
						for (int i = 0; i < pageNum; i++) {
					%>
					<a href="bookInfo.do?method=findAllBook&page=<%=i + 1%>">第<%=i + 1%>页</a>
					<%
						}
					%>
				</td>
			</tr>
		</table>
	</body>
</html>
