package com.banco.unico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.unico.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
