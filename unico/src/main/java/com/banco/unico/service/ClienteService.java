package com.banco.unico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.unico.entities.Cliente;
import com.banco.unico.entities.Conta;
import com.banco.unico.repository.ClienteRepository;
import com.banco.unico.repository.ContaRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContaRepository contaRepository;

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    public Cliente getClienteById(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    public Cliente saveCliente(Cliente novoCliente, Optional <Long> conta_id) {

        
        if(conta_id.isPresent()){
            Optional<Conta> contaOptional = contaRepository.findById(conta_id.get());
            Conta conta = contaOptional.get();
            novoCliente.setConta(conta);
        }

        Cliente cliente = clienteRepository.save(novoCliente);
        return cliente;
    }
    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {

        Optional<Cliente> cliente_novo = clienteRepository.findById(id);
        if (cliente_novo.isPresent()) {
            Cliente existente = cliente_novo.get();

            existente.setLogin(clienteAtualizado.getLogin());
            existente.setSenha(clienteAtualizado.getSenha());
            existente.setEndereco(clienteAtualizado.getEndereco());
            //existente.setConta(clienteAtualizado.getConta());

            if(clienteAtualizado.getConta() != null){
                clienteAtualizado.getConta().setCliente(existente);
                Conta contaAtualizada = contaRepository.save(clienteAtualizado.getConta());
                existente.setConta(contaAtualizada);
            }

            clienteAtualizado = clienteRepository.save(existente);

            return clienteAtualizado;
        }
        return null;
    }

    public Cliente deleteCliente(Long id) {

        clienteRepository.deleteById(id);
        Cliente clienteDeletado = getClienteById(id);

        return clienteDeletado;
    }

    public Cliente logicalDeleteCliente(Long id) {
        Cliente clienteExistente = getClienteById(id);
        clienteExistente.setAtivo(false);
        Optional<Long> opicional = Optional.ofNullable(clienteExistente.getId());
        saveCliente(clienteExistente, opicional);

        return clienteExistente;
    }
    public Long findIdByLoginAndSenha(String login, String senha) {
        Cliente cliente = clienteRepository.findByLoginAndSenha(login, senha);
        return (cliente != null) ? cliente.getId() : null;
    }
}
