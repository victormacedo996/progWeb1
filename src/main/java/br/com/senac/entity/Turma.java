package br.com.senac.entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToMany
    @JoinTable(
        name = "turma_curso",
        joinColumns = { @JoinColumn(name = "turma_id") },
        inverseJoinColumns = { @JoinColumn(name = "curso_id") }
    )
    private List<Curso> cursos;

    public List<Curso> getCursos(){
        return this.cursos;
    } 

    public void setCurso(List<Curso> cursos){
        this.cursos = cursos;
    }

    private String nome;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
