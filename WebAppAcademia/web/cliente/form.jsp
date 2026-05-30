<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Academia"%>
<%@page import="java.util.List"%>

<jsp:useBean id="cliente" type="model.Cliente" scope="request" />
<jsp:useBean id="academias" type="java.util.List" scope="request" />

<%
    @SuppressWarnings("unchecked")
    List<Academia> academiasList = (List<Academia>) academias;
    boolean editando = cliente != null;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar Cliente" : "Cadastrar Cliente" %></title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <h2 class="mb-4"><%= editando ? "Editar Cliente" : "Cadastrar Cliente" %></h2>

    <form method="post" action="../cliente">

        <% if (editando) { %>
        <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>">
        <% } %>

        <div class="mb-3">
            <label class="form-label" for="nome">Nome</label>
            <input type="text" id="nome" name="nome" class="form-control"
                   value="<%= editando ? cliente.getNome() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="cpf">CPF</label>
            <input type="text" id="cpf" name="cpf" class="form-control"
                   value="<%= editando ? cliente.getCpf() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="email">E-mail</label>
            <input type="email" id="email" name="email" class="form-control"
                   value="<%= editando ? cliente.getEmail() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="senha">Senha</label>
            <input type="password" id="senha" name="senha" class="form-control"
                   value="<%= editando ? cliente.getSenha() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="telefone">Telefone</label>
            <input type="text" id="telefone" name="telefone" class="form-control"
                   value="<%= editando ? cliente.getTelefone() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="dataNascimento">Data de Nascimento</label>
            <input type="date" id="dataNascimento" name="dataNascimento" class="form-control"
                   value="<%= editando && cliente.getDataNascimento() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(cliente.getDataNascimento()) : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label" for="sexo">Sexo</label>
            <input type="text" id="sexo" name="sexo" class="form-control"
                   value="<%= editando ? cliente.getSexo() : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label" for="endereco">Endereco</label>
            <input type="text" id="endereco" name="endereco" class="form-control"
                   value="<%= editando ? cliente.getEndereco() : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label" for="status">Status</label>
            <input type="text" id="status" name="status" class="form-control"
                   value="<%= editando ? cliente.getStatus() : "" %>">
        </div>

        <button type="submit" class="btn btn-primary">
            <%= editando ? "Salvar Alteracoes" : "Cadastrar" %>
        </button>

        <a href="../cliente?acao=listar" class="btn btn-secondary">Voltar</a>

    </form>

</div>

</body>
</html>