<%-- 
    Document   : form
    Created on : 30 de mai. de 2026, 17:29:09
    Author     : Madru
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Histórico de Check-in</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">
            <h3>Registro de Check-in</h3>
        </div>

        <div class="card-body">

            <form action="${pageContext.request.contextPath}/historico"
                  method="post">

                <input type="hidden"
                       name="id"
                       value="${historico.idHistorico}">

                <div class="mb-3">
                    <label class="form-label">
                        ID Cliente
                    </label>

                    <input type="number"
                           name="idCliente"
                           class="form-control"
                           value="${historico.idCliente}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        ID Academia
                    </label>

                    <input type="number"
                           name="idAcademia"
                           class="form-control"
                           value="${historico.idAcademia}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Data Check-in
                    </label>

                    <input type="date"
                           name="dataCheckin"
                           class="form-control"
                           value="${historico.dataCheckin}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Hora Check-in
                    </label>

                    <input type="time"
                           name="horaCheckin"
                           class="form-control"
                           value="${historico.horaCheckin}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Status Check-in
                    </label>

                    <input type="text"
                           name="statusCheckin"
                           class="form-control"
                           value="${historico.statusCheckin}">
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Tipo Plano
                    </label>

                    <input type="text"
                           name="tipoPlano"
                           class="form-control"
                           value="${historico.tipoPlano}">
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Origem Check-in
                    </label>

                    <input type="text"
                           name="origemCheckin"
                           class="form-control"
                           value="${historico.origemCheckin}">
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Observação
                    </label>

                    <textarea name="observacao"
                              class="form-control"
                              rows="4">${historico.observacao}</textarea>
                </div>

                <button type="submit"
                        class="btn btn-success">
                    Salvar
                </button>

                <a href="${pageContext.request.contextPath}/historico?acao=listar"
                   class="btn btn-secondary">
                    Voltar
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>