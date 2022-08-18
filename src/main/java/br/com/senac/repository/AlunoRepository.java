package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.senac.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
