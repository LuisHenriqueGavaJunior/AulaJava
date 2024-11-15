<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Configura a página para usar Java, define o tipo de conteúdo como HTML com codificação UTF-8. -->

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!-- Declara a biblioteca JSTL (Jakarta Standard Tag Library) e define o prefixo "c" para suas tags. -->

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <!-- Define a codificação de caracteres como UTF-8 para suportar caracteres especiais. -->
        <title>Novo Livro</title>
        <!-- Define o título da página como "Novo Livro". -->
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Importa o CSS do Bootstrap para estilizar a página. -->
    </head>
    <body>
        <div class="container">
            <!-- Cria um contêiner centralizado usando o CSS do Bootstrap. -->
            <h1>Novo Livro</h1>
            <!-- Título principal da página. -->
            <form action="/livros/insert" method="post">
                <!-- Formulário que envia dados para o backend via método POST na URL "/livros/insert". -->
                
                <div class="mb-3">
                    <!-- Grupo de formulário com espaçamento inferior. -->
                    <label class="form-label">Título</label>
                    <!-- Rótulo para o campo de entrada de texto. -->
                    <input type="text" class="form-control" name="titulo" />
                    <!-- Campo de entrada de texto para o título do livro. -->
                </div>

                <div class="mb-3">
                    <!-- Grupo de formulário com espaçamento inferior. -->
                    <label class="form-label">Genero</label>
                    <!-- Rótulo para o seletor de gênero. -->
                    <select name="genero" class="form-select">
                        <!-- Seletor de opções para gêneros. -->
                        <c:forEach var="g" items="${generos}">
                            <!-- Itera sobre a lista de gêneros enviada pelo backend. Cada item é referenciado como "g". -->
                            <option value="${g.id}">${g.nome}</option>
                            <!-- Cria uma opção no seletor, onde o valor é o ID do gênero e o texto é o nome do gênero. -->
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <!-- Grupo de formulário com espaçamento inferior. -->
                    <label class="form-label">Editora</label>
                    <!-- Rótulo para o seletor de editora. -->
                    <select name="editora" class="form-select">
                        <!-- Seletor de opções para editoras. -->
                        <c:forEach var="e" items="${editoras}">
                            <!-- Itera sobre a lista de editoras enviada pelo backend. Cada item é referenciado como "e". -->
                            <option value="${e.id}">${e.nome}</option>
                            <!-- Cria uma opção no seletor, onde o valor é o ID da editora e o texto é o nome da editora. -->
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-success">Salvar</button>
                <!-- Botão para enviar o formulário, estilizado como um botão de sucesso no Bootstrap. -->
            </form>
        </div>
    </body>
</html>
