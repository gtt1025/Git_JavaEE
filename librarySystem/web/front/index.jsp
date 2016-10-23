<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List,library.domain.book.*"%>
<%@ page import="library.domain.barcode.*"%>
<%@ page import="library.domain.bookType.*"%>
<%@ page import="library.domain.liberInfo.LiberInfo"%>
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
	function getType(){
		DWRMethods.getBookTypes(function(types){
			dwr.util.removeAllOptions("bookTypes");
			dwr.util.addOptions("bookTypes",types);});
	}
	function submitForm(){
		var userName=document.getElementById("name");
		var userPassword=document.getElementById("password");
		if(userName.value==null || userName.value==""){
			alert("帐号不能为空!");
			userName.focus();
			return false;
		}
		if(userPassword.value==null || userPassword.value==""){
			alert("密码不能为空!");
			userPassword.focus();
			return false;
		}
		document.getElementById("readerform").submit();
	}
	
	function disableAll(){
		document.getElementById("date").style.display="none";
		document.getElementById("names").style.display="none";
		document.getElementById("bookType").style.display="none";
		document.getElementById("finder").style.display="none";
	}
	
	function findType(){
	if(document.getElementById("typer").value=="bookName"||document.getElementById("typer").value=="publisher"||document.getElementById("typer").value=="author"){
		document.getElementById("names").style.display="inline";
		document.getElementById("date").style.display="none";
		document.getElementById("bookType").style.display="none";
		document.getElementById("finder").style.display="inline";
	}else 
	if(document.getElementById("typer").value=="booktypeT"){
		document.getElementById("bookType").style.display="inline";
		document.getElementById("date").style.display="none";
		document.getElementById("names").style.display="none";
		document.getElementById("finder").style.display="inline";
	}else
	if(document.getElementById("typer").value=="inTime"){
		document.getElementById("bookType").style.display="none";
		document.getElementById("names").style.display="none";
		document.getElementById("date").style.display="inline";
		document.getElementById("finder").style.display="inline";
	}if(document.getElementById("typer").value=="-1"){
		disableAll();
	}
	}
	
	function getStartYear(){
		var yStr="1900";
		DWREngine.setAsync(false); 
		DWRMethods.getBegin(function(start){
			var d=new Date();
			var t=d.getFullYear();
			yStr="";
			for(var i=start;i<=t;i++){
				yStr=yStr+"<option value='"+i+(i==t?"' selected>":"'>")+i+"</option>";
			}
		});
		DWREngine.setAsync(true); 
		return yStr;
	
	}

	function yearList(start){
		var d=new Date();
		var t=d.getFullYear();
		var yStr="";
		for(var i=start;i<=t;i++){
			yStr=yStr+"<option value='"+i+(i==t?"' selected>":"'>")+i+"</option>";
		}
		return yStr;
	}

	function monthList(){
		var d=new Date();
		var t=d.getMonth()+1;
		mStr="";
		for(var i=1;i<=12;i++){
			mStr=mStr+"<option value='"+i+(i==t?"' selected>":"'>")+i+"</option>";
		}
		return mStr;
	}

	function dateList(){
		var d=new Date();
		var t=d.getDate();
		dStr="";
		for(var i=1;i<=31;i++){
			dStr=dStr+"<option value='"+i+(i==t?"' selected>":"'>")+i+"</option>";
		}
		return dStr;
	}

	function setDateValue(name){
		var dValue=document.all[name+"_yy"].value+"-"+document.all[name+"_mm"].value+"-"+document.all[name+"_dd"].value;
		document.all[name].value=dValue;
	}

	function showDateSelect(name){
		var start=getStartYear();
		document.write("<select name='"+name+"_yy' onchange='setDateValue(\""+name+"\"); '>"+start+"</select>");
		document.write("<select name='"+name+"_mm' onchange='setDateValue(\""+name+"\"); '>"+monthList()+"</select>");
		document.write("<select name='"+name+"_dd' onchange='setDateValue(\""+name+"\"); '>"+dateList()+"</select>");
		document.write("<input type='hidden' name='"+name+"' value=''>");
		setDateValue(name);
	}

  </script>
		<style type="text/css">
