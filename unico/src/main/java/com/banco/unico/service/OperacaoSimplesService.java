package com.banco.unico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.unico.entities.OperacaoSimples;
import com.banco.unico.repository.OperacaoSimplesRepository;

@Service
public class OperacaoSimplesService {

    @Autowired
    private OperacaoSimplesRepository operacaoSimplesRepository;

    public List<OperacaoSimples> getAllSimples() {

        List<OperacaoSimples> lista_simples = operacaoSimplesRepository.findAll();

        return lista_simples;
    }

    public OperacaoSimples getSimplesById(Long id) {

        OperacaoSimples simples = operacaoSimplesRepository.findById(id).orElse(null);

        return simples;
    }

    public OperacaoSimples saveOperacaoSimples(OperacaoSimples novaOperacaoSimples) {

        OperacaoSimples nova = operacaoSimplesRepository.save(novaOperacaoSimples);

        return nova;
    }

    public OperacaoSimples updateOperacao(Long id, OperacaoSimples operacaoSimples) {

        Optional<OperacaoSimples> simples_nova = operacaoSimplesRepository.findById(id);

        if (simples_nova.isPresent()) {
            OperacaoSimples antiga = simples_nova.get();

            antiga = operacaoSimplesRepository.save(antiga);
            return antiga;
        }
        return null;
    }
}
