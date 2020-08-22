package com.projeto.site.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {
    private Long id_locacao;
    private Date dataInicio;
    private Date dataFim;
    private Long qtdDiarias;
    private Veiculo veiculo;
    private Cliente cliente;

    public Locacao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(Long id_locacao) {
        this.id_locacao = id_locacao;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "{obrigatorio}")
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "{obrigatorio}")
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Column(nullable = false)
    public Long getQtdDiarias() {
        return qtdDiarias;
    }

    public void setQtdDiarias(Long qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
    }

    @OneToOne
    @JoinColumn(name = "id_veiculo")
    @NotNull(message = "{obrigatorio}")
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull(message = "{obrigatorio}")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}