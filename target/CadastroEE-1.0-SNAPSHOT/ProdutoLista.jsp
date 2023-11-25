<%--
  Created by IntelliJ IDEA.
  User: leand
  Date: 23/11/2023
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        List<Produto> produtos =  (List<Produto>) request.getAttribute("produtos");
        %>
<html>
<head>
    <meta charset="utf-8">
    <title>Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Listagem de Produtos</h1>
    <a href="ServletProduto?acao=formIncluir" class="btn btn-primary m-2">Incluir produto</a>
    <table class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preco de Venda</th>
                <th>Opções</th>
            </tr>
        </thead>
        <tbody>
            <%for (int i = 0; i < produtos.size(); i++) {%>
                <tr>
                    <td><%=produtos.get(i).getIdProduto()%></td>
                    <td><%=produtos.get(i).getNome()%></td>
                    <td><%=produtos.get(i).getQuantidade()%></td>
                    <td><%=produtos.get(i).getPrecoVenda()%></td>
                    <td>
                        <a href="ServletProduto?acao=formAlterar&idProduto=<%=produtos.get(i).getIdProduto()%>" class="btn btn-primary btn-sm">Alterar</a>
                        <a href="ServletProduto?acao=excluir&idProduto=<%=produtos.get(i).getIdProduto()%>" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
