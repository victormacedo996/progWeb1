package br.com.senac.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "avalicoes")
public class Avaliacao {
    
    @EmbeddedId
    private AlunoCurso alunoCurso;

    
    private String conceito;


    public AlunoCurso getAlunoCurso() {
        return alunoCurso;
    }


    public void setAlunoCurso(AlunoCurso alunoCurso) {
        this.alunoCurso = alunoCurso;
    }


    public String getConceito() {
        return conceito;
    }


    public void setConceito(String conceito) {
        this.conceito = conceito;
    }


    
}
