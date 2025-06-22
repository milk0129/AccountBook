<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 포털</title>
    <link rel="stylesheet" href="../css/mainMenu.css">
</head>
<body>
<jsp:include page="mainTop.jsp" />

<h2>로그인 포털</h2>
<ul>
    <li><a href="/login">로그인 하기</a></li>
    <li><a href="/user?action=signupForm">회원가입</a></li>
    <li><a href="/user?action=findIdForm">아이디 찾기</a></li>
    <li><a href="/index.jsp">처음으로</a></li>
</ul>

<jsp:include page="mainBottom.jsp" />
</body>
</html>
