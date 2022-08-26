package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository repo;

    public List<Turma> buscarTodosTurmas(){
        return repo.findAll();
    }

    public Turma salvar(Turma turma){
        return repo.save(turma);
    }

    public Turma buscarTurmaId(Integer id) throws ObjectNotFoundException{
        Optional<Turma> turma = repo.findById(id);

        return turma.orElseThrow( () -> new ObjectNotFoundException(1L, "Turma não encontrado"));
    }

    public void deletarTurmaId(Integer id){
        repo.deleteById(id);
    }

    public Turma salvarAlteracao(Turma turmaAlterado){
        Turma turma = this.buscarTurmaId(turmaAlterado.getId());
        turma.setNome(turmaAlterado.getNome());
        return salvar(turma);
    }

}
