<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Declarações iniciais para a página JSP, como o uso da linguagem Java e o tipo de conteúdo HTML com codificação UTF-8. -->

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Novo Gênero</title>
    </head>
    <body>
        <h1>Novo Gênero</h1>
            <form action="/generos/insert" method="post"> <!-- O formulário envia os dados para a URL /generos/insert via método POST. -->
                <div>
                    <label for="nome">Nome:</label> 
                    <input type="text" name="nome" />  <!-- O campo de entrada para o nome do gênero, associado ao parâmetro nome -->
                </div>
                <br />
                <button type="submit">Salvar</button>
            </form>
    </body>
</html>