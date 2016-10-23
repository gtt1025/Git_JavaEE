<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="library.domain.liberInfo.LiberInfo"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%
	LiberInfo li = (LiberInfo) request.getAttribute("liberInfo");
%>


<html>
	<head>
		<script language="javascript">
		function check(form){
			if (form.liberName.value==""){
				alert("请输入图书馆名称!");form.liberName.focus();return false;
			}
			if (form.curator.value==""){
				alert("请输入馆长名称!");form.curator.focus();return false;
			}	
			if (form.tel.value==""){
				alert("请输入图书馆电话!");form.tel.focus();return false;
			}
			if (form.address.value==""){
				alert("请输入图书馆地址!");form.address.focus();return false;
			}	
			if (form.email.value==""){
				alert("请输入图书馆邮箱地址!");form.email.focus();return false;
			}
			if (form.url.value==""){
				alert("请输入图书馆网址!");form.url.focus();return false;
			}	
			if (form.buildDate.value==""){
				alert("请输入图书馆建立日期!");form.buildDate.focus();return false;
			}
			if (form.description.value==""){
				alert("请输入图书馆简介!");form.description.focus();return false;
			}	
			var temp = document.getElementById("email");
			//对电子邮件的验证
			var emailStr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!emailStr.test(temp.value))
			{
				alert('提示\n\n请输入有效的E_mail！');
				temp.focus();
				return false;
			
			}
			
			var temp = document.getElementById("tel");
			//对电话号码的验证
			var telStr = /^[0-9]*$/;
			if(!telStr.test(temp.value))
			{
				alert('提示\n\n请输入有效的电话号码！');
				temp.focus();
				return false;
			
			}
		}
		function yearList(){
			var d=new Date();
			var t=d.getFullYear();
			yStr="";
			for(var i=1949;i<=t;i++){
				yStr=yStr+"<option value='"+i+(i==<%=li.getBuildDate().getYear()+1900%>?"' selected>":"'>")+i+"</option>";
			}
			return yStr;
		}
		
		function monthList(){
			var d=new Date();
			var t=d.getMonth()+1;
			mStr="";
			for(var i=1;i<=12;i++){
				mStr=mStr+"<option value='"+i+(i==<%=li.getBuildDate().getMonth() + 1%>?"' selected>":"'>")+i+"</option>";
			}
			return mStr;
		}
		
		function dateList(){
			var d=new Date();
			var t=d.getDate();
			dStr="";
			for(var i=1;i<=31;i++){
				dStr=dStr+"<option value='"+i+(i==<%=li.getBuildDate().getDate()%>?"' selected>":"'>")+i+"</option>";
			}
			return dStr;
		}
		
		function setDateValue(name){
			var dValue=document.all[name+"_yy"].value+"-"+document.all[name+"_mm"].value+"-"+document.all[name+"_dd"].value;
			document.all[name].value=dValue;
		}
		
		function showDateSelect(name){
			document.write("<select name='"+name+"_yy' onchange='setDateValue(\""+name+"\"); '>"+yearList()+"</select>");
			document.write("<select name='"+name+"_mm' onchange='setDateValue(\""+name+"\"); '>"+monthList()+"</select>");
			document.write("<select name='"+name+"_dd' onchange='setDateValue(\""+name+"\"); '>"+dateList()+"</select>");
			document.write("<input type='hidden' name='"+name+"' value=''>");
			setDateValue(name);
		}
		</script>
		<title><bean:message key="title.LiberInfoMaintain"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body>		
		<form id="form" name="form" method="post"
			action="sysLiberInfo.do?method=updateLiberInfo">
			<table border="0" cellpadding="0" cellspacing="0" align="center">
				<input type="hidden" name="id" value="<%=li.getId()%>" />
				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.LiberInfoMaintain"/>
					</td>
				</tr>
				<tr>
					<td width="91" class="tb_addbook">
						<bean:message key="tile.lable.LiberName"/>
					</td>
					<td width="202" class="tb_addbookRight">
						<label>
							<input type="text" name="liberName"
								value="<%=li.getLiberName()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.Librarian"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="curator" value="<%=li.getCurator()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberPhone"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="tel" value="<%=li.getTel()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberAddress"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="address" value="<%=li.getAddress()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberEmail"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="email" value="<%=li.getEmail()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberNet"/>
					</td>
					<td class="tb_addbookRight">
						<input type="text" name="url" value="<%=li.getUrl()%>" />
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberFoundDate"/>
					</td>
					<td class="tb_addbookRight">
						<script language="JavaScript">showDateSelect("buildDate");</script>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.LiberSummary"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<textarea name="description" rows="6" cols="17"><%=li.getIntroduce()%></textarea>

						</label>
					</td>
				</tr>
				<tr>
					<td style="border: 1px solid #9DB3C5; color: #000000">
						&nbsp;
					</td>
					<td class="tb_addbookRightS">
						<label>
							<input class="input_bg" type="submit" name="Submit" value="提交"
								onClick="return check(form)" />
							&nbsp;&nbsp;
						</label>
						<label>
						</label>
						<label>
							<input class="input_bg" type="reset" name="Reset" value="重置" />
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
