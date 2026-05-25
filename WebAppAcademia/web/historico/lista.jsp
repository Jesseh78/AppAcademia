<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Historico"%>

<%
    List<Historico> lista = (List<Historico>) request.getAttribute("lista");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Histórico de Check-ins</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2>Histórico de Check-ins</h2>

        <a href="../academia/lista.jsp"
           class="btn btn-secondary">
            Academias
        </a>

    </div>

    <table class="table table-bordered table-hover bg-white">

        <thead class="table-dark">

        <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Academia</th>
            <th>Data</th>
        </tr>

        </thead>

        <tbody>

        <%
            if (lista != null) {
                for (Historico h : lista) {
        %>

        <tr>

            <td><%= h.getId() %></td>

            <td><%= h.getNomeCliente() %></td>

            <td><%= h.getNomeAcademia() %></td>

            <td><%= h.getDataCheckin() %></td>

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