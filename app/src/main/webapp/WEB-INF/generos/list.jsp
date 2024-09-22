<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <!-- Declarações iniciais para a página JSP, como o uso da linguagem Java e o tipo de conteúdo HTML com codificação UTF-8. -->
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- Importa a biblioteca de tags JSP (JSTL) para usar expressões como loops (<c:forEach>). -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gêneros</title>
</head>
<body>
    <h1>Gêneros</h1>
    <table>
        <tr>
            <th>id</th>
            <th>nome</th>
        </tr>
        <c:forEach var="g" items="${generos}">
            <tr>
                <td>${g.id}</td>
                <td>${g.nome}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<!-- Cabeçalhos (<th>): Define as colunas "id" e "nome" da tabela.
    Iteração com JSTL (<c:forEach>): A tag JSTL (<c:forEach>) percorre a lista de gêneros, armazenada na variável ${generos}.
    Para cada gênero na lista, cria-se uma linha na tabela (<tr>), onde:
    ${g.id}: Exibe o ID do gênero.
    ${g.nome}: Exibe o nome do gênero. -->