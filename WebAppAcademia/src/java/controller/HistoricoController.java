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
import dao.AcademiaDAO;

import model.Historico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/historico")
public class HistoricoController extends HttpServlet {

    private final HistoricoDAO dao = new HistoricoDAO();

    private final ClienteDAO clienteDAO =
            new ClienteDAO();

    private final AcademiaDAO academiaDAO =
            new AcademiaDAO();

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

                request.setAttribute("lista",
                        dao.listar());

                request.getRequestDispatcher(
                        "/historico/lista.jsp")
                        .forward(request, response);

                break;

            case "novo":

                request.setAttribute("clientes",
                        clienteDAO.listar());

                request.setAttribute("academias",
                        academiaDAO.listar());

                request.getRequestDispatcher(
                        "/historico/form.jsp")
                        .forward(request, response);

                break;

            case "editar":

                int id = Integer.parseInt(
                        request.getParameter("id"));

                Historico historico =
                        dao.buscarPorId(id);

                request.setAttribute("historico",
                        historico);

                request.setAttribute("clientes",
                        clienteDAO.listar());

                request.setAttribute("academias",
                        academiaDAO.listar());

                request.getRequestDispatcher(
                        "/historico/form.jsp")
                        .forward(request, response);

                break;

            case "excluir":

                dao.excluir(
                        Integer.parseInt(
                                request.getParameter("id")));

                response.sendRedirect(
                        "historico?acao=listar");

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Historico h = new Historico();

        h.setIdCliente(
                Integer.parseInt(
                        request.getParameter("idCliente")));

        h.setIdAcademia(
                Integer.parseInt(
                        request.getParameter("idAcademia")));

        h.setDataCheckin(
                Date.valueOf(
                        request.getParameter("dataCheckin")));

        h.setHoraCheckin(
                Time.valueOf(
                        request.getParameter("horaCheckin")));

        h.setStatusCheckin(
                request.getParameter("statusCheckin"));

        h.setTipoPlano(
                request.getParameter("tipoPlano"));

        h.setObservacao(
                request.getParameter("observacao"));

        h.setOrigemCheckin(
                request.getParameter("origemCheckin"));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {

            dao.inserir(h);

        } else {

            h.setIdHistorico(
                    Integer.parseInt(id));

            dao.atualizar(h);
        }

        response.sendRedirect("historico?acao=listar");
    }
}