/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Madru
 */

public class Historico {
    private int idHistorico;
    private int idCliente;
    private int idAcademia;
    private java.util.Date dataCheckin;
    private String horaCheckin;
    private String statusCheckin;
    private String tipoPlano;
    private String observacao;
    private String origemCheckin;
    private java.util.Date dataRegistro;

    public Historico(){}

    public int getIdHistorico() { return idHistorico; }
    public void setIdHistorico(int idHistorico) { this.idHistorico = idHistorico; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdAcademia() { return idAcademia; }
    public void setIdAcademia(int idAcademia) { this.idAcademia = idAcademia; }

    public java.util.Date getDataCheckin() { return dataCheckin; }
    public void setDataCheckin(java.util.Date dataCheckin) { this.dataCheckin = dataCheckin; }

    public String getHoraCheckin() { return horaCheckin; }
    public void setHoraCheckin(String horaCheckin) { this.horaCheckin = horaCheckin; }

    public String getStatusCheckin() { return statusCheckin; }
    public void setStatusCheckin(String statusCheckin) { this.statusCheckin = statusCheckin; }

    public String getTipoPlano() { return tipoPlano; }
    public void setTipoPlano(String tipoPlano) { this.tipoPlano = tipoPlano; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public String getOrigemCheckin() { return origemCheckin; }
    public void setOrigemCheckin(String origemCheckin) { this.origemCheckin = origemCheckin; }

    public java.util.Date getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(java.util.Date dataRegistro) { this.dataRegistro = dataRegistro; }
}