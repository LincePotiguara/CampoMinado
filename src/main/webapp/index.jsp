<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mainz' Craft | Campo Minado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" sizes="any">
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.svg" type="image/svg+xml">
    <script src="index.js"></script>
</head>
<body>
<div id="menu" style="background-color: lightgrey" class="menu-nav-side">
    <h1><%= "MineSweeper" %></h1>
    <p><a onclick="ApiResponse('tamanho', '10x10')">Novo Jogo &#128163;</a></p>
    <p><a onclick="ApiResponse('continuar', 'x', 'x', '99', '99')">Continuar</a></p>
    <!--tamanho redireciona para difficuldade
    <p><a onclick="ApiResponse('tamanho')">Dificuldade</a></p>
    -->
    <p><a onclick="ApiResponse('creditos')">Créditos</a></p>
    <br/>
</div>
<div id="etc" class="main">
    <button style="font-size: 18px;margin-left: -10px;" type="button" onclick="toggleNav()">&#9776</button>
    <p id="messenger">Seja bem vindo ao Campo Minado</p>
</div>
</body>
</html>
