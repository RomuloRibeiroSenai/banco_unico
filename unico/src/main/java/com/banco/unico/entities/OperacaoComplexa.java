package com.banco.unico.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import lombok.Data;

@Data
@Entity
@Table(name = "OperacaoComplexa")
public class OperacaoComplexa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private double valor;
    private LocalDate data_hora;
    // origem destino

    @ManyToOne
    @JoinColumn(name = "conta_origem", foreignKey = @ForeignKey(name = "conta_origem_fkey"))
    private Conta conta_origem;

    @ManyToOne
    @JoinColumn(name = "conta_destino", foreignKey = @ForeignKey(name = "conta_destino_fkey"))
    private Conta conta_destino;
}
