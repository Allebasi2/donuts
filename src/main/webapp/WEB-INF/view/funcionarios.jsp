<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap"
	rel="stylesheet">
<title>Donuts - Delícias</title>
<link rel="stylesheet" href="css/funcionarios.css">
</head>
<body>

	<!-- Cabeçalho -->
	<header>
		<div class="conteudo-nav">
			<img class="logo" src="images/donutssssss.png" alt="">
			<div class="search-container">
				<input class="input" type="text" placeholder="Busque o que deseja"
					required>
				<button class="search-button">🔍</button>
			</div>
			<button class="botaoo">
				<a href="#funcionarios">Novo funcionário👨‍💼</a>
			</button>
		</div>
	</header>

	<a class="voltar" href="home"><h2>voltar</h2></a>

	<section id="funcionarios">
		<h1>Gestão de Funcionários</h1>

	<!--	<c:forEach items="${funcionarios}" var="funcionario">


			<a href="funcionarios2?idFuncionario=${funcionario.id}">
				<div class="funcionario-mes">
					<h2>Funcionário do Mês</h2>
					<div class="funcionario-card">
						<img src="images/joao.jpg" alt="Funcionario"
							class="funcionario-imagem">
						<p>
							<strong>${funcionario.nome}</strong> - ${funcionario.cargo}
						</p>
						<p>${funcionario.idade}</p>
						<p>
							<strong></strong> João tem se destacado
							nas vendas e em manter o bom atendimento ao cliente. Ele é um
							grande exemplo para a equipe!
						</p>

					</div>

				</div>
			</a>
		</c:forEach> -->

		<!-- Formulário para Adicionar/Editar Funcionário -->
		
		<div class="formulario-funcionario">
		
			<h3>Adicionar/Editar Funcionário</h3>

			<form method="POST"
				action="${funcionario.id != null ? 'atualizarFuncionario' : 'adicionarFuncionario' }?idFuncionario=${funcionario.id}">

				<input type="hidden" name="id" value="1">
				<!-- Caso seja edição, incluir o ID do funcionário -->

				<label for="nome">Nome Completo</label> 
				<input
					value="${funcionario.nome}" id="nome" name="nome"
					placeholder="Ex: João Silva" required> <label for="cargo">Cargo</label>
				<input value="${funcionario.cargo}" type="text" id="cargo"
					name="cargo" placeholder="Ex: Gerente" required> <label
					for="idade">Idade</label> <input value="${funcionario.idade}"
					type="number" id="idade" name="idade" placeholder="_ _" required>

				<button type="submit">Salvar</button>
			</form>

		</div>

		<!-- Lista de Funcionários Cadastrados -->
		<div class="lista-funcionarios">
			<h3>Funcionários Cadastrados</h3>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Cargo</th>
						<th>Idade</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<!-- Exemplo de funcionário -->
					<c:forEach items="${funcionarios}" var="funcionario">
					<tr>
						<td>${funcionario.id}</td>
						<td>${funcionario.nome}</td>
						<td>${funcionario.cargo}</td>
						<td>${funcionario.idade}</td>
						<td>
						
						<a href ="funcionarios3?idFuncionario=${funcionario.id}">
							<button>Editar</button>
						</a>
						
							<a href ="deletarFuncionario?idFuncionario=${funcionario.id}">
							<button>Excluir</button>
							</a>
							
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

	<!-- Rodapé -->
	<footer class="rodape">
		<p>© 2024 - Todos os direitos reservados.</p>
		<img class="logozinho" alt="donuts" src="images/donutssssss.png" />
	</footer>