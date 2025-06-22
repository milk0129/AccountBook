<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/loginstyle.css">
</head>
<body>
<jsp:include page="../mainJsp/mainTop.jsp" />

<div id="userWrapper">
    <header><h2>로그인</h2></header>
    <main>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <label for="userId">아이디</label>
            <input type="text" name="userId" id="userId" required>

            <button type="submit">로그인</button>

            <nav>
                <a href="${pageContext.request.contextPath}/user?action=signupForm">회원가입</a> |
                <a href="${pageContext.request.contextPath}/user?action=findIdForm">아이디 찾기</a>
            </nav>
        </form>

        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>
    </main>
</div>

<jsp:include page="../mainJsp/mainBottom.jsp" />
</body>

</html>