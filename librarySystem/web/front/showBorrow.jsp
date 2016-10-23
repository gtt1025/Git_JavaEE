<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="library.domain.borrow.Borrow"%>
<table border=0 cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td>
				
				</td>
			</tr>
            <tr>
            <td>
            <br/>
            <br/>
            </td>
            </tr>
			<tr>
				<td colspan="6" class="tb_udRInfo">
					<bean:message key="front.lable.bookanddeadline"/>
				</td>
			</tr>
			<tr>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.bookname"/>
				</td>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.bookid"/>
				</td>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.borrowtime"/>
				</td>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.deadline"/>
				</td>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.remainday"/>
				</td>
				<td class="borrow_tbmain">
					<bean:message key="front.lable.renew"/>
				</td>
			</tr>
			<%
				List list = (List) request.getAttribute("borrowedBooksList");
				for (Object l : list) {
					List end = (List) l;
					Borrow borrow = (Borrow) end.get(0);
			%>
			<tr>
				<td class="borrow-tbmainO"><%=borrow.getBarcodeT().getBookT().getBookName()%></td>
				<td class="borrow-tbmainO"><%=borrow.getBarcodeT().getBarcode()%></td>
				<td class="borrow-tbmainO"><%=borrow.getBorrowTime().toString().substring(0, 10)%></td>
				<td class="borrow-tbmainO"><%=borrow.getForceBackTime().toString().substring(0, 10)%></td>
				<td class="borrow-tbmainO"><%=end.get(1)%></td>

				<td style="border: 1px solid #9DC3DC; color: #000000">
					&nbsp;
					<%
						if (borrow.getRenew() == 0) {
					%><a href="reader.do?method=renew&borrowId=<%=borrow.getId()%>"><bean:message key="front.lable.renew"/></a>
					<%
						}
					%>
				</td>
			</tr>
			<%
				}
			%>
		</table>