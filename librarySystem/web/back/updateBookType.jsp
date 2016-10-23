<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@page import="library.domain.bookType.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<script language="javascript">
		function check(form){
			if(form.name.value==""){
				alert("类型名称不能为空");
				return false;
			}
		}
		</script>
		<title><bean:message key="title.ModifyBookType"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<form id="form" name="form" method="post"
			action="booktype.do?method=updateBookType">
			<table width="323" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<%
					BookType bookType = (BookType) request.getAttribute("bookType");
				%><input type="hidden" name="id" value="<%=bookType.getId()%>" />
				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.ModifyBookType"/>
					</td>
				</tr>
				<tr>
					<td width="121" class="tb_addbook">
						<bean:message key="tile.lable.TypeName"/>
					</td>
					<td width="186" class="tb_addbookRight">
						<label>
							<input type="text" name="name" value="<%=bookType.getName()%>" />
						</label>
					</td>
				</tr>

				<tr>
					<td colspan="2" class="tb_addbookall">
						<label>
							<div align="center">
								<input class="input_bg" type="submit" name="Submit" value="提交"
									onclick="return check(form)" />
								<input class="input_bg" type="reset" name="Reset" value="重置" />
							</div>
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
