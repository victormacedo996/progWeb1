package br.com.senac.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.com.senac.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    
    @Query("SELECT DISTINCT t FROM Turma t JOIN FETCH t.alunos a WHERE a.turma.id = ?1")
    List<Turma> findAllByIdTurma(Integer idTurma);

    @Query("SELECT t FROM Turma t LEFT JOIN t.alunos a WHERE a.turma.id = ?1")
    Turma findTurmaByIdTurma(Integer id);
}
