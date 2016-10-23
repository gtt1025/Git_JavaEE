<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="library.domain.operator.Operator"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="title.givebackbook"/></title>
		<script type="text/javascript" language="JavaScript">
		function check(form){
			if(form.barcode.value==""){
				alert("图书编号不能为空！");
				form.barcode.focus();return false;
			}
		}
		</script>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<form id="form1" name="form1" method="post"
			action="borrow.do?method=giveBackBook">
			<table width="412" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<td class="ZiTie">
						<%
							String s = (String) request.getAttribute("error");
							if (s != "" && s != null) {
								out.println(s);
							}
						%>
					</td>
				</tr>
				<tr>
					<%
						Operator o = (Operator) session.getAttribute("operator");
					%><input type="hidden" name="operatorid" value="<%=o.getId()%>" />
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.givebackbook"/>
					</td>
				</tr>
				<tr>


					<td width="197" class="tb_addbook">
						<bean:message key="tile.lable.BookNumber"/>
					</td>
					<td width="197" class="tb_addbookRight">
						<label>
							<input type="text" name="barcode" />
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="tb_addbookall">
						<label>
							<div align="center">
								<input class="input_bg" type="submit" name="Submit" value="图书归还"
									onclick="return check(form1)" />
								<input class="input_bg" type="reset" name="reset" value="重置" />
							</div>
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
