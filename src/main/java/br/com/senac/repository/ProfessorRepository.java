package br.com.senac.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
}
