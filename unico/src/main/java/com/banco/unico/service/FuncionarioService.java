package com.banco.unico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banco.unico.entities.Funcionario;
import com.banco.unico.repository.FuncionarioRepository;

public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        return funcionarios;
    }

    public Funcionario getFuncionarioById(Long id){

        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        return funcionario;
    }

    public Funcionario saveFuncionario(Funcionario novoFuncionario){

        Funcionario funcionario = funcionarioRepository.save(novoFuncionario);
        return funcionario;
    }
    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado){
        
        Funcionario funcionario = saveFuncionario(funcionarioAtualizado);

        return funcionario;
    }
    public Funcionario deleteFuncionario(Long id){

        funcionarioRepository.deleteById(id);
        Funcionario deletado = getFuncionarioById(id);

        return deletado;
    }
}
