<%-- 
    Document   : form
    Created on : 30 de mai. de 2026, 17:28:45
    Author     : Madru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Academia</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <h2>Cadastro de Academia</h2>

    <form action="${pageContext.request.contextPath}/academia"
          method="post">

        <input type="hidden"
               name="id"
               value="${academia.idAcademia}">

        <input class="form-control mb-2"
               name="nome"
               placeholder="Nome">

        <input class="form-control mb-2"
               name="cnpj"
               placeholder="CNPJ">

        <input class="form-control mb-2"
               name="telefone"
               placeholder="Telefone">

        <input class="form-control mb-2"
               name="email"
               placeholder="Email">

        <input class="form-control mb-2"
               name="endereco"
               placeholder="Endereço">

        <input class="form-control mb-2"
               name="bairro"
               placeholder="Bairro">

        <input class="form-control mb-2"
               name="cidade"
               placeholder="Cidade">

        <input class="form-control mb-2"
               name="estado"
               placeholder="Estado">

        <input class="form-control mb-2"
               name="horarioFuncionamento"
               placeholder="Horário">

        <button class="btn btn-success">
            Salvar
        </button>

    </form>

</div>

</body>
</html>