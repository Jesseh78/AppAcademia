/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Madru
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Academia;
import util.ConectaDB;




public class AcademiaDAO {

    public void inserir(Academia a){
        String sql = "INSERT INTO academia (nome, endereco, telefone) VALUES (?, ?, ?)";

        try (Connection con = ConectaDB.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setString(3, a.getTelefone());
            stmt.execute();

        } catch (Exception e) {}
    }

    public List<Academia> listar(){
        List<Academia> lista = new ArrayList<>();
        String sql = "SELECT * FROM academia";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()){
                Academia a = new Academia();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                lista.add(a);
            }

        } catch(Exception e){}

        return lista;
    }

    public Academia buscar(int id){
        String sql = "SELECT * FROM academia WHERE id=?";
        Academia a = new Academia();

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
            }

        } catch(Exception e){}

        return a;
    }

    public void atualizar(Academia a){
        String sql = "UPDATE academia SET nome=?, endereco=?, telefone=? WHERE id=?";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setString(3, a.getTelefone());
            stmt.setInt(4, a.getId());
            stmt.execute();

        } catch(Exception e){}
    }

    public void excluir(int id){
        String sql = "DELETE FROM academia WHERE id=?";

        try (Connection con = ConectaDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.execute();

        } catch(Exception e){}
    }
}