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
    <h1><%= "Mainz' Craft" %></h1>
    <p>
        <jsp:useBean id="incrementer" scope="application" class="br.ufrj.ic.campominado.MyIncrement"></jsp:useBean>
        <jsp:getProperty name="incrementer" property="x"/>
    </p>
    <p><a onclick="ApiResponse('novo jogo')">Novo Jogo</a></p>
    <p><a onclick="ApiResponse('continuar')">Continuar</a></p>
    <p><a onclick="ApiResponse('dificuldade')">Dificuldade</a></p>
    <p><a onclick="ApiResponse('creditos')">Créditos</a></p>
    <br/>
</div>
<div id="etc" class="main">
    <button style="font-size: 18px;margin-left: -10px;" type="button" onclick="toggleNav()">&#9776</button>
    <button type="button" onclick="loadDoc()">Change Content</button>
    <p id="demo">vamos ver a diferença</p>
    <p id="messenger">A mensagem aparecerá aqui</p>
</div>
</body>
</html>