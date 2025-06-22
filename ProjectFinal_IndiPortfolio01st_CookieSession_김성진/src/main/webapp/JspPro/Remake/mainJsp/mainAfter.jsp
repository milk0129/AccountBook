<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/mainMenu.css">
</head>
<body>
<jsp:include page="mainTop.jsp" />

<h2>환영합니다, <c:out value="${sessionScope.userName}"/> 님!</h2>
<div id="mainWrapper">

<ul>
    <li><a href="/expense?action=list">📋 지출 내역 보기</a></li>
    <li><a href="/view/historyAdd.jsp">➕ 지출 내역 추가</a></li>
    <li><a href="/logout.jsp">🚪 로그아웃</a></li>
</ul>
<jsp:include page="mainBottom.jsp" />
</div>
</body>
</html>
