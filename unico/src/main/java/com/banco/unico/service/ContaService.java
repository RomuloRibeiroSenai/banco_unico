package com.banco.unico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.unico.entities.Conta;
import com.banco.unico.repository.ContaRepository;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAllContas(){

        List<Conta> lista_contas = contaRepository.findAll();
        return lista_contas;
    }
    public Conta getContaById(Long id){

        Conta conta = contaRepository.findById(id).orElse(null);
        return conta;
    }
    public Conta updateConta(Long id, Conta conta){

        Optional<Conta> conta_nova = contaRepository.findById(id);

        if (conta_nova.isPresent()){
            //dando erro no save
            Conta antiga = conta_nova.save(antiga);
            return antiga;
        }
        return null;
    }
} 
