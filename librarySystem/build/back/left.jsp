<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="library.domain.operator.Operator"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
	<head>
		<title><bean:message key="title.menumanage"/></title>
	</head>
	<body bgcolor="#F2F7FB">
		<script language="javascript" src="tree/tree.js"></script>
		<script language="javascript">
		document.body.onselectstart = new Function('return false;');
		<%Operator o = (Operator) session.getAttribute("operator");	%>
		    addnode('<B>图书馆管理系统</B>');
		<%if(o.getBook()==1){%>
		    addnode('*图书管理');
		    addnode('-*图书信息管理');
		    addnode('--维护图书信息', '<%=request.getContextPath()%>/back/bookInfo.do?method=findAllBook', 'mainFrame');
		    addnode('--添加图书信息', '<%=request.getContextPath()%>/back/addBook.jsp', 'mainFrame');
		    addnode('-*图书分类管理');
		    addnode('--维护图书分类', '<%=request.getContextPath()%>/back/booktype.do?method=findBookType', 'mainFrame');
		    addnode('--添加图书分类', '<%=request.getContextPath()%>/back/addBookType.jsp', 'mainFrame');
		<%}
		if(o.getReader()==1){
		%>
		
		    addnode('*读者管理');
		    addnode('-*读者信息管理');
		    addnode('--维护读者信息', '<%=request.getContextPath()%>/back/readerInfo.do?method=findReader', 'mainFrame');
		    addnode('--添加读者信息', '<%=request.getContextPath()%>/back/addReader.jsp', 'mainFrame');
		
		    addnode('-*读者类型管理');
		    addnode('--维护读者类型', '<%=request.getContextPath()%>/back/readerType.do?method=findReaderType', 'mainFrame');
		    addnode('--添加读者类型', '<%=request.getContextPath()%>/back/addReaderType.jsp','mainFrame');
		<%}
		if(o.getBorrow()==1){
		%>  
		    addnode('*借还管理');
		    addnode('-*图书借阅管理');
		    addnode('--图书借阅', '<%=request.getContextPath()%>/back/borrowBook.jsp', 'mainFrame');
		    addnode('--图书归还', '<%=request.getContextPath()%>/back/giveBackBook.jsp', 'mainFrame');
		    addnode('--查询借阅历史记录', '<%=request.getContextPath()%>/back/borrow.do?method=historyBorrowed', 'mainFrame');
		    addnode('--到期提醒', '<%=request.getContextPath()%>/back/borrow.do?method=warningBack', 'mainFrame');
		<%}
		if(o.getSystem()==1){
		%>  
		    addnode('*系统管理');
		    addnode('-*图书馆信息管理');
		    addnode('--维护图书馆信息', '<%=request.getContextPath()%>/back/sysLiberInfo.do?method=showLiberInfo', 'mainFrame');
		    
		    addnode('-*管理员信息管理');
		    addnode('--维护管理员信息', '<%=request.getContextPath()%>/back/sysOperator.do?method=findOperatorInfo', 'mainFrame');
		    addnode('--添加管理员信息', '<%=request.getContextPath()%>/back/addOperator.jsp', 'mainFrame');
		<%}
		%>
		createtree();
		</script>
	</body>
</html>
