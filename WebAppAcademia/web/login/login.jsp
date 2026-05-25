<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">

    <div class="row justify-content-center">

        <div class="col-md-4">

            <div class="card mt-5 shadow">

                <div class="card-body">

                    <h2 class="text-center mb-4">
                        Login
                    </h2>

                    <form method="post" action="../login">

                        <div class="mb-3">
                            <label class="form-label">
                                E-mail
                            </label>

                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">
                                Senha
                            </label>

                            <input type="password"
                                   name="senha"
                                   class="form-control"
                                   required>
                        </div>

                        <button type="submit"
                                class="btn btn-primary w-100">
                            Entrar
                        </button>

                    </form>

                    <div class="text-center mt-3">

                        <a href="../cliente/form.jsp">
                            Criar conta
                        </a>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>