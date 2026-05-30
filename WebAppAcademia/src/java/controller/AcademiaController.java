/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AcademiaDAO;
import model.Academia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/academia")
public class AcademiaController extends HttpServlet {

    private final AcademiaDAO dao = new AcademiaDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            acao = "listar";
        }

        switch (acao) {

            case "listar":

                request.setAttribute("lista", dao.listar());

                request.getRequestDispatcher("/academia/lista.jsp")
                        .forward(request, response);

                break;

            case "novo":

                request.getRequestDispatcher("/academia/form.jsp")
                        .forward(request, response);

                break;

            case "editar":

                int id = Integer.parseInt(
                        request.getParameter("id"));

                Academia academia = dao.buscarPorId(id);

                request.setAttribute("academia", academia);

                request.getRequestDispatcher("/academia/form.jsp")
                        .forward(request, response);

                break;

            case "excluir":

                dao.excluir(
                        Integer.parseInt(
                                request.getParameter("id")));

                response.sendRedirect("academia?acao=listar");

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Academia a = new Academia();

        a.setNome(request.getParameter("nome"));
        a.setCnpj(request.getParameter("cnpj"));
        a.setTelefone(request.getParameter("telefone"));
        a.setEmail(request.getParameter("email"));
        a.setEndereco(request.getParameter("endereco"));
        a.setBairro(request.getParameter("bairro"));
        a.setCidade(request.getParameter("cidade"));
        a.setEstado(request.getParameter("estado"));

        a.setHorarioFuncionamento(
                request.getParameter("horarioFuncionamento"));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {

            dao.inserir(a);

        } else {

            a.setIdAcademia(Integer.parseInt(id));

            dao.atualizar(a);
        }

        response.sendRedirect("academia?acao=listar");
    }
}