/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Madru
 */
package dao;

import model.Historico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaDB;

public class HistoricoDAO {

    Connection con;

    public HistoricoDAO() {
        con = ConectaDB.getConnection();
    }

    public void inserir(Historico h) {
        String sql = "INSERT INTO historico (id_cliente, data, descricao) VALUES (?, ?, ?)";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, h.getIdCliente());
                stmt.setDate(2, (Date) h.getData());
                stmt.setString(3, h.getDescricao());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir histórico: " + e);
        }
    }

    public List<Historico> listarPorCliente(int idCliente) {
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT * FROM historico WHERE id_cliente=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idCliente);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Historico h = new Historico();
                        h.setId(rs.getInt("id"));
                        h.setIdCliente(rs.getInt("id_cliente"));
                        h.setData(rs.getDate("data"));
                        h.setDescricao(rs.getString("descricao"));
                        
                        lista.add(h);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar histórico: " + e);
        }

        return lista;
    }

    public Object listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Historico buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void excluir(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void atualizar(Historico h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}