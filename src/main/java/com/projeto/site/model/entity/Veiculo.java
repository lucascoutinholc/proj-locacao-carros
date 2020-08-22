package com.projeto.site.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "{obrigatorio}")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(length = 18, nullable = false)
    @NotNull(message = "{obrigatorio}")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(precision = 10, scale = 2, nullable = true)
    @NotNull(message = "{obrigatorio}")
    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    @Column(length = 15)
    @NotNull(message = "{obrigatorio}")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(length = 25)
    @NotNull(message = "{obrigatorio}")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(length = 4)
    @NotNull(message = "{obrigatorio}")
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
