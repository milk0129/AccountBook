<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="../css/loginstyle.css">
</head>
<body>
<script src="../jas/theme.js"></script>

<div id="userWrapper">
    <main>
        <header><h2>아이디 찾기</h2></header>

        <section class="container">
            <form method="post" action="/user?action=findId">
                <label for="userName">이름</label>
                <input type="text" id="userName" name="userName" placeholder="이름" required>

                <label for="userBirth">생년월일</label>
                <input type="date" id="userBirth" name="userBirth" required>

                <button type="submit">아이디 찾기</button>
            </form>

            <c:if test="${not empty foundId}">
                <p id="resultMsg">찾은 아이디: ${foundId}</p>
            </c:if>
            <c:if test="${empty foundId and param.action eq 'findId'}">
                <p id="resultMsg">일치하는 회원 정보를 찾을 수 없습니다.</p>
            </c:if>
        </section>

        <footer>
            <p><a href="/login">로그인하기</a></p>
        </footer>
    </main>
</div>
</body>
</html>
