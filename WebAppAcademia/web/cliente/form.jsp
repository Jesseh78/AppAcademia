<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cliente"%>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    boolean editando = (cliente != null);

    String dataNascimento = "";

    if (editando) {
        try {
            if (cliente.getDataNascimento() != null) {
                dataNascimento = cliente.getDataNascimento().toString();
            }
        } catch (Exception e) {
            dataNascimento = "";
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar Cliente" : "Cadastrar Cliente" %></title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">
            <h3>
                <%= editando ? "Editar Cliente" : "Cadastrar Cliente" %>
            </h3>
        </div>

        <div class="card-body">

            <form method="post"
                  action="${pageContext.request.contextPath}/cliente">

                <% if (editando) { %>
                    <input type="hidden"
                           name="id"
                           value="<%= cliente.getIdCliente() %>">
                <% } %>

                <div class="mb-3">
                    <label class="form-label">Nome</label>

                    <input type="text"
                           name="nome"
                           class="form-control"
                           value="<%= editando ? cliente.getNome() : "" %>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">CPF</label>

                    <input type="text"
                           name="cpf"
                           class="form-control"
                           value="<%= editando ? cliente.getCpf() : "" %>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">E-mail</label>

                    <input type="email"
                           name="email"
                           class="form-control"
                           value="<%= editando ? cliente.getEmail() : "" %>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Senha</label>

                    <input type="password"
                           name="senha"
                           class="form-control"
                           value="<%= editando ? cliente.getSenha() : "" %>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Telefone</label>

                    <input type="text"
                           name="telefone"
                           class="form-control"
                           value="<%= editando ? cliente.getTelefone() : "" %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Data de Nascimento</label>

                    <input type="date"
                           name="dataNascimento"
                           class="form-control"
                           value="<%= dataNascimento %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Sexo</label>

                    <select name="sexo" class="form-select">

                        <option value="Masculino"
                            <%= editando && "Masculino".equals(cliente.getSexo()) ? "selected" : "" %>>
                            Masculino
                        </option>

                        <option value="Feminino"
                            <%= editando && "Feminino".equals(cliente.getSexo()) ? "selected" : "" %>>
                            Feminino
                        </option>

                        <option value="Outro"
                            <%= editando && "Outro".equals(cliente.getSexo()) ? "selected" : "" %>>
                            Outro
                        </option>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Endereço</label>

                    <input type="text"
                           name="endereco"
                           class="form-control"
                           value="<%= editando ? cliente.getEndereco() : "" %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Status</label>

                    <select name="status" class="form-select">

                        <option value="Ativo"
                            <%= editando && "Ativo".equals(cliente.getStatus()) ? "selected" : "" %>>
                            Ativo
                        </option>

                        <option value="Inativo"
                            <%= editando && "Inativo".equals(cliente.getStatus()) ? "selected" : "" %>>
                            Inativo
                        </option>

                    </select>
                </div>

                <button type="submit"
                        class="btn btn-success">
                    <%= editando ? "Atualizar" : "Cadastrar" %>
                </button>

                <a href="${pageContext.request.contextPath}/cliente?acao=listar"
                   class="btn btn-secondary">
                    Voltar
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>