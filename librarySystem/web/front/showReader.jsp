<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="library.domain.reader.Reader"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<script language="javascript">
		function check(form){
			if (form.password.value==""){
				alert("请输入密码!");form.password.focus();return false;
			}	
			if (form.password.value!=form.password2.value){
				alert("两次输入的密码不一致!");form.password2.focus();return false;
			}	
			var temp = document.getElementById("email");
			//对电子邮件的验证
			var emailStr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!emailStr.test(temp.value)){
				alert('提示\n\n请输入有效的E_mail！');
				temp.focus();
				return false;
			}
			
			var temp = document.getElementById("tel");
			//对电话号码的验证
			var telStr = /^[0-9]*$/;
			if(!telStr.test(temp.value)){
				alert('提示\n\n请输入有效的电话号码！');
				temp.focus();
				return false;
			}
		}
		</script>
<form id="form" name="form" method="post"
			action="reader.do?method=updateReaderInfo">
			<table width="545" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<%
					List l = (List) request.getAttribute("showReaderInfoList");
					Reader r = (Reader) l.get(0);
					String type = (String) l.get(1);
				%>
				<tr>
					<td colspan="2" class="tb_udRInfo">
						<bean:message key="front.lable.modifyreaderinfo"/>
					</td>
				</tr>
				<tr>
					<td width="106" class="tb_udRnfoBorder">
						<bean:message key="front.lable.bookcardnum"/>
					</td>
					<td width="223" class="tb_udRnfoBorderRight">
						<label>
							<%=r.getIdentiCode()%>
						</label>
						<input type="hidden" name="id" value="<%=r.getId()%>" />
					</td>
				</tr>
				<tr>
					<td width="106" class="tb_udRnfoBorder">
						<bean:message key="front.lable.loginid"/>
					</td>
					<td width="223" class="tb_udRnfoBorderRight">
						<label>
							<%=r.getName()%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.readerpassword"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<input type="password" name="password"
								value="<%=r.getPassword()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.secondpassword"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<input type="password" name="password2"
								value="<%=r.getPassword()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.realname"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%=r.getRealName()%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.sex"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%
								if (r.getSex() == 1) {
									out.println("男");
								} else {
									out.println("女");
								}
							%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.readertype"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%=type%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.cardtype"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%=r.getPapertype()%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.cardnum"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%=r.getPaperNo()%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.phone"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<input type="text" name="tel" value="<%=r.getTel()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.email"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<input type="text" name="email" value="<%=r.getEmail()%>" />
						</label>
					</td>
				</tr>

				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.registertime"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<label>
							<%=r.getRegistTime().toString().substring(0, 10)%>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_udRnfoBorder">
						<bean:message key="front.lable.remark"/>
					</td>
					<td class="tb_udRnfoBorderRight">
						<textarea rows="" cols="" name="description"><%=r.getDescription()%></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="udRnfobg">
						<div align="center">
							<input class="input_udRnfobg" type="submit" name="Submit"
								value="提交" onclick="return check(form)" />
							<input class="input_udRnfobg" " type="reset" name="reset"
								value="重写" />
						</div>
					</td>
				</tr>
			</table>
		</form>