/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Madru
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Academia;
import util.ConectaDB;

public class AcademiaDAO {

    public void inserir(Academia a) {

        String sql = "INSERT INTO academia "
                + "(nome, cnpj, telefone, email, endereco, bairro, cidade, estado, horario_funcionamento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCnpj());
            stmt.setString(3, a.getTelefone());
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getEndereco());
            stmt.setString(6, a.getBairro());
            stmt.setString(7, a.getCidade());
            stmt.setString(8, a.getEstado());
            stmt.setString(9, a.getHorarioFuncionamento());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir academia: " + e.getMessage());
        }
    }

    public List<Academia> listar() {

        List<Academia> lista = new ArrayList<>();

        String sql = "SELECT * FROM academia";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Academia a = new Academia();

                a.setIdAcademia(rs.getInt("id_academia"));
                a.setNome(rs.getString("nome"));
                a.setCnpj(rs.getString("cnpj"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                a.setEndereco(rs.getString("endereco"));
                a.setBairro(rs.getString("bairro"));
                a.setCidade(rs.getString("cidade"));
                a.setEstado(rs.getString("estado"));
                a.setHorarioFuncionamento(
                        rs.getString("horario_funcionamento"));

                lista.add(a);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar academia: " + e.getMessage());
        }

        return lista;
    }

    public Academia buscarPorId(int id) {

        String sql = "SELECT * FROM academia WHERE id_academia=?";

        Academia a = null;

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                a = new Academia();

                a.setIdAcademia(rs.getInt("id_academia"));
                a.setNome(rs.getString("nome"));
                a.setCnpj(rs.getString("cnpj"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                a.setEndereco(rs.getString("endereco"));
                a.setBairro(rs.getString("bairro"));
                a.setCidade(rs.getString("cidade"));
                a.setEstado(rs.getString("estado"));
                a.setHorarioFuncionamento(
                        rs.getString("horario_funcionamento"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar academia: " + e.getMessage());
        }

        return a;
    }

    public void atualizar(Academia a) {

        String sql = "UPDATE academia SET "
                + "nome=?, "
                + "cnpj=?, "
                + "telefone=?, "
                + "email=?, "
                + "endereco=?, "
                + "bairro=?, "
                + "cidade=?, "
                + "estado=?, "
                + "horario_funcionamento=? "
                + "WHERE id_academia=?";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCnpj());
            stmt.setString(3, a.getTelefone());
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getEndereco());
            stmt.setString(6, a.getBairro());
            stmt.setString(7, a.getCidade());
            stmt.setString(8, a.getEstado());
            stmt.setString(9, a.getHorarioFuncionamento());
            stmt.setInt(10, a.getIdAcademia());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar academia: " + e.getMessage());
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM academia WHERE id_academia=?";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao excluir academia: " + e.getMessage());
        }
    }
}