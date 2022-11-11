package br.com.senac.entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String nome;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.JOIN)
    private List<LivroL> livros;

    public Integer getId() {
        return Id;
    }

    public List<LivroL> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroL> livros) {
        this.livros = livros;
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
