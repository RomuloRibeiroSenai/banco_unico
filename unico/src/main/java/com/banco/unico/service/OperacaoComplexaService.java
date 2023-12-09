package com.banco.unico.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.unico.entities.Conta;
import com.banco.unico.entities.OperacaoComplexa;
import com.banco.unico.repository.ContaRepository;
import com.banco.unico.repository.OperacaoComplexaRepository;

@Service
public class OperacaoComplexaService {

    @Autowired
    private OperacaoComplexaRepository operacaoComplexaRepository;
    @Autowired
    private ContaRepository contaRepository;

    public List<OperacaoComplexa> getAllComplexa() {

        List<OperacaoComplexa> lista_complexa = operacaoComplexaRepository.findAll();

        return lista_complexa;
    }

    public OperacaoComplexa getComplexaById(Long id) {

        OperacaoComplexa complexa = operacaoComplexaRepository.findById(id).orElse(null);

        return complexa;
    }

    public OperacaoComplexa saveOperacaoComplexa(OperacaoComplexa novaOperacaoComplexa, Long idContaOrigem, Long idContaDestino) {
        Conta contaOrigem = contaRepository.findById(idContaOrigem).orElse(null);
        Conta contaDestino = contaRepository.findById(idContaDestino).orElse(null);

        novaOperacaoComplexa.setConta_origem(contaOrigem);
        novaOperacaoComplexa.setConta_destino(contaDestino);
        novaOperacaoComplexa.setData_hora(LocalDateTime.now());

        operacaoComplexaRepository.save(novaOperacaoComplexa);

        return novaOperacaoComplexa;
    }

    public OperacaoComplexa updateOperacao(Long id, OperacaoComplexa operacaoComplexa) {

        Optional<OperacaoComplexa> complexaNova = operacaoComplexaRepository.findById(id);

        if (complexaNova.isPresent()) {
            OperacaoComplexa antiga = complexaNova.get();
            antiga.setTipo(operacaoComplexa.getTipo());
            antiga.setValor(operacaoComplexa.getValor());
            antiga = operacaoComplexaRepository.save(antiga);
            return antiga;
        }
        return null;
    }
}
