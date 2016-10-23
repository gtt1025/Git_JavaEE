<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="library.domain.barcode.Barcode"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/engine.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/util.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dwr/interface/DWRMethods.js"></script>
		<script language="javascript">
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
		}
		</script>
		<title><bean:message key="title.UpdateBookInfo"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body onload="getTypes()">
		<form id="form" name="form" method="post"
			action="bookInfo.do?method=editBook">
			<%
				Barcode bc = (Barcode) request.getAttribute("bc");
			%><input type="hidden" name="bid" value="<%=bc.getBookT().getId()%>" />
			<table width="381" border="0" cellpadding="0" cellspacing="0"
				align="center">

				<tr>
					<td colspan="2" class="tb_addbookBgImage">
						<bean:message key="tile.lable.EditBookInfo"/>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook" width="98">
						<bean:message key="tile.lable.BookName"/>
					</td>
					<td width="267" class="tb_addbookRight">
						<label>
							<input type="text" name="bookname"
								value="<%=bc.getBookT().getBookName()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.author"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="author"
								value="<%=bc.getBookT().getAuthor()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.publisher"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="publisher"
								value="<%=bc.getBookT().getPublisher()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.price"/>
					</td>
					<td class="tb_addbookRight">
						<label>
							<input type="text" name="price"
								value="<%=bc.getBookT().getPrice()%>" />
						</label>
					</td>
				</tr>
				<tr>
					<td class="tb_addbook">
						<bean:message key="tile.lable.kind"/>
					</td>
					<td class="tb_addbookRight">
						<select name="type">
						</select>
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
