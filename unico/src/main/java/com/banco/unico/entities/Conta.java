package com.banco.unico.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data  
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private double saldo;
    private String tipo;

    @OneToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "cliente_fkey"))
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private List<OperacaoSimples> operacaoSimples;

    @OneToMany(mappedBy = "conta_origem")
    @JsonManagedReference
    private List<OperacaoComplexa> operacaoComplexaOrigem;

    @OneToMany(mappedBy = "conta_destino")
    @JsonManagedReference
    private List<OperacaoComplexa> operacaoComplexaDestino;
}
