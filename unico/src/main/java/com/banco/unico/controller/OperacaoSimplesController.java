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

import com.banco.unico.entities.OperacaoSimples;
import com.banco.unico.service.OperacaoSimplesService;

@RestController
@RequestMapping("/simples")
public class OperacaoSimplesController {

    @Autowired
    private OperacaoSimplesService simplesService;

    @GetMapping
    public ResponseEntity<List<OperacaoSimples>> getAllSimples() {

        List<OperacaoSimples> extratoSimples = simplesService.getAllSimples();

        return ResponseEntity.ok(extratoSimples);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OperacaoSimples> getSimplesById(@PathVariable Long id){

        OperacaoSimples simples = simplesService.getSimplesById(id);

        if (simples != null){
            return new ResponseEntity<>(simples, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(simples, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<OperacaoSimples> saveOperacaoSimples(@RequestBody OperacaoSimples novaSimples, @PathVariable Long id ){

        OperacaoSimples nova = simplesService.saveOperacaoSimples(novaSimples, id);

        return ResponseEntity.ok(nova);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OperacaoSimples> updateOperacaoSimples (@RequestBody OperacaoSimples simplesAtualizada, @PathVariable Long id){

        OperacaoSimples atualizada = simplesService.updateOperacao(id, simplesAtualizada);
        return ResponseEntity.ok(atualizada);
    }
}
