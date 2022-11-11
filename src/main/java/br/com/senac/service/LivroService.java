package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.LivroL;
import br.com.senac.entity.Professor;
import br.com.senac.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    LivroRepository repo;

    public List<LivroL> buscarTodos(){
        return repo.findAll();
    }

    public LivroL salvar(LivroL livro){
        return repo.save(livro);
    }

    public List<LivroL> buscarLivrosDoProf(Professor prof){
        return repo.findByProfessor(prof);
    }
}
