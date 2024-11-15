<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Configura a página para usar Java, define o tipo de conteúdo como HTML com codificação UTF-8. -->

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!-- Declara a biblioteca JSTL (Jakarta Standard Tag Library) e define o prefixo "c" para suas tags. -->

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Livros</title>
        <!-- Define o título da página como "Livros". -->
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Importa o CSS do Bootstrap para estilizar a página. -->
    </head>
    <body>
        <%@ include file="../_template/menubar.jsp" %>
        <!-- Inclui o conteúdo do arquivo menubar.jsp, normalmente usado para uma barra de navegação. -->

        <div class="container">
            <h1>Livros</h1>
            <!-- Título principal da página. -->
            <a href="/livros/insert" class="btn btn-primary">Novo Livro</a>
            <!-- Botão para criar um novo livro, redirecionando para a página de inserção. -->

            <table class="table">
                <!-- Cria uma tabela estilizada com o CSS do Bootstrap. -->
                <tr>
                    <th>id</th>
                    <th>titulo</th>
                    <th>genero</th>
                    <th>editora</th>
                    <th>&nbsp;</th>
                    <!-- Cabeçalhos da tabela para id, título, gênero, editora e uma coluna vazia para ações. -->
                </tr>
                <c:forEach var="l" items="${livros}">
                    <!-- Loop sobre a lista de livros (variável "livros") enviada pelo backend. 
                    Cada livro é referenciado pela variável "l". -->
                    <tr>
                        <td>${l.id}</td>
                        <!-- Exibe o ID do livro. -->
                        <td>${l.titulo}</td>
                        <!-- Exibe o título do livro. -->
                        <td>${l.genero.nome}</td>
                        <!-- Exibe o nome do gênero do livro. -->
                        <td>${l.editora.nome}</td>
                        <!-- Exibe o nome da editora do livro. -->
                        <td>
                            <!-- Coluna para ações (editar e remover). -->
                            <a href="/livros/update?id=${l.id}" class="btn btn-warning">Editar</a>
                            <!-- Link para a página de edição do livro, passando o ID como parâmetro. -->
                            <a href="/livros/delete?id=${l.id}" class="btn btn-danger">Remover</a>
                            <!-- Link para excluir o livro, passando o ID como parâmetro. -->
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
