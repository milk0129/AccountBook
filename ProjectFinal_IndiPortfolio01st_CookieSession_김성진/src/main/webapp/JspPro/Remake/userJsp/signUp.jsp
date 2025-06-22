<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" href="../css/mainMenu.css">
</head>
<body>
<jsp:include page="../mainJsp/mainTop.jsp" />

<h2>회원가입</h2>
<form method="post" action="/user?action=signup">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="userId" required></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="userPw" required></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="userName" required></td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="date" name="userBirth" required></td>
        </tr>
    </table>
    <input type="submit" value="가입하기">
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<jsp:include page="../mainJsp/mainBottom.jsp" />
</body>
</html>