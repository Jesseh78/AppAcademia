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
        String sql = "INSERT INTO cliente (nome, cpf, email, senha, telefone, data_nascimento, sexo, endereco, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCpf());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getSenha());
                stmt.setString(5, c.getTelefone());
                if (c.getDataNascimento() != null) {
                    stmt.setDate(6, new java.sql.Date(c.getDataNascimento().getTime()));
                } else {
                    stmt.setDate(6, null);
                }
                stmt.setString(7, c.getSexo());
                stmt.setString(8, c.getEndereco());
                stmt.setString(9, c.getStatus());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e);
        }
    }

    public void atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, senha=?, telefone=?, data_nascimento=?, sexo=?, endereco=?, status=? WHERE id_cliente=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCpf());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getSenha());
                stmt.setString(5, c.getTelefone());
                if (c.getDataNascimento() != null) {
                    stmt.setDate(6, new java.sql.Date(c.getDataNascimento().getTime()));
                } else {
                    stmt.setDate(6, null);
                }
                stmt.setString(7, c.getSexo());
                stmt.setString(8, c.getEndereco());
                stmt.setString(9, c.getStatus());
                stmt.setInt(10, c.getIdCliente());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e);
        }
    }

    public void excluir(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idCliente);
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e);
        }
    }

    public Cliente buscarPorId(int idCliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente=?";
        Cliente c = new Cliente();

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idCliente);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        c.setIdCliente(rs.getInt("id_cliente"));
                        c.setNome(rs.getString("nome"));
                        c.setCpf(rs.getString("cpf"));
                        c.setEmail(rs.getString("email"));
                        c.setSenha(rs.getString("senha"));
                        c.setTelefone(rs.getString("telefone"));
                        c.setDataNascimento(rs.getDate("data_nascimento"));
                        c.setSexo(rs.getString("sexo"));
                        c.setEndereco(rs.getString("endereco"));
                        c.setStatus(rs.getString("status"));
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
                    c.setIdCliente(rs.getInt("id_cliente"));
                    c.setNome(rs.getString("nome"));
                    c.setCpf(rs.getString("cpf"));
                    c.setEmail(rs.getString("email"));
                    c.setSenha(rs.getString("senha"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setDataNascimento(rs.getDate("data_nascimento"));
                    c.setSexo(rs.getString("sexo"));
                    c.setEndereco(rs.getString("endereco"));
                    c.setStatus(rs.getString("status"));

                    lista.add(c);
                }

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e);
        }

        return lista;
    }
}