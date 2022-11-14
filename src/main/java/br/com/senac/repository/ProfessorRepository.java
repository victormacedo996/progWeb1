package br.com.senac.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.LivroL;
import br.com.senac.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    @Query(value = "SELECT l FROM LivroL l WHERE l.professor.id = ?1")
    List<LivroL> buscarLivros(Integer id);
}
