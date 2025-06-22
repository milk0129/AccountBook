<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/JspPro/Remake/css/mainMenu.css">

<div id="mainWrapper">
  <header>
    <nav>
      <img src="${pageContext.request.contextPath}/JspPro/Remake/img/logo.jpg">
      <ul>
        <li class="li_menu">
          <a href="${pageContext.request.contextPath}/JspPro/Remake/mainJsp/index.jsp">홈</a>
        </li>
        <li class="li_menu">
          <a href="${pageContext.request.contextPath}/login">로그인</a>
        </li>
        <li class="li_menu">
          <a href="${pageContext.request.contextPath}/JspPro/Remake/index.jsp?category=signUp">회원가입</a>
        </li>
        <li class="li_menu">
          <button class="theme-toggle" onclick="toggleTheme()">🌓 테마</button>
        </li>
      </ul>
    </nav>
  </header>
  <div class="li_outline"></div>
</div>
