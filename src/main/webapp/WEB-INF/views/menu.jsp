<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:forEach var="entry" items="${menu}">
	<a href="${entry.key}">${entry.value}</a>
</c:forEach>
