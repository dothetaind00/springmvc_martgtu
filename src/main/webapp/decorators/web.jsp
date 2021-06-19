<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><sitemesh:write property='title' /></title>

<link rel="stylesheet" href="<c:url value='/template/web/font-awesome-4.7.0/css/font-awesome.min.css'/>" type="text/css">
<link rel="stylesheet" href="<c:url value='/template/web/scss/layout.css'/>" type="text/css">
<link rel="stylesheet" href="<c:url value='/template/web/scss/style.css'/>" type="text/css">
<link rel="stylesheet" href="<c:url value='/template/web/scss/responsive.css'/>" type="text/css">

</head>
<body>
	<%@ include file="/common/web/header.jsp" %>
	
	<sitemesh:write property='body' />
	
	<%@ include file="/common/web/footer.jsp" %>
	
	<!-- script -->
    <script src="<c:url value='/template/web/js/responsive.js'/>"></script>
</body>
</html>