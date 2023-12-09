package com.banco.unico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.unico.entities.OperacaoComplexa;

@Repository
public interface OperacaoComplexaRepository extends JpaRepository<OperacaoComplexa, Long>{
    
}
