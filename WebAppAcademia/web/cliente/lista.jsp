<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>

<jsp:useBean id="lista" type="java.util.List" scope="request" />

<%
    @SuppressWarnings("unchecked")
    List<Cliente> listaClientes = (List<Cliente>) lista;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2>Clientes</h2>

        <a href="${pageContext.request.contextPath}/cliente?acao=novo"
           class="btn btn-primary">
            Novo Cliente
        </a>

    </div>

    <table class="table table-bordered table-hover bg-white">

        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Status</th>
                <th>Ações</th>
            </tr>
        </thead>

        <tbody>

        <%
            if (listaClientes != null) {

                for (Cliente c : listaClientes) {
        %>

            <tr>

                <td><%= c.getIdCliente() %></td>
                <td><%= c.getNome() %></td>
                <td><%= c.getCpf() %></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getTelefone() %></td>
                <td><%= c.getStatus() %></td>

                <td>

                    <a href="${pageContext.request.contextPath}/cliente?acao=editar&id=<%= c.getIdCliente() %>"
                       class="btn btn-warning btn-sm">
                        Editar
                    </a>

                    <a href="${pageContext.request.contextPath}/cliente?acao=excluir&id=<%= c.getIdCliente() %>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Deseja excluir este cliente?')">
                        Excluir
                    </a>

                </td>

            </tr>

        <%
                }
            }
        %>

        </tbody>

    </table>

</div>

</body>
</html>