<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>지출 수정</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/historyCss.css">
</head>
<body>
<jsp:include page="../mainJsp/mainTop.jsp" />

<h2>지출 내역 수정</h2>
<form method="post" action="/expense?action=update">
    <input type="hidden" name="expId" value="${dto.expId}" />

    <table>
        <tr>
            <td>항목</td>
            <td><input type="text" name="expItem" value="${dto.expItem}" required></td>
        </tr>
        <tr>
            <td>금액</td>
            <td><input type="number" name="expMoney" value="${dto.expMoney}" required></td>
        </tr>
        <tr>
            <td>카테고리</td>
            <td><input type="text" name="expCategory" value="${dto.expCategory}"></td>
        </tr>
        <tr>
            <td>메모</td>
            <td><textarea name="expMemo">${dto.expMemo}</textarea></td>
        </tr>
    </table>
    <input type="submit" value="수정">
    <a href="/expense?action=list">취소</a>
</form>

<jsp:include page="../mainJsp/mainBottom.jsp" />
</body>
</html>