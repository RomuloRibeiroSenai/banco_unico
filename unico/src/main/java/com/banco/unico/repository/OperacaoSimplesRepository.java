package com.banco.unico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banco.unico.entities.OperacaoSimples;

@Repository
public interface OperacaoSimplesRepository extends JpaRepository<OperacaoSimples, Long>{
    
}
