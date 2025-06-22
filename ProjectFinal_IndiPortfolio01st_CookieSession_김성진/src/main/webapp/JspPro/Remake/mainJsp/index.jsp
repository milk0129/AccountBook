<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/mainMenu.css">
</head>
<body>
<jsp:include page="mainTop.jsp" />

<jsp:include page="outline.jsp" />


<jsp:include page="mainBottom.jsp" />
</body>
</html>
