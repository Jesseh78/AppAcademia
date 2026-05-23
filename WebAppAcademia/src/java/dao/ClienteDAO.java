/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Madru
 */
package dao;

import model.Cliente;
import util.ConectaDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Connection con;

    public ClienteDAO() {
        con = ConectaDB.getConnection();
    }

    public void inserir(Cliente c) {
        String sql = "INSERT INTO cliente (nome, email, telefone, id_academia) VALUES (?, ?, ?, ?)";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getEmail());
                stmt.setString(3, c.getTelefone());
                stmt.setInt(4, c.getIdAcademia());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e);
        }
    }

    public void atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, email=?, telefone=?, id_academia=? WHERE id=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getEmail());
                stmt.setString(3, c.getTelefone());
                stmt.setInt(4, c.getIdAcademia());
                stmt.setInt(5, c.getId());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e);
        }
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id=?";
        Cliente c = new Cliente();

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        c.setId(rs.getInt("id"));
                        c.setNome(rs.getString("nome"));
                        c.setEmail(rs.getString("email"));
                        c.setTelefone(rs.getString("telefone"));
                        c.setIdAcademia(rs.getInt("id_academia"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e);
        }

        return c;
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setEmail(rs.getString("email"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setIdAcademia(rs.getInt("id_academia"));
                    
                    lista.add(c);
                }
                
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e);
        }

        return lista;
    }
}