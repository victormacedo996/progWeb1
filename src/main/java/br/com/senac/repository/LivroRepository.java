package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.LivroL;
import br.com.senac.entity.Professor;

@Repository
public interface LivroRepository extends JpaRepository<LivroL, Integer> {
    List<LivroL> findByProfessor(Professor professor); 
}
