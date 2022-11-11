package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.senac.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
    /* 
    
        O Spring entende que vai ser buscado pelo nome
        Ele consegue quebrar o nome do método pra saber que o
        Find é pra buscar, By sucede algum atributo e a última parte
        é o atributo que está sendo buscado
    
    */ 
    Aluno findByNome(String nome);


    /* 
        Adição de métodos para rodar queries "customizadas" pra conseguir 
        pegar os dados da forma que se quer. JPQL, mais próximo do SQL
     */
    @Query(value = "SELECT DISTINCT a FROM Aluno a JOIN FETCH a.enderecos b")
    List<Aluno> buscarAlunoComEndereco();

    @Query(value = "SELECT DISTINCT a FROM Aluno a JOIN FETCH a.enderecos b WHERE a.nome = ?1")
    List<Aluno> buscaAlunoPeloNome(String nome);
}
