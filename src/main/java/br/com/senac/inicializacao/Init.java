package br.com.senac.inicializacao;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Turma;
import br.com.senac.repository.ProfessorRepository;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	AlunoService alunoService;
	//@Autowired
	//ProfessorService professorService;
	@Autowired
	CursoService cursoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private ProfessorRepository profRepository; 
	//@Autowired
	//AlunoRepository repo;
	
	
	
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

			
		Curso c1 = new Curso();
		c1.setNome("Java");
		cursoService.salvar(c1);
		
		Curso c2 = new Curso();
		c2.setNome("NodeJS");
		cursoService.salvar(c2);
		
		Curso c3 = new Curso();
		c3.setNome("Python");
		cursoService.salvar(c3);
		
		Curso c4 = new Curso();
		c4.setNome(".Net");
		cursoService.salvar(c4);
		
		
		List<Curso> listaCursos1 = new ArrayList();
		listaCursos1.add(c1);
		listaCursos1.add(c4);
		
		
		List<Curso> listaCursos2 = new ArrayList();
		listaCursos2.add(c2);
		listaCursos2.add(c3);
		
		List<Curso> listaCursos3 = new ArrayList();
		listaCursos2.add(c1);
		listaCursos2.add(c3);
		
		Turma t1 = new Turma();
		t1.setNome("Turma 1");
		t1.setCurso(listaCursos1);
		turmaService.salvar(t1);
		
		Turma t2 = new Turma();
		t2.setNome("Turma 2");
		t2.setCurso(listaCursos2);
		turmaService.salvar(t2);
		
		Turma t3 = new Turma();
		t3.setNome("Turma 3");
		t3.setCurso(listaCursos3);
		turmaService.salvar(t3);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Rogerio");
		aluno1.setTurma(t1);
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Alfredo");
		aluno2.setTurma(t2);
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Juleide");
		aluno3.setTurma(t3);
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		//repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
//		System.out.println("-----------------------------");
//		
//		List<Aluno> listaAlunos = alunoService.selectAll();
//		for(Aluno aluno: listaAlunos) {
//			System.out.println(aluno.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		System.out.println(alunoService.select(2).getNome());
//		
//		System.out.println("-----------------------------");
//		
//		alunoService.delete(2);
//		
//		listaAlunos = alunoService.selectAll();
//		for(Aluno aluno: listaAlunos) {
//			System.out.println(aluno.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		Aluno alunoAlterado = aluno1;
//		alunoAlterado.setNome("Rogerio Gerundes");
//		alunoService.update(alunoAlterado);
//		
//		System.out.println(alunoService.select(alunoAlterado.getId()).getNome());
//		
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		
//		Professor professor1 = new Professor();
//		professor1.setNome("Juleide");
//		Professor professor2 = new Professor();
//		professor2.setNome("Genilson");
//		
//		Professor professor3 = new Professor();
//		professor3.setNome("É hora do show, porra! Birl");
//		
//		professorService.insert(professor1);
//		professorService.insert(professor2);
//		professorService.insert(professor3);
//		
//		//profRepository.saveAll(Arrays.asList(professor1,professor2,professor3));
//		
//		List<Professor> listaProfessores = professorService.selectAll();
//		for(Professor professor: listaProfessores) {
//			System.out.println(professor.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		System.out.println(professorService.select(1).getNome());
//		
//		System.out.println("-----------------------------");
//		
//		//professorService.delete(1);
//		
//		listaProfessores = professorService.selectAll();
//		for(Professor professor: listaProfessores) {
//			System.out.println(professor.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		Professor professorAlterado = professor2;
//		professorAlterado.setNome("Genilson Ferreira");
//		professorService.update(professorAlterado);
//		
//		System.out.println(professorService.select(professorAlterado.getId()).getNome());
//		
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		
//		Curso curso1 = new Curso();
//		curso1.setNome("Programacao web 1");
//		curso1.setProfessor(professor1);
//		Curso curso2 = new Curso();
//		curso2.setNome("Testes");
//		curso2.setProfessor(professor2);
//		
//		cursoService.insert(curso1);
//		cursoService.insert(curso2);
//		
//		System.out.println("-----------------------------");
//		
//		List<Curso> listaCursos = cursoService.selectAll();
//		for(Curso curso: listaCursos) {
//			System.out.println(curso.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		System.out.println(cursoService.select(1).getNome());
//		
//		System.out.println("-----------------------------");
//		
//		cursoService.delete(1);
//		
//		listaCursos = cursoService.selectAll();
//		for(Curso curso: listaCursos) {
//			System.out.println(curso.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		Curso cursoAlterado = curso2;
//		cursoAlterado.setNome("Testes de software");
//		
//		cursoService.update(cursoAlterado);
//		
//		System.out.println(cursoService.select(cursoAlterado.getId()).getNome());
//		
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		
//		Turma turma1 = new Turma();
//		turma1.setNome("ADS2021.1");
//		Turma turma2 = new Turma();
//		turma2.setNome("ADS2021.2");
//		
//		turmaService.insert(turma1);
//		turmaService.insert(turma2);
//		
//		List<Turma> listaTurmas = turmaService.selectAll();
//		for(Turma turma: listaTurmas) {
//			System.out.println(turma.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		System.out.println(turmaService.select(1).getNome());
//		
//		System.out.println("-----------------------------");
//		
//		turmaService.delete(1);
//		
//		listaTurmas = turmaService.selectAll();
//		for(Turma turma: listaTurmas) {
//			System.out.println(turma.getNome());
//		}
//		
//		System.out.println("-----------------------------");
//		
//		Turma turmaAlterada = turma2;
//		turmaAlterada.setNome("ADS2022.2");
//		
//		turmaService.update(turmaAlterada);
//		
//		System.out.println(turmaService.select(turmaAlterada.getId()).getNome());
//		
//		System.out.println("-----------------------------");
//		
//		
//		
//		System.out.println("----------------------------");
//		
	}
}
