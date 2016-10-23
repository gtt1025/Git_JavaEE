<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="library.domain.operator.Operator"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<title><bean:message key="title.borrowbook"/></title>
		<script type="text/javascript" language="JavaScript">
		function check(form){
			if(form.barcode.value==""){
				alert("图书编号不能为空！");
				form.barcode.focus();return false;
			}
			if(form.identiCode.value==""){
				alert("借书证号不能为空！");
				form.identiCode.focus();return false;
			}
		}
		</script>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<form id="form1" name="form1" method="post"
			action="borrow.do?method=borrowBook">
			<table width="486" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<%
						Operator o = (Operator) session.getAttribute("operator");
					%>
					<input type="hidden" name="operatorid" value="<%=o.getId()%>" />
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
					<td class="tb_addbookBgImage" colspan=2>
						<bean:message key="tile.lable.borrowbook"/>
					</td>
				</tr>


				<tr>
					<td class="tb_addbook" width="197">
						<bean:message key="tile.lable.BookNumber"/>
					</td>
					<td width="273" class="tb_addbookRight">
						<label>
							<input type="text" name="barcode" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.borrowbooknum"/>
					</td>
					<td class="tb_addbookRight">
						<input type="text" name="identiCode" />
					</td>
				</tr>
				<tr>
					<td colspan="2" class="tb_addbookall">
						<label>
							<div align="center">
								<input class="input_bg" type="submit" name="Submit" value="借阅"
									onclick="return check(form1)" />
								&nbsp;&nbsp;
								<input class="input_bg" type="reset" name="Submit2" value="重置" />
							</div>
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
