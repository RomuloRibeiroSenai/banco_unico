package com.banco.unico.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "OperacaoSimples")
public class OperacaoSimples {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private double valor;
    private LocalDateTime data_hora;
    // destino 
    
    @ManyToOne
    @JoinColumn(name = "conta", foreignKey = @ForeignKey(name = "conta_fkey"))
    private Conta conta;
//     public OperacaoSimples(OperacaoSimples operacao, Conta conta){
//         operacao.setConta(conta);

// }
}
