<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Academia"%>

<%
    List<Academia> lista = (List<Academia>) request.getAttribute("lista");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Academias</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2>Academias Disponíveis</h2>

        <a href="../historico/lista.jsp"
           class="btn btn-secondary">
            Histórico
        </a>

    </div>

    <div class="row">

        <%
            if (lista != null) {
                for (Academia a : lista) {
        %>

        <div class="col-md-4 mb-4">

            <div class="card shadow h-100">

                <div class="card-body">

                    <h4 class="card-title">
                        <%= a.getNome() %>
                    </h4>

                    <p class="card-text">
                        <strong>Endereço:</strong>
                        <%= a.getEndereco() %>
                    </p>

                    <p class="card-text">
                        <strong>Bairro:</strong>
                        <%= a.getBairro() %>
                    </p>

                    <form method="post" action="../historico">

                        <input type="hidden"
                               name="idAcademia"
                               value="<%= a.getId() %>">

                        <button type="submit"
                                class="btn btn-success w-100">
                            Fazer Check-in
                        </button>

                    </form>

                </div>

            </div>

        </div>

        <%
                }
            }
        %>

    </div>

</div>

</body>
</html>