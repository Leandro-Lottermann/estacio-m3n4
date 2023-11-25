<%--
  Created by IntelliJ IDEA.
  User: leand
  Date: 24/11/2023
  Time: 08:48
  To change this template use File | Settings | File Templates.--%>
<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        Produto produto =  (Produto) request.getAttribute("produto");
        String valor = "alterar";
        String nome = "";
        String quantidade = "";
        String precoVenda = "";
        String idProduto = "";

        if(produto == null) {
            valor = "incluir";
        } else {
            nome = produto.getNome();
            quantidade = Integer.toString(produto.getQuantidade());
            precoVenda = Float.toString(produto.getPrecoVenda());
            idProduto = Integer.toString(produto.getIdProduto());
        }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Dados do Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
</head>
<body class="container">
    <h1>Dados do produto</h1>
    <form name="formProduto" action="ServletProduto" class="form">
        <input type="hidden" name="acao" id="acao" value="<%=valor%>" >
        <input type="hidden" name="idProduto" id="idProduto" value="<%=idProduto%>" >

        <div class="mb-3">
            <label for="nome" class="form-label"> Nome: </label>
                <input type="text" name="nome" id="nome" value="<%=nome%>" class="form-control">

        </div>


        <div class="mb-3">
            <label for="quantidade" class="form-label"> Quantidade: </label>
            <input type="text" name="quantidade" id="quantidade" value="<%=quantidade%>" class="form-control">

        </div>



        <div class="mb-3">
            <label for="precoVenda" class="form-label"> Preço de Venda: </label>
                <input type="text" name="precoVenda" id="precoVenda" value="<%=precoVenda%>" class="form-control">

        </div>


        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
