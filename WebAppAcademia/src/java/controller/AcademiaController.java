/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AcademiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Academia;

/**
 *
 * @author Madru
 */
@WebServlet("/academia")
public class AcademiaController extends HttpServlet {

    AcademiaDAO dao = new AcademiaDAO();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Academia> lista = dao.listar();
            req.setAttribute("lista", lista);
            req.getRequestDispatcher("/academia/lista.jsp").forward(req, resp);
        } catch (ServletException | IOException  e) {
            throw new ServletException(e);
        }
    }

    protected void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Academia a = new Academia();
        a.setNome(req.getParameter("nome"));
        a.setEndereco(req.getParameter("endereco"));
        a.setTelefone(req.getParameter("telefone"));

        try {
            dao.inserir(a);
            resp.sendRedirect("academia");
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