.index_main {
	background-color: #990000;
	border-left: 1px solid #FF66FF;
	border-top: 1px solid #FF66FF;
	color: #FFFFFF;
	padding-top: 3px;
	padding-left: 3px;
	font-weight: bold;
}

.index_tbmain {
	background-color: #FFFBD6;
	border-left: 1px solid #FF66FF;
	border-top: 1px solid #FF66FF;
	color: #000000;
}
</style>
		<title><bean:message key="front.lable.frontpage"/></title>
	</head>
	<body style="font: 12px;" onLoad="disableAll(),getType();">
		<!---图片区域-->

		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="0"
			style="border: 1px solid #83ACC0; background-color: #F8FCFD;">
			<tr>
				<td width="20%">
					&nbsp;
				</td>
				<td width="68%" height="90px"
					style="background-image: url(../image/3029601.gif)"></td>
				<td width="1%" valign="top"></td>
				<td width="11%" align="center">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="19">
								<li></li>
							</td>
							<td>
								<a href="mailto:zhanghairui_90@126.com" title="有什么意见请联系我们"><bean:message key="front.lable.relasus"/></a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="5px"></td>
			</tr>
		</table>
		
		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="195" height="265" valign="top">
					<!--主体区域-->
					<form action="reader.do?method=searchBook" method="post">
						<table width="222" height="178" id="tt2" cellpadding="0"
							cellspacing="0">
							<tr align="center">
								<td width="212" height="29" bgcolor="#015890">
									<strong><font color="#FFFFFF"><bean:message key="front.lable.searchInfo"/></font> </strong>
								</td>
							</tr>
							<tr align="center">
								<td style="border: 1px solid #CCCCCC" height="133"
									bgcolor="#ffffff">
									<bean:message key="front.lable.class"/>
									<select name="typer" onChange="findType();">
										<option value="-1">
											<bean:message key="front.lable.select"/>
										</option>
										<option value="author">
											<bean:message key="front.lable.author"/>
										</option>
										<option value="publisher">
											<bean:message key="front.lable.publish"/>
										</option>
										<option value="bookName">
											<bean:message key="front.lable.bookname"/>
										</option>
										<option value="inTime">
											<bean:message key="front.lable.ondate"/>
										</option>
										<option value="booktypeT">
											<bean:message key="front.lable.type"/>
										</option>
									</select>
									<br>
									<br>
									<div id="date">
										<bean:message key="front.lable.datechange"/>
										<br />
										<script language="JavaScript">showDateSelect("begin");</script>
										<br />
										<script language="JavaScript">showDateSelect("end");</script>
									</div>
									<div id="bookType">
										<bean:message key="front.lable.selecttype"/>
										<select name="bookTypes" id="bookTypes">
										</select>
									</div>
									<div id="names">
										<bean:message key="front.lable.name"/>
										<input type="text" name="theName" size="18" />
									</div>
									<br>
									<br>
									<div id="finder">
										<input type="submit" name="findhouse" value="搜索" />
									</div>
								</td>
							</tr>
						</table>
					</form>
					<form id="readerform" name="readerform" method="post"
						action="reader.do?method=readerLogin">
						<table height="144" id="tt1"
							style="background-color: #ffffff; border: 1px solid #CCCCCC">
							<tr align="center">
								<th width="198" height="31" bgcolor="#015890" colspan=2>
									<strong><font color="#FFFFFF"><bean:message key="front.lable.userlogin"/></font> </strong>
								</th>
							</tr>
							<tr align="center">
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
							<tr align="center">
								<td width="42" height="47">
									<div align="center">
										<bean:message key="front.lable.id"/>
									</div>
								</td>
								<td width="168">
									<input type="text" name="name" />
								</td>
							</tr>
							<tr align="center">
								<td height="49">
									<bean:message key="front.lable.passwors"/>
								</td>
								<td>
									<input type="password" name="password" />
								</td>
							</tr>
							<tr align="center">
								<td height="46"></td>
								<td>
									<input type="button" name="login" value="登陆"
										onclick="submitForm()" />
									<input type="reset" name="reset" value="清空" />
								</td>
							</tr>
						</table>
					</form>

				</td>
				<td valign="top">
					<!--主页右部分 -->
					<table border=0 align="center" cellpadding="0" cellspacing="0">
						<%
							List list = (List) request.getAttribute("search");
							if (list != null) {
						%>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.bookname"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.author"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.publish"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.booktype"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.ondate"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.price"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.bookid"/>
							</td>
							<td class="index_main">
								<bean:message key="front.lable.borrowcase"/>
							</td>
						</tr>
						<%
							for (Object o : (List) list) {
									List ends = (List) o;
									Book b = (Book) ends.get(0);
									Barcode barcode = (Barcode) ends.get(1);
									int may = Integer.parseInt(ends.get(2).toString());
									BookType bt = (BookType) ends.get(3);
						%>
						<tr onMouseOut="this.style.backgroundColor='#FFFBD6'"
							onMouseOver="this.style.backgroundColor='#FFF7E7'">
							<td class="index_tbmain"><%=b.getBookName()%></td>
							<td class="index_tbmain"><%=b.getAuthor()%></td>
							<td class="index_tbmain"><%=b.getPublisher()%></td>
							<td class="index_tbmain"><%=bt.getName()%></td>
							<td class="index_tbmain"><%=b.getInTime().toString().substring(0, 10)%></td>
							<td class="index_tbmain"><%=b.getPrice()%></td>
							<td class="index_tbmain"><%=barcode.getBarcode()%></td>
							<td class="index_tbmain">
								<%
									if (may == 1) {
												out.println("可借");
											} else {
												out.println("已借出");
											}
								%>
							</td>
						</tr>
						<%
							}
							} else if (request.getAttribute("liberInfo") != null) {

								LiberInfo li = (LiberInfo) request.getAttribute("liberInfo");
						%>
						<tr>

						</tr>

					</table>

					<table width="420" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="120" class="index_main">
								<bean:message key="front.lable.libname"/>
							</td>
							<td width="304" class="index_tbmain"><%=li.getLiberName()%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libmanager"/>
							</td>
							<td class="index_tbmain"><%=li.getCurator()%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libtel"/>
							</td>
							<td class="index_tbmain"><%=li.getTel()%></td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libaddress"/>
							</td>
							<td class="index_tbmain"><%=li.getAddress()%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libemail"/>
							</td>
							<td class="index_tbmain"><%=li.getEmail()%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libaddress"/>
							</td>
							<td class="index_tbmain"><%=li.getUrl()%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libcondate"/>
							</td>
							<td class="index_tbmain"><%=li.getBuildDate().toString().substring(0, 10)%>
							</td>
						</tr>
						<tr>
							<td class="index_main">
								<bean:message key="front.lable.libintro"/>
							</td>
							<td class="index_tbmain"><%=li.getIntroduce()%>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				</td>
			</tr>
		</table>
		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td
					style="border-left: 1px solid #83ACC0; border-top: 1px solid #83ACC0; border-right: 1px solid #83ACC0; padding-left: 5px; padding-top: 3px; padding-bottom: 2px; border-bottom: 1px solid #83ACC0">
					<bean:message key="front.lable.copyright"/>
				</td>
			</tr>
			<tr>
				<td height="38" align="center" style="border: 1px solid #83ACC0">
					<bean:message key="front.lable.copyrightInfo"/>
				</td>
			</tr>
		</table>
		<br>
		<br>
	</body>
</html>
