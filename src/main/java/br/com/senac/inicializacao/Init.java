package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();

		
		for(Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		//Busca por id
		Aluno aluno4 = alunoService.buscarAlunoId(1);
		
		System.out.println(aluno4.getNome());
		
		//deleção por id
		alunoService.deletarAlunoId(2);
	
		
		
		Aluno alunoAlterado = new Aluno();
		alunoAlterado.setId(1);
		alunoAlterado.setNome("Lucas Silva");
		
		alunoService.salvarAlteracao(alunoAlterado);


		Professor professor1 = new Professor();
		professor1.setNome("Lucas");
		
		Professor professor2 = new Professor();
		professor2.setNome("Arthur");
		
		Professor professor3 = new Professor();
		professor3.setNome("Jose");

		professorService.salvar(professor1);
		professorService.salvar(professor2);
		professorService.salvar(professor3);

		List<Professor> listarProfessores = professorService.buscarTodosProfessors();
		for(Professor professor : listarProfessores) {
			System.out.println(professor.getNome());
		}
		
	}

}