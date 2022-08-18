package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;



@Service
public class AlunoService {

    @Autowired
    AlunoRepository repo;

    public List<Aluno> buscarTodosAlunos(){
        return repo.findAll();
    }

    public Aluno salvar(Aluno aluno){
        return repo.save(aluno);
    }
}
