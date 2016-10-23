<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<script language="javascript">
		function check(form){
			if (form.name.value==""){
				alert("请输入管理员名称!");form.name.focus();return false;
			}
			if (form.password.value==""){
				alert("请输入管理员密码!");form.pwd.focus();return false;
			}	
		}
		</script>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
		<title><bean:message key="title.operatorLogin"/></title>

	</head>
	<body>
		<br />
		<br />
		<br />
		<br />
		<form id="form" name="form" method="post"
			action="operatorUtil.do?method=operatorLogin">
			<table align="center" width="600" border="0" cellpadding="8"
				cellspacing="0" class="logintable">
				<tr class="loginheader">
					<td width="80"></td>
					<td width="100"></td>
					<td colspan="2"></td>
					<td width="120"></td>
					<td width="80"></td>
				</tr>
				<tr style="height: 40px">
					<td>
						&nbsp;
					</td>
					<td colspan="4" class="line1">
						<span class="STYLE1"><bean:message key="tile.lable.welcomemessages"/></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td colspan="2" class="line2">
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<%
							if (request.getAttribute("flag") != null) {
						%>
						用户名或密码输入有误！
						<%
							}
						%>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td align="right">
						<bean:message key="tile.lable.usernames"/>
					</td>
					<td colspan="2">
						<input type="text" name="name" />
					</td>
					<td></td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td style="height: 32px">
						&nbsp;
					</td>
					<td align="right" style="height: 32px">
						<bean:message key="tile.lable.passwords"/>
					</td>
					<td colspan="2" style="height: 32px">
						<input type="password" name="password" />
					</td>
					<td style="height: 32px">
						&nbsp;
					</td>
					<td style="height: 32px">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td style="height: 29px">
						&nbsp;
					</td>
					<td align="right" class="line1" style="height: 29px">
						&nbsp;
					</td>
					<td class="line1" style="width: 71px; height: 29px;">
					</td>
					<td class="line1" style="height: 29px">
					</td>
					<td class="line1" style="height: 29px; font-size: 12px"></td>
					<td style="height: 29px">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td colspan="2" class="line2">
						<div align="center">
							&nbsp;
							<input type="submit" width="20" name="Submit" value="提交"
								onClick="return check(form)" />
							&nbsp;
							<input type="reset" name="Submit2" value="重置" />
						</div>
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: center; font-size: 12px">
						Powered by
						<a href="#" target="_blank" style="color: #fff"></a> &nbsp;&copy;
						2010  哈尔滨工业大学（威海）
						<a href="#" target="_blank" style="color: #fff"> Inc.</a>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td colspan="2">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>