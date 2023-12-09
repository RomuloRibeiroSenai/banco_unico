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
    public Conta saveConta(Conta conta){
        Conta nova_conta = contaRepository.save(conta);
        return nova_conta;
    }
    public Conta updateConta(Long id, Conta conta){

        Optional<Conta> conta_antiga = contaRepository.findById(id);

        if (conta_antiga.isPresent()){
         
            Conta nova = conta_antiga.get();

            nova.setNumero(conta.getNumero());
            nova.setSaldo(conta.getSaldo());
            nova.setTipo(conta.getTipo());

            Conta conta_atualizada = contaRepository.save(nova);
            return conta_atualizada;
        }
        return null;
    }
    public Conta deleteConta(Long id){
        contaRepository.deleteById(id);
        Conta contaDeletada = getContaById(id);

        return contaDeletada;
    }
    
} 
