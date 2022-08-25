package br.com.senac.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}
