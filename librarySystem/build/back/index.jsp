<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title><bean:message key="title.libermanagesystem"/></title>


</head>

<frameset rows="85,*" cols="*" frameborder="yes" border="1" framespacing="0">
  <frame  src="top.jsp" name="topFrame" scrolling="No" noresize="noresize"   id="topFrame"  title="topFrame" />
  <frameset cols="200,*" frameborder="yes" border="1" framespacing="0">
    <frame   src="left.jsp" name="leftFrame" scrolling="Yes"  noresize="noresize"  id="leftFrame" title="leftFrame" />
    <frame src="main.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>
<body>
</body>
</noframes></html>
