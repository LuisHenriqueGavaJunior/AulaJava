<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Configura a página para usar Java, define o tipo de conteúdo como HTML com codificação UTF-8. -->

<!DOCTYPE html>
<html lang="pt-br">
    <!-- Define o idioma da página como português brasileiro. -->

    <head>
        <meta charset="UTF-8">
        <!-- Define a codificação de caracteres como UTF-8 para suportar caracteres especiais. -->
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Importa o CSS do Bootstrap para estilizar a página. -->
        <title>Document</title>
        <!-- Define o título da página como "Document". -->
    </head>
    <body>
        <div class="container">
            <!-- Cria um contêiner centralizado usando o CSS do Bootstrap. -->
            <h1>Remover Livro</h1>
            <!-- Título principal da página. -->

            <p>
                Tem certeza que deseja remover o livro ${livro.titulo} ?
                <!-- Exibe uma mensagem de confirmação com o título do livro obtido do backend. -->
            </p>

            <form action="/livros/delete" method="post">
                <!-- Formulário que envia os dados para o backend via método POST na URL "/livros/delete". -->
                <input type="hidden" name="id" value="${livro.id}" />
                <!-- Campo oculto que contém o ID do livro a ser removido, enviado ao backend. -->
                <button type="submit" class="btn btn-danger">Remover</button>
                <!-- Botão para enviar o formulário, estilizado como um botão de alerta no Bootstrap. -->
            </form>
        </div>
    </body>
</html>
