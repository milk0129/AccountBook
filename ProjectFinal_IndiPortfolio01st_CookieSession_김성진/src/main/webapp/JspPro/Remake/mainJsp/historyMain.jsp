<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>가계부 메뉴</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/mainMenu.css">
</head>
<body>
<jsp:include page="mainTop.jsp" />

<h2>가계부 메뉴</h2>
<ul>
    <li><a href="/expense?action=list">📋 지출 내역 보기</a></li>
    <li><a href="/view/historyAdd.jsp">➕ 지출 내역 추가</a></li>
</ul>

<a href="/main">🔙 메인으로</a>

<jsp:include page="mainBottom.jsp" />
</body>
</html>