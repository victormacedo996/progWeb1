package br.com.senac.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AlunoCurso implements Serializable {

    private static final long serialVersionUID = 5963010407968573616L;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Curso curso;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }




}
