<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap" rel="stylesheet">
    <title>	Home - Delicias</title>
    <link rel="stylesheet" href="css/home.css">
  </head>
  <body>


<header>
  
<div class="conteudo-nav">
  
    <img class="logo" src="images/donutssssss.png" alt="">
    <div class="search-container">
      <input class="input" type="text" placeholder="Busque o que deseja" required>
      <button class="search-button">🔍</button>
  </div>
    <button class="botaoo" ><a href="form">Novo Donuts</a></button>
    <button class="botaoo" ><a href="funcionarios3">👨‍💼 Funcionários</a></button>
</div>
</header>

<div class="texto-img"> 
        <h2>Sabores inigualáveis</h2>
        <p>Sinta o cuidado do preparo com ingredientes selecionados</p>
    </div>

    
      <div class="derretendo-texto">
        <h1>DONUTS</h1>
      </div>

      
      <div class="items-pizzas">
        
        <c:forEach items="${donuts}" var="donuts">
        <a href="donuts?idDonuts=${donuts.id}">
        <div class="pizza">
          <img class="imagens-donuts" src="images/donutzinho.avif" alt="Donuts" />
          <h2>${donuts.nome}</h2>
          <p>${donuts.descricao}</p>
          <h1>${donuts.preco}</h1>
        </div></a>
        </c:forEach>
      
      </div>
    </section>

    <footer class="rodape">
      <p>© 2024 - Todos os direitos reservados.</p>
      <img class="logozinho" alt="donuts" src="images/donutssssss.png" />
    </footer>
    
  </body>
</html>