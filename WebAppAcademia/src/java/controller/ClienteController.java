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
import dao.AcademiaDAO;
import model.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClienteController", urlPatterns = {"/cliente"})
public class ClienteController extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();
    private final AcademiaDAO academiaDAO = new AcademiaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                request.setAttribute("lista", dao.listar());
                request.getRequestDispatcher("cliente/lista.jsp").forward(request, response);
                break;

            case "novo":
                request.setAttribute("academias", academiaDAO.listar());
                request.getRequestDispatcher("cliente/form.jsp").forward(request, response);
                break;

            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Cliente c = dao.buscarPorId(id);
                request.setAttribute("cliente", c);
                request.setAttribute("academias", academiaDAO.listar());
                request.getRequestDispatcher("cliente/form.jsp").forward(request, response);
                break;

            case "excluir":
                dao.excluir(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("cliente?acao=listar");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente c = new Cliente();

        c.setNome(request.getParameter("nome"));
        c.setEmail(request.getParameter("email"));
        c.setTelefone(request.getParameter("telefone"));
        c.setIdAcademia(Integer.parseInt(request.getParameter("idAcademia")));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            dao.inserir(c);
        } else {
            c.setId(Integer.parseInt(id));
            dao.atualizar(c);
        }

        response.sendRedirect("cliente?acao=listar");
    }
}