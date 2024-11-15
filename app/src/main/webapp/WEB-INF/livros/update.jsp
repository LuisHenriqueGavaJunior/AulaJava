<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Configura a página para usar a linguagem Java, define o tipo de conteúdo como HTML com codificação UTF-8 para suporte a caracteres especiais. -->

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!-- Declaração da biblioteca de tags JSP padrão (JSTL - Jakarta Standard Tag Library), usada para lógica como loops e condições no JSP. 
O prefixo "c" será usado para referenciar essas tags. -->

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Livro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Inclui o CSS do Bootstrap para estilizar os componentes da página. -->
    </head>
    <body>
        <div class="container">
            <h1>Editar Livro</h1>
            <!-- Título principal da página. -->

            <form action="/livros/update" method="post">
                <!-- Formulário que envia os dados para o endpoint "/livros/update" via método POST. -->

                <input type="hidden" name="id" value="${livro.id}" />
                <!-- Campo oculto para enviar o ID do livro (usado para identificar qual livro será atualizado). 
                O valor é preenchido dinamicamente com o atributo "id" do objeto "livro". -->

                <div class="mb-3">
                    <label class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${livro.titulo}" />
                    <!-- Campo de entrada para o título do livro. Preenchido automaticamente com o valor atual do atributo "titulo" do objeto "livro". -->
                </div>

                <div class="mb-3">
                    <label class="form-label">Gênero</label>
                    <select name="genero" class="form-select">
                        <!-- Dropdown para seleção do gênero do livro. -->

                        <c:forEach var="g" items="${generos}">
                            <!-- Loop sobre a lista de gêneros disponível (variável "generos"). 
                            Cada item é referenciado pela variável "g". -->
                            <option ${livro.genero.id == g.id ? "selected" : ""} value="${g.id}">
                                ${g.nome}
                            </option>
                            <!-- Cria uma opção para cada gênero. Marca como "selected" se o gênero atual do livro corresponder ao item da lista. -->
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Editora</label>
                    <select name="editora" class="form-select">
                        <!-- Dropdown para seleção da editora do livro. -->

                        <c:forEach var="e" items="${editoras}">
                            <!-- Loop sobre a lista de editoras disponível (variável "editoras"). 
                            Cada item é referenciado pela variável "e". -->
                            <option ${livro.editora.id == e.id ? "selected" : ""} value="${e.id}">
                                ${e.nome}
                            </option>
                            <!-- Cria uma opção para cada editora. Marca como "selected" se a editora atual do livro corresponder ao item da lista. -->
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-success">Salvar</button>
                <!-- Botão para enviar o formulário e salvar as alterações. -->
            </form>
        </div>
    </body>
</html>
