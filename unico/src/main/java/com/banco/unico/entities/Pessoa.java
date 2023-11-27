package com.banco.unico.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
