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
    <button type="button" onclick="loadDoc()">Change Content</button>
    <p id="demo">vamos ver a diferença</p>
    <p id="messenger"><div style="text-align: center;font-size: 30px;font-weight: 900;">Seja bem vindo ao Campo Minado</div><br><br>
        <div style="text-align: center;font-size: 25px; font-weight: 600;">Instruções</div><br><br>
        <div style="text-align: center;font-size: 20px; font-weight: 600;">Selecione Novo Jogo para começar a jogar</div><br>
        <div style="text-align: center;font-size: 20px; font-weight: 600;">Escolha entre 3 tamanhos de tabuleiro</div><br>
        <div style="text-align: center;font-size: 20px">Pequeno (10 x 10)  </div><br>
        <div style="text-align: center;font-size: 20px">Médio (15 x 15) </div><br>
        <div style="text-align: center;font-size: 20px">Grande: (20 x 20) </div><br><br>
        <div style="text-align: center;font-size: 20px;font-weight: 600;">Escolha também o nível de dificuldade</div><br>
        <div style="text-align: center;font-size: 20px">Fácil: 10% das casas são ocupadas por bombas </div><br>
        <div style="text-align: center;font-size: 20px">Difícil: 25% das casas são ocupadas por bombas</div><br><br>
        <div style="text-align: center;font-size: 20px;font-weight: 600;">Clique na casa que deseja revelar</div><br>
        <div style="text-align: center;font-size: 20px;">O número revelado indica a quantidade de bombas adjacentes aquela casa</div><br></p>
</div>

</body>
</html>
