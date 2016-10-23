<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="library.domain.borrow.Borrow"%>
<html>
	<head>
		<title><bean:message key="front.title.readerborrowbook"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<tiles:insert page="frontLayout.jsp" flush="true">         
        <tiles:put name="mainPanel" value="showBorrow.jsp"></tiles:put>     
    </tiles:insert>
	</body>
</html>
