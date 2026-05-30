/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDAO;
import model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        List<Cliente> clientes = dao.listar();

        for (Cliente c : clientes) {

            if (c.getEmail().equals(email)
                    && c.getSenha().equals(senha)) {

                HttpSession session =
                        request.getSession();

                session.setAttribute("usuario", c);

                response.sendRedirect(
                        request.getContextPath()
                                + "/cliente?acao=listar");

                return;
            }
        }

        response.sendRedirect(
                request.getContextPath()
                        + "/login/login.jsp?erro=1");
    }
}