package com.projeto.site.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {
    private Long id_veiculo;
    private String placa;
    private String modelo;
    private BigDecimal valorDiaria;
    
    private String tipo;
    private String marca;
    private String ano;
    
    //private Locacao locacao;

    public Veiculo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    @Column(length = 10, nullable = false)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(length = 18, nullable = false)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(precision = 10, scale = 2, nullable = true)
    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    
//    public Locacao getLocacao() {
//        return locacao;
//    }
//
//    public void setLocacao(Locacao locacao) {
//        this.locacao = locacao;
//    }
    
    @Column(length = 15)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(length = 25)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return "Veiculo{" + "id_veiculo=" + id_veiculo + ", placa=" + placa + ", modelo=" + modelo + ", valorDiaria=" + valorDiaria + '}';
    }    
}
