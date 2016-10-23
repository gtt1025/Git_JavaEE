<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="library.domain.readerType.ReaderType"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<script language="javascript">
		function check(form){
			if(form.name.value==""){
				alert("类型名称不能为空！");
				return false;
			}
			if(form.quantity.value==""){
				alert("可借数量不能为空！");
				return false;
			}
			
			var temp = document.getElementById("quantity");
			//对数量的验证
			var quantityStr = /^[1-9]+[0-9]*$/;
			if(!quantityStr.test(temp.value))
			{
				alert('提示\n\n请输入正确的可借数量');
				temp.focus();
				return false;
			}
		}
		</script>
		<title><bean:message key="title.ModifyReaderType"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<form id="form" name="form" method="post"
			action="readerType.do?method=updateReaderType">
			<table width="323" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<%
					ReaderType rt = (ReaderType) request.getAttribute("readerType");
				%>
				<input type="hidden" name="id" value="<%=rt.getId()%>" />
				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.ModifyReaderType"/>
					</td>
				</tr>
				<tr>
					<td width="121" class="tb_addbook">
						<bean:message key="tile.lable.TypeName"/>
					</td>
					<td width="186" class="tb_addbookRight">
						<label>
							<input type="text" name="name" value="<%=rt.getName()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.BorrowNumber"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="quantity" value="<%=rt.getQuantity()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="tb_addbookall">
						<label>
							<div align="center">
								<input class="input_bg" type="submit" name="Submit" value="提交"
									onclick="return check(form)" />
								&nbsp;&nbsp;
								<input class="input_bg" type="reset" name="Reset" value="重置" />
							</div>
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
