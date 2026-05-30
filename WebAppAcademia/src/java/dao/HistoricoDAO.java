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
import util.ConectaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    private final Connection con;

    public HistoricoDAO() {
        con = ConectaDB.getConnection();
    }

    public void inserir(Historico h) {

        String sql =
                "INSERT INTO historico "
                + "(id_cliente, id_academia, data_checkin, "
                + "hora_checkin, status_checkin, tipo_plano, "
                + "observacao, origem_checkin) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, h.getIdCliente());
            stmt.setInt(2, h.getIdAcademia());
            stmt.setDate(3, h.getDataCheckin());
            stmt.setTime(4, h.getHoraCheckin());
            stmt.setString(5, h.getStatusCheckin());
            stmt.setString(6, h.getTipoPlano());
            stmt.setString(7, h.getObservacao());
            stmt.setString(8, h.getOrigemCheckin());

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao inserir histórico: "
                    + e.getMessage());
        }
    }

    public void atualizar(Historico h) {

        String sql =
                "UPDATE historico SET "
                + "id_cliente=?, "
                + "id_academia=?, "
                + "data_checkin=?, "
                + "hora_checkin=?, "
                + "status_checkin=?, "
                + "tipo_plano=?, "
                + "observacao=?, "
                + "origem_checkin=? "
                + "WHERE id_historico=?";

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, h.getIdCliente());
            stmt.setInt(2, h.getIdAcademia());
            stmt.setDate(3, h.getDataCheckin());
            stmt.setTime(4, h.getHoraCheckin());
            stmt.setString(5, h.getStatusCheckin());
            stmt.setString(6, h.getTipoPlano());
            stmt.setString(7, h.getObservacao());
            stmt.setString(8, h.getOrigemCheckin());
            stmt.setInt(9, h.getIdHistorico());

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao atualizar histórico: "
                    + e.getMessage());
        }
    }

    public void excluir(int idHistorico) {

        String sql =
                "DELETE FROM historico "
                + "WHERE id_historico=?";

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, idHistorico);

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao excluir histórico: "
                    + e.getMessage());
        }
    }

    public Historico buscarPorId(int idHistorico) {

        String sql =
                "SELECT * FROM historico "
                + "WHERE id_historico=?";

        Historico h = null;

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, idHistorico);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                h = new Historico();

                h.setIdHistorico(
                        rs.getInt("id_historico"));

                h.setIdCliente(
                        rs.getInt("id_cliente"));

                h.setIdAcademia(
                        rs.getInt("id_academia"));

                h.setDataCheckin(
                        rs.getDate("data_checkin"));

                h.setHoraCheckin(
                        rs.getTime("hora_checkin"));

                h.setStatusCheckin(
                        rs.getString("status_checkin"));

                h.setTipoPlano(
                        rs.getString("tipo_plano"));

                h.setObservacao(
                        rs.getString("observacao"));

                h.setOrigemCheckin(
                        rs.getString("origem_checkin"));

                h.setDataRegistro(
                        rs.getTimestamp("data_registro"));
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao buscar histórico: "
                    + e.getMessage());
        }

        return h;
    }

    public List<Historico> listar() {

        List<Historico> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM historico";

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while (rs.next()) {

                Historico h =
                        new Historico();

                h.setIdHistorico(
                        rs.getInt("id_historico"));

                h.setIdCliente(
                        rs.getInt("id_cliente"));

                h.setIdAcademia(
                        rs.getInt("id_academia"));

                h.setDataCheckin(
                        rs.getDate("data_checkin"));

                h.setHoraCheckin(
                        rs.getTime("hora_checkin"));

                h.setStatusCheckin(
                        rs.getString("status_checkin"));

                h.setTipoPlano(
                        rs.getString("tipo_plano"));

                h.setObservacao(
                        rs.getString("observacao"));

                h.setOrigemCheckin(
                        rs.getString("origem_checkin"));

                h.setDataRegistro(
                        rs.getTimestamp("data_registro"));

                lista.add(h);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao listar histórico: "
                    + e.getMessage());
        }

        return lista;
    }

    public List<Historico> listarPorCliente(
            int idCliente) {

        List<Historico> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM historico "
                + "WHERE id_cliente=?";

        try {

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, idCliente);

            ResultSet rs =
                    stmt.executeQuery();

            while (rs.next()) {

                Historico h =
                        new Historico();

                h.setIdHistorico(
                        rs.getInt("id_historico"));

                h.setIdCliente(
                        rs.getInt("id_cliente"));

                h.setIdAcademia(
                        rs.getInt("id_academia"));

                h.setDataCheckin(
                        rs.getDate("data_checkin"));

                h.setHoraCheckin(
                        rs.getTime("hora_checkin"));

                h.setStatusCheckin(
                        rs.getString("status_checkin"));

                h.setTipoPlano(
                        rs.getString("tipo_plano"));

                h.setObservacao(
                        rs.getString("observacao"));

                h.setOrigemCheckin(
                        rs.getString("origem_checkin"));

                h.setDataRegistro(
                        rs.getTimestamp("data_registro"));

                lista.add(h);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao listar histórico: "
                    + e.getMessage());
        }

        return lista;
    }
}