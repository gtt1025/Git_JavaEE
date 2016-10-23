<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="library.domain.reader.Reader"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="front.title.modifyreaderinfo"/></title>
		<link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<div align="center">
	<tiles:insert page="frontLayout.jsp" flush="true">         
        <tiles:put name="mainPanel" value="showReader.jsp"></tiles:put>
    </tiles:insert>
      </div>
	</body>
</html>
