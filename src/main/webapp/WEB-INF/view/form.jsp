<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Form - Donuts</title>
    <link rel="stylesheet" href="css/form.css">
  </head>
  <body>
    <header>
      <div class="navegação">
            <img class="logo" alt="logo" src="images/donutssssss.png" />
            <div class="search-container">
              <input class="input" type="text" placeholder="Busque o que deseja" required>
              <button class="search-button">🔍</button>
          </div>
      
        <div class="item-nav">
          <a href="form">
            <button class="botaoo" ><a href="funcionarios"> Novo Funcionário👨‍💼</a></button>
        </div>
      </div>
    </header>


    <div class="slide-de-fotos">
      <div class="slides">
        <div class="slide">
          <img src="images/donutttts111.jpg" alt="Slide 1" class="slide-img">
        </div>
        <div class="slide">
          <img src="images/donuts2.jpg" alt="Slide 2" class="slide-img">
        </div>
        <div class="slide">
          <img src="images/donuts3.jpg" alt="Slide 3" class="slide-img">
        </div>
      </div>
    </div>


        <section class="conteudo-donuts">
          <div class="container-titulo">
            <h1><a href="home">Voltar</a></h1>
          </div>
        
          <div class="conteudo-donuts">
            <h1>Adicionar Donuts</h1>

            <form method="POST" action="${donuts.id != null ? 'atualizarDonuts' : 'adicionarDonuts' }?idDonuts=${donuts.id}">
            <div class="form-donuts">
              <div class="campo-imagem">
                <p>Imagem do Donuts</p>
                <input class="custom-file-input" type="file" />
              </div>
              <div class="campo-nome">
                <p>Nome</p>
                <input value="${donuts.nome}" type="text" name="nome" />
              </div>
              <div class="campo-preco">
                <p>Preço</p>
                <input value="${donuts.preco}" type="text" name="preco" placeholder="R$ 00,00" />
              </div>
              <div>
                <label>Tamanho</label>
                <select name="tamanho" >
                  <option value="Pequeno">Pequeno</option>
                  <option value="Medio">Médio</option>
                  <option value="Grande">Grande</option>
                </select>
              </div>
            </div>
            <div class="campo-descricao">
              <p>Descrição</p>
              <input value="${donuts.descricao}" name="descricao" type="message" name="Descricao" id="">
            </div>
            <div class="botao-enviar">
              
       			<button type="submit">Salvar alterações</button>
            </div>
            </form>
          </div>
          
        </section>
        

    <footer class="rodape">
        <img class="logozinho" alt="logozinho" src="images/donutssssss.png" />
        <p>© 2024 - Todos os direitos reservados.</p>
    </footer>
  </body>
</html>