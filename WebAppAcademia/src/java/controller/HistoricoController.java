/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Madru
 */
package controller;

import dao.HistoricoDAO;
import dao.ClienteDAO;
import model.Historico;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "HistoricoController", urlPatterns = {"/historico"})
public class HistoricoController extends HttpServlet {

    private final HistoricoDAO dao = new HistoricoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                request.setAttribute("lista", dao.listar());
                request.getRequestDispatcher("historico/lista.jsp").forward(request, response);
                break;

            case "novo":
                request.setAttribute("clientes", clienteDAO.listar());
                request.getRequestDispatcher("historico/form.jsp").forward(request, response);
                break;

            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Historico h = dao.buscarPorId(id);
                request.setAttribute("historico", h);
                request.setAttribute("clientes", clienteDAO.listar());
                request.getRequestDispatcher("historico/form.jsp").forward(request, response);
                break;

            case "excluir":
                dao.excluir(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("historico?acao=listar");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Historico h = new Historico();

        h.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
        h.setData(Date.valueOf(request.getParameter("data")));
        h.setDescricao(request.getParameter("descricao"));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            dao.inserir(h);
        } else {
            h.setId(Integer.parseInt(id));
            dao.atualizar(h);
        }

        response.sendRedirect("historico?acao=listar");
    }
}
