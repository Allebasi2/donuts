<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Visualizar Donuts</title>

    <link rel="stylesheet" href="css/donuts.css" />
    
  </head>
  <body>
    <header>
      <div class="conteudo-nav">
          <img class="logo" src="images/donutssssss.png" alt="">
          <input class="input" type="text" placeholder="Busque o nome do Donuts" required>
          <button ><a href="form"></a>Novo Donuts</button>
          
      </div>
      </header>
 

    <section class="conteudo-pizza">
      <div class="container-titulo">
        <h1><a href="home"> Voltar</a></h1>
      </div>

      <div class="container-conteudo-pizza">
        <div class="item-conteudo-pizza">
            <img alt="Imagem Donuts" src="images/essapodeser.jpg" />
          </div>


          <div class="item-conteudo-pizza">
            <div class="titulo-conteudo">
              <h1>${donuts.nome}</h1>
            </div>
    
            <div class="item-descricao-pizza">
              <p>
                ${donuts.descricao}
              </p>
            </div>
    
            <div class="item-pizza-preco">
                <h1>${donuts.preco}</h1>
            </div>

				<a href ="form?idDonuts=${donuts.id}">
              <button class="button" type="button">Editar Donuts</button>
            </a>
            
            	<a href ="deletarDonuts?idDonuts=${donuts.id}">
              <button class="button" type="button">Deletar Prato</button>
            </a>
            
          </div>
      </div>
    </section>

    <footer class="rodape">
      <div class="item-rodape">
        <img class="logozinho" alt="Logo" src="images/donutssssss.png" />
      </div>
      <div class="item-rodape">
        <p>© 2024 - Todos os direitos reservados.</p>
      </div>
    </footer>
  </body>
</html>