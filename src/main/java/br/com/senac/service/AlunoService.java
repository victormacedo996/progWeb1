package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
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

    public Aluno buscarAlunoId(Integer id) throws ObjectNotFoundException{
        Optional<Aluno> aluno = repo.findById(id);

        return aluno.orElseThrow( () -> new ObjectNotFoundException(1L, "Aluno não encontrado"));
    }

    public void deletarAlunoId(Integer id){
        repo.deleteById(id);
    }

    public Aluno salvarAlteracao(Aluno alunoAlterado){
        Aluno aluno = this.buscarAlunoId(alunoAlterado.getId());
        aluno.setNome(alunoAlterado.getNome());
        return salvar(aluno);
    }
}
