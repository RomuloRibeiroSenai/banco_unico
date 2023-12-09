package com.banco.unico.entities;


import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime data_hora;
    // destino 
    
    @ManyToOne
    @JoinColumn(name = "conta", foreignKey = @ForeignKey(name = "conta_fkey"))
    @JsonBackReference
    private Conta conta;
}
