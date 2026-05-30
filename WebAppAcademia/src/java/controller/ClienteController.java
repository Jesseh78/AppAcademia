/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Madru
 */
package controller;

import dao.ClienteDAO;
import model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/cliente")
public class ClienteController extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();

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

                request.getRequestDispatcher("/cliente/lista.jsp")
                        .forward(request, response);

                break;

            case "novo":

                request.getRequestDispatcher("/cliente/form.jsp")
                        .forward(request, response);

                break;

            case "editar":

                int id = Integer.parseInt(
                        request.getParameter("id"));

                Cliente cliente = dao.buscarPorId(id);

                request.setAttribute("cliente", cliente);

                request.getRequestDispatcher("/cliente/form.jsp")
                        .forward(request, response);

                break;

            case "excluir":

                dao.excluir(
                        Integer.parseInt(
                                request.getParameter("id")));

                response.sendRedirect("cliente?acao=listar");

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Cliente c = new Cliente();

        c.setNome(request.getParameter("nome"));
        c.setCpf(request.getParameter("cpf"));
        c.setEmail(request.getParameter("email"));
        c.setSenha(request.getParameter("senha"));
        c.setTelefone(request.getParameter("telefone"));

        c.setDataNascimento(
                Date.valueOf(
                        request.getParameter("dataNascimento")));

        c.setSexo(request.getParameter("sexo"));
        c.setEndereco(request.getParameter("endereco"));
        c.setStatus(request.getParameter("status"));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {

            dao.inserir(c);

        } else {

            c.setIdCliente(Integer.parseInt(id));

            dao.atualizar(c);
        }

        response.sendRedirect("cliente?acao=listar");
    }
}