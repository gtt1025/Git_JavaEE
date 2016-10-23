<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="library.domain.operator.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
	<head>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/engine.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/util.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/interface/DWRMethods.js"></script>
		<script type="text/javascript" language="JavaScript">
		function getTypes(){
			DWRMethods.getBookTypes(function(types){
			dwr.util.removeAllOptions("type");
			dwr.util.addOptions("type",types);});
		}
		
		function check(form){
			if(form.bookname.value==""){
				alert("书名不能为空！");
				form.bookname.focus();return false;
			}
			if(form.author.value==""){
				alert("作者不能为空！");
				form.author.focus();return false;
			}
			if(form.publisher.value==""){
				alert("出版社不能为空！");
				form.publisher.focus();return false;
			}
			
			
			if(form.num.value<=0){
				alert("数量必需大于0！");
				form.num.focus();return false;
			}
			
			if(form.price.value==""){
				alert("价格不能为空！");
				form.price.focus();return false;
			}
			
			var temp = document.getElementById("price");
			//对价格的验证
			var priceStr = /^([1-9]+[0-9]*)+\.+[0-9]{1,2}$/;
			if(!priceStr.test(temp.value))
			{
				alert('提示\n\n价格的格式为：\n89.5\n89.00！');
				temp.focus();
				return false;
			}
			
			var temp = document.getElementById("num");
			//对数量的验证
			var numStr = /^[1-9]+[0-9]*$/;
			if(!numStr.test(temp.value))
			{
				alert('提示\n\n请输入正确的数量');
				temp.focus();
				return false;
			}
			
		}
		</script>
		<title><bean:message key="title.addbook"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />

	</head>

	<body onload="getTypes();">	
		<form id="form" name="form" method="post"
			action="bookInfo.do?method=newBook">
			<table width="371" border="0" height="300" cellpadding="0"
				cellspacing="0" align="center">
				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="title.addbook"/>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook" width="98">
						<bean:message key="tile.lable.BookName"/>
					</td>
					<td class="tb_addbookRight" width="267">
						<label>
							<input type="text" name="bookname" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.author"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="author" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.publisher"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="publisher" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.price"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="price" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.kind"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<select name="type">
							</select>
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.number"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="num" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.operation"/>
					</td>
					<%
						Operator o = (Operator) session.getAttribute("operator");
					%>
					<td class="tb_addbookRight">
						<label>
							<select name="operator">
								<option value="<%=o.getId()%>"><%=o.getName()%></option>
							</select>
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

								<input class="input_bg" type="reset" name="reset" value="重置" />
							</div>
						</label>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
