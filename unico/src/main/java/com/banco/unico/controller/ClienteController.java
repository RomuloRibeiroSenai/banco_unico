package com.banco.unico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.unico.entities.Cliente;
import com.banco.unico.entities.Login;
import com.banco.unico.service.ClienteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        
        List<Cliente> clientes = clienteService.getAllClientes();

        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        
        Cliente cliente = clienteService.getClienteById(id);

        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente novoCliente){

        Cliente cliente = clienteService.saveCliente(novoCliente, Optional.empty());
        return ResponseEntity.ok(cliente);
    }
    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody Login login){
    String login1 = login.getLogin();
    String senha = login.getSenha();
    System.out.println("Received login attempt - Username: " + login1 + ", Password: " + senha);
    Long clienteId = clienteService.findIdByLoginAndSenha(login1, senha);

    if (clienteId != null) {
        return new ResponseEntity<>(clienteId, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {

        Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.deleteCliente(id);
        
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> logicalDeleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.getClienteById(id);
        
        if (cliente != null){
            clienteService.logicalDeleteCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
}
