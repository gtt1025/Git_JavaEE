<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="title.addType"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
		<script language="javascript">
		function check(form){
			if(form.name.value==""){
				form.name.focus();
				alert("类型名称不能为空!");
				return false;
			}
		
		}
		</script>
	</head>
	<body>
		<form id="form" name="form" method="post"
			action="booktype.do?method=addBookType">
			<table width="323" height="110" border="0" cellpadding="0"
				cellspacing="0" align="center">
				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="lable.addbooktype"/>
					</td>
				<tr>
					<td width="121" class="tb_addbook">
						<bean:message key="lable.typename"/>
					</td>
					<td width="186" class="tb_addbookRight">
						<label>
							<input type="text" name="name" />
						</label>
					</td>
				<tr>
					<td colspan="2" class="tb_addbookall">
						<div align="center">
							<input class="input_bg" type="submit" name="Submit" value="提交"
								onclick="return check(form)" />
							<input class="input_bg" type="reset" name="reset" value="重置" />
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
