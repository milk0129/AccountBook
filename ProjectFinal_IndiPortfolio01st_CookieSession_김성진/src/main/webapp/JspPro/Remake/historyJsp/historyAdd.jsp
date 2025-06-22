<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>지출 추가</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/historyCss.css">
</head>
<body>
<jsp:include page="../mainJsp/mainTop.jsp" />

<div id="historyWrapper">
    <header><h2>지출 내역 추가</h2></header>
    <main>
        <form method="post" action="${pageContext.request.contextPath}/expense?action=add">
            <table>
                <tr>
                    <td>날짜</td>
                    <td><input type="date" name="expDate" required></td>
                </tr>
                <tr>
                    <td>항목</td>
                    <td><input type="text" name="expItem" required></td>
                </tr>
                <tr>
                    <td>금액</td>
                    <td><input type="number" name="expMoney" required></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td><input type="text" name="expCategory"></td>
                </tr>
                <tr>
                    <td>메모</td>
                    <td><textarea name="expMemo"></textarea></td>
                </tr>
            </table>
            <button type="submit">저장</button>
            <button type="reset">초기화</button>
        </form>
        <footer>
            <a href="${pageContext.request.contextPath}/expense?action=list">⏪ 목록으로</a>
        </footer>
    </main>
</div>

<jsp:include page="../mainJsp/mainBottom.jsp" />
</body>

</html>
