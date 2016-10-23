<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
   <head>
      <title><bean:message key="front.lable.userread"/></title>
   </head>
   
   <body bgcolor="#6699FF" alink="#660000" vlink="#999999" link="#003300"
      text="#000000" topmargin="0" leftmargin="5" marginheight="0" marginwidth="0">
      <div align="center">
	  <table width="750" cellspacing="0" cellpadding="0" border="0">
         <tr><td width="68%" height="90px" align="right""
					style="background-image: url(../image/3029601.gif)"><a href="reader.do?method=logout"><bean:message key="front.lable.logout"/></a></td></tr>
         <tr>
              <td width="85%">
              <table border=0 cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td style="border: thin outset #E3EEFF;background-color:#E3EEFF"><a href="reader.do?method=showReaderInformation"><bean:message key="front.lable.editUsermessage"/></a>
				</td>
				<td style="border: thin outset #E3EEFF;background-color:#E3EEFF"><a href="reader.do?method=findBorrowedBooks"><bean:message key="front.lable.searchborrowmessage"/></a>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				<tr>
              <td width="85%">
                 <tiles:insert attribute="mainPanel"/>
              </td>
         </tr>
         <tr><td height="38" align="center" style="border: thin outset #E3EEFF;background-color:#E3EEFF">
					<bean:message key="front.lable.copyrightInfo"/>
				</td></tr>
      </table>
      </div>
   </body>
</html>
