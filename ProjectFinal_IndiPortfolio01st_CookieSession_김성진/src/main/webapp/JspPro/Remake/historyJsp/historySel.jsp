<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>지출 내역</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/historyCss.css">
</head>
<body>
<jsp:include page="../mainJsp/mainTop.jsp" />

<h2>지출 내역</h2>
<table border="1">
    <thead>
        <tr>
            <th>날짜</th>
            <th>항목</th>
            <th>금액</th>
            <th>카테고리</th>
            <th>메모</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty expenses}">
                <c:forEach var="e" items="${expenses}">
                    <tr>
                        <td>${e.expDate}</td>
                        <td>${e.expItem}</td>
                        <td>${e.expMoney}</td>
                        <td>${e.expCategory}</td>
                        <td>${e.expMemo}</td>
                        <td><a href="/expense?action=editForm&expId=${e.expId}">수정</a></td>
                        <td><a href="/expense?action=delete&expId=${e.expId}" onclick="return confirm('삭제할까요?')">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr><td colspan="7">내역이 없습니다.</td></tr>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>

<a href="/view/historyAdd.jsp">➕ 새 지출 추가</a>
<jsp:include page="../mainJsp/mainBottom.jsp" />
</body>
</html>
