package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Endereco;
import br.com.senac.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Integer id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.orElseThrow(() -> new ObjectNotFoundException(id, "endereco não encontrado"));
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void deletar(Integer id){
        enderecoRepository.deleteById(id);
    }

    public Endereco alterar (Endereco end){
        Endereco endereco = buscarPorId(end.getId());
        endereco.setId(endereco.getId());
        endereco.setRua(endereco.getRua());
        endereco.setNumero(endereco.getNumero());
        endereco.setComplemento(endereco.getComplemento());
        endereco.setBairro(endereco.getBairro());
        endereco.setCep(endereco.getCep());
        endereco.setAluno(endereco.getAluno());
        return salvar(endereco);
    }

    public List<Endereco> buscar (Aluno aluno){
        return enderecoRepository.findByAluno(aluno);
    }

}
