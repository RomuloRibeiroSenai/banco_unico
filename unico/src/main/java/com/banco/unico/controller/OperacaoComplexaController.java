package com.banco.unico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.unico.entities.OperacaoComplexa;
import com.banco.unico.service.OperacaoComplexaService;

@RestController
@RequestMapping("/complexa")
public class OperacaoComplexaController {

    @Autowired
    private OperacaoComplexaService complexaService;

    @GetMapping
    public ResponseEntity<List<OperacaoComplexa>> getAllComplexa() {

        List<OperacaoComplexa> extratoComplexa = complexaService.getAllComplexa();

        return ResponseEntity.ok(extratoComplexa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperacaoComplexa> getComplexaById(@PathVariable Long id) {

        OperacaoComplexa complexa = complexaService.getComplexaById(id);

        if (complexa != null) {
            return new ResponseEntity<>(complexa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(complexa, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{idContaOrigem}/{idContaDestino}")
    public ResponseEntity<OperacaoComplexa> saveOperacaoComplexa(@RequestBody OperacaoComplexa novaComplexa,
            @PathVariable Long idContaOrigem, @PathVariable Long idContaDestino) {

        OperacaoComplexa nova = complexaService.saveOperacaoComplexa(novaComplexa, idContaOrigem, idContaDestino);

        return ResponseEntity.ok(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperacaoComplexa> updateOperacaoComplexa(@RequestBody OperacaoComplexa complexaAtualizada,
            @PathVariable Long id) {

        OperacaoComplexa atualizada = complexaService.updateOperacao(id, complexaAtualizada);
        return ResponseEntity.ok(atualizada);
    }
}
