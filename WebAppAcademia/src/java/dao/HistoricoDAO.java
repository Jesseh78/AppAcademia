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
        String sql = "INSERT INTO historico (id_cliente, id_academia, data_checkin, hora_checkin, status_checkin, tipo_plano, observacao, origem_checkin, data_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, h.getIdCliente());
                stmt.setInt(2, h.getIdAcademia());
                if (h.getDataCheckin() != null) {
                    stmt.setDate(3, new java.sql.Date(h.getDataCheckin().getTime()));
                } else {
                    stmt.setDate(3, null);
                }
                stmt.setString(4, h.getHoraCheckin());
                stmt.setString(5, h.getStatusCheckin());
                stmt.setString(6, h.getTipoPlano());
                stmt.setString(7, h.getObservacao());
                stmt.setString(8, h.getOrigemCheckin());
                if (h.getDataRegistro() != null) {
                    stmt.setDate(9, new java.sql.Date(h.getDataRegistro().getTime()));
                } else {
                    stmt.setDate(9, null);
                }
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir historico: " + e);
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
                        h.setIdHistorico(rs.getInt("id_historico"));
                        h.setIdCliente(rs.getInt("id_cliente"));
                        h.setIdAcademia(rs.getInt("id_academia"));
                        h.setDataCheckin(rs.getDate("data_checkin"));
                        h.setHoraCheckin(rs.getString("hora_checkin"));
                        h.setStatusCheckin(rs.getString("status_checkin"));
                        h.setTipoPlano(rs.getString("tipo_plano"));
                        h.setObservacao(rs.getString("observacao"));
                        h.setOrigemCheckin(rs.getString("origem_checkin"));
                        h.setDataRegistro(rs.getDate("data_registro"));

                        lista.add(h);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar historico: " + e);
        }

        return lista;
    }

    public List<Historico> listar() {
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT * FROM historico";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Historico h = new Historico();
                    h.setIdHistorico(rs.getInt("id_historico"));
                    h.setIdCliente(rs.getInt("id_cliente"));
                    h.setIdAcademia(rs.getInt("id_academia"));
                    h.setDataCheckin(rs.getDate("data_checkin"));
                    h.setHoraCheckin(rs.getString("hora_checkin"));
                    h.setStatusCheckin(rs.getString("status_checkin"));
                    h.setTipoPlano(rs.getString("tipo_plano"));
                    h.setObservacao(rs.getString("observacao"));
                    h.setOrigemCheckin(rs.getString("origem_checkin"));
                    h.setDataRegistro(rs.getDate("data_registro"));
                    lista.add(h);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar historico: " + e);
        }

        return lista;
    }

    public Historico buscarPorId(int idHistorico) {
        String sql = "SELECT * FROM historico WHERE id_historico=?";
        Historico h = new Historico();

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idHistorico);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        h.setIdHistorico(rs.getInt("id_historico"));
                        h.setIdCliente(rs.getInt("id_cliente"));
                        h.setIdAcademia(rs.getInt("id_academia"));
                        h.setDataCheckin(rs.getDate("data_checkin"));
                        h.setHoraCheckin(rs.getString("hora_checkin"));
                        h.setStatusCheckin(rs.getString("status_checkin"));
                        h.setTipoPlano(rs.getString("tipo_plano"));
                        h.setObservacao(rs.getString("observacao"));
                        h.setOrigemCheckin(rs.getString("origem_checkin"));
                        h.setDataRegistro(rs.getDate("data_registro"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar historico: " + e);
        }

        return h;
    }

    public void excluir(int idHistorico) {
        String sql = "DELETE FROM historico WHERE id_historico=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idHistorico);
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir historico: " + e);
        }
    }

    public void atualizar(Historico h) {
        String sql = "UPDATE historico SET id_cliente=?, id_academia=?, data_checkin=?, hora_checkin=?, status_checkin=?, tipo_plano=?, observacao=?, origem_checkin=?, data_registro=? WHERE id_historico=?";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, h.getIdCliente());
                stmt.setInt(2, h.getIdAcademia());
                if (h.getDataCheckin() != null) {
                    stmt.setDate(3, new java.sql.Date(h.getDataCheckin().getTime()));
                } else {
                    stmt.setDate(3, null);
                }
                stmt.setString(4, h.getHoraCheckin());
                stmt.setString(5, h.getStatusCheckin());
                stmt.setString(6, h.getTipoPlano());
                stmt.setString(7, h.getObservacao());
                stmt.setString(8, h.getOrigemCheckin());
                if (h.getDataRegistro() != null) {
                    stmt.setDate(9, new java.sql.Date(h.getDataRegistro().getTime()));
                } else {
                    stmt.setDate(9, null);
                }
                stmt.setInt(10, h.getIdHistorico());
                stmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar historico: " + e);
        }
    }
}