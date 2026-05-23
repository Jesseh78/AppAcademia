/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Madru
 */
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int idAcademia;

    public Cliente(){}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public int getIdAcademia() { return idAcademia; }
    public void setIdAcademia(int idAcademia) { this.idAcademia = idAcademia; }
}