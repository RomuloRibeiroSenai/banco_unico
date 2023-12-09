package com.banco.unico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.unico.entities.Conta;
import com.banco.unico.entities.Conta;
import com.banco.unico.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
    
    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas(){

        List<Conta> contas = contaService.getAllContas();

        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id){

        Conta conta = contaService.getContaById(id);

        if (conta != null){
            return new ResponseEntity<>(conta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(conta, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Conta> saveConta(@RequestBody Conta novaConta){

        Conta conta = contaService.saveConta(novaConta);
        return ResponseEntity.ok(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta (@RequestBody Conta contaAtualizada, @PathVariable Long id) {

        Conta conta = contaService.updateConta(id, contaAtualizada);
        return ResponseEntity.ok(conta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deleteConta(@PathVariable Long id){

        Conta conta = contaService.deleteConta(id);
        
        return ResponseEntity.ok(conta);
    }
}
