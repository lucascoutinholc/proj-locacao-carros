package com.projeto.site.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_locacao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "{obrigatorio}")
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "{obrigatorio}")
    private Date dataFim;

    @Column(nullable = false)
    private Long qtdDiarias;

    @OneToOne
    @JoinColumn(name = "id_veiculo")
    @NotNull(message = "{obrigatorio}")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull(message = "{obrigatorio}")
    private Cliente cliente;

    public Locacao() {
    }

    public BigDecimal calcularTotal(Veiculo veiculo, Locacao locacao) {
        BigDecimal diarias = BigDecimal.valueOf(locacao.getQtdDiarias());

        BigDecimal total = veiculo.getValorDiaria().multiply(diarias);

        return total;
    }

    public Long getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(Long id_locacao) {
        this.id_locacao = id_locacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Long getQtdDiarias() {
        return qtdDiarias;
    }

    public void setQtdDiarias(Long qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
