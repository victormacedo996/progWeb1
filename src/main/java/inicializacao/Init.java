package inicializacao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;

import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
    
    @Autowired
    AlunoService alunoService;

    //@Autowired
    //AlunoRepository repo;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Lucas");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Daniel");

        Aluno aluno3 = new Aluno();
        aluno3.setNome("Sakamoto");

        

        alunoService.salvar(aluno1);
        alunoService.salvar(aluno2);
        alunoService.salvar(aluno3);

        List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();

        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno.getNome());
        }
        
        //repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));


        Aluno aluno4 = alunoService.buscarAlunoId(1);

        System.out.println(aluno4.getNome());

        alunoService.deletarAlunoId(1);
        



    }
}
