package br.com.senac.inicializacao;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoCurso;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Endereco;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.EnderecoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.EnderecoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private ProfessorService professorService;

	// @Autowired
	// private ProfessorRepository professorRepository;

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//ALUNO

		Curso curso1 = new Curso();
		curso1.setNome("NodeJs");
		Curso curso2 = new Curso();
		curso2.setNome("ASP.NET");
		Curso curso3 = new Curso();
		curso3.setNome("Spring Boot");
		Curso curso4 = new Curso();
		curso4.setNome("C");


		Professor p1 = new Professor();
		p1.setNome("Lucas");
		Professor p2 = new Professor();
		p2.setNome("Joao");
		Professor p3 = new Professor();
		p3.setNome("Claudio");
		Professor p4 = new Professor();
		p4.setNome("Junior");

		professorService.salvar(p1);
		professorService.salvar(p2);
		professorService.salvar(p3);
		professorService.salvar(p4);

		List<Curso> listaCursos1 =  new ArrayList<>();
		listaCursos1.add(curso1);
		listaCursos1.add(curso4);

		List<Curso> listaCursos2 =  new ArrayList<>();
		listaCursos2.add(curso1);
		listaCursos2.add(curso3);

		List<Curso> listaCursos3 =  new ArrayList<>();
		listaCursos3.add(curso1);
		listaCursos3.add(curso3);

		curso1.setProfessor(p1);
		curso2.setProfessor(p3);
		curso3.setProfessor(p2);

		cursoService.salvar(curso1);
		cursoService.salvar(curso2);
		cursoService.salvar(curso3);
		cursoService.salvar(curso4);


		Turma t1 = new Turma();
		t1.setNome("turma 1");
		t1.setCurso(listaCursos1);
		turmaService.salvar(t1);
		Turma t2 = new Turma();
		t2.setNome("turma 2");
		t2.setCurso(listaCursos2);
		turmaService.salvar(t2);
		Turma t3 = new Turma();
		t3.setNome("turma 3");
		t3.setCurso(listaCursos3);
		turmaService.salvar(t3);	

		// curso1.setProfessor(p1);
		// curso2.setProfessor(p3);
		// curso3.setProfessor(p2);

		// cursoService.salvar(curso1);
		// cursoService.salvar(curso2);
		// cursoService.salvar(curso3);
		// cursoService.salvar(curso4);

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		aluno1.setTurma(t3);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		aluno2.setTurma(t3);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		aluno3.setTurma(t1);

		Aluno aluno4 = new Aluno();
		aluno4.setNome("Walter");
		aluno4.setTurma(t3);
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		alunoService.salvar(aluno4);

		// List<Turma> listaTurmas = turmaService.buscarTodasTurmas();

		// for (Turma turma : listaTurmas) {
		// 	System.out.println(turma.getNome());
		// 	for(Aluno aluno : turma.getAlunos()){
		// 		System.out.println(aluno.getNome());
		// 	}
		// }

		// List<Turma> listarTurmas = turmaRepository.findAllByIdTurma(3);

		// for(Turma turma : listarTurmas){
		// 	for(Aluno aluno : turma.getAlunos()){
		// 		System.out.println(aluno.getNome());
		// 	}
		// }

		Endereco endereco1 = new Endereco();
		endereco1.setRua("Rua Caxias");
		endereco1.setNumero(4);
		endereco1.setComplemento("Proximo a praca");
		endereco1.setBairro("Jardim Caxias");
		endereco1.setCep("2000010");


		Endereco endereco2 = new Endereco();
		endereco2.setRua("Rua Madureira");
		endereco2.setNumero(8);
		endereco2.setComplemento("Proximo ao calcadao");
		endereco2.setBairro("Jardim Madureira");
		endereco2.setCep("2000020");

		Endereco endereco3 = new Endereco();
		endereco3.setRua("Rua Sao Joao");
		endereco3.setNumero(12);
		endereco3.setComplemento("proximo ao parque");
		endereco3.setBairro("Jardim Sao Joao");
		endereco3.setCep("200030");

		Endereco endereco4 = new Endereco();
		endereco4.setRua("Rua Japeri");
		endereco4.setNumero(16);
		endereco4.setComplemento("proximo ao trem");
		endereco4.setBairro("Jardim Japeri");
		endereco4.setCep("200060");

		endereco1.setAluno(aluno1);
		endereco2.setAluno(aluno1);
		endereco3.setAluno(aluno4);
		endereco4.setAluno(aluno4);

		enderecoService.salvar(endereco1);
		enderecoService.salvar(endereco2);
		enderecoService.salvar(endereco3);
		enderecoService.salvar(endereco4);

		// Aluno al1 = alunoService.buscaPorNome("Lucas");
		
		// al1.getEnderecos().forEach((e) -> System.out.println("Rua: " + e.getRua() + " Numero: " + e.getNumero()));
		
		//FORMA 1
		// List<Endereco> listaEnderecoAluno1 = enderecoService.buscar(aluno1);

		// listaEnderecoAluno1.forEach((e) -> System.out.println("Rua " + e.getRua() + " Numero: " + e.getNumero() + " Bairro: " + e.getBairro()));

		//FORMA 2
		// List<Aluno> listaAlunoComEndereco = alunoService.buscarAlunoComEndereco();

		// listaAlunoComEndereco.forEach(a -> a.getEnderecos()
		// .forEach(end -> System.out.println("Aluno nome: " + end.getAluno().getNome()
		// 	+ " Rua: " + end.getRua())));

		List<Aluno> alunoComEndereco = alunoService.buscarAlunoPeloNomeComEndereco("Lucas");
		
		alunoComEndereco.forEach(a -> a.getEnderecos()
		.forEach(end -> System.out.println("Aluno nome: " + end.getAluno().getNome()
		+ " Rua: " + end.getRua())));

		// Turma turma = turmaService.buscarListaAlunosTurma(3);

		// List<Aluno> alunosDaTurma = turma.getAlunos();

		// alunosDaTurma.forEach((aluno) -> System.out.println("Nome do aluno: " + aluno.getNome()));

		Turma turma = turmaService.findTurmaByIdTurma(3);

		List<Aluno> alunosDaTurma = turma.getAlunos();

		alunosDaTurma.forEach((aluno) -> System.out.println("Nome do aluno: " + aluno.getNome()));
		 
		// List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		// for (Aluno aluno : listaAlunos) {
		// 	System.out.println(aluno.getNome());
		// }
		
		// Aluno aluno4 = alunoService.buscarPorId(1);
		// System.out.println(aluno4.getNome());

		//alunoService.deletar(3);
		
		// Aluno alunoAlterado = new Aluno();
		// alunoAlterado.setId(1);
		// alunoAlterado.setNome("Lucas Silva");
		// alunoService.salvarAlteracao(alunoAlterado);

		// TURMA
		// Turma turma1 = new Turma();
		// turma1.setNome("2020.1N");
		// Turma turma2 = new Turma();
		// turma2.setNome("2020.2N");
		// Turma turma3 = new Turma();
		// turma3.setNome("2021.1N");

		// turmaService.salvar(turma1);
		// turmaService.salvar(turma2);
		// turmaService.salvar(turma3);

		// List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
		// for (Turma turma : listaTurmas) {
		// 	System.out.println(turma.getNome());
		// }

		// Turma turma = turmaService.buscarPorId(1);
		// System.out.println(turma.getNome());

		// Turma turmaAlterada = new Turma();
		// turmaAlterada.setId(1);
		// turmaAlterada.setNome("2021.2N");
		// turmaService.salvarAlteracao(turmaAlterada);

		// turmaService.deletar(1);

		// CURSO
		// Curso curso1 = new Curso();
		// curso1.setNome("NodeJs");
		// Curso curso2 = new Curso();
		// curso2.setNome("ASP.NET");
		// Curso curso3 = new Curso();
		// curso3.setNome("Spring Boot");

		// Professor p1 = new Professor();
		// p1.setNome("Lucas");
		// Professor p2 = new Professor();
		// p2.setNome("Joao");
		// Professor p3 = new Professor();
		// p3.setNome("Claudio");
		// Professor p4 = new Professor();
		// p4.setNome("Junior");

		// professorService.salvar(p1);
		// professorService.salvar(p2);
		// professorService.salvar(p3);
		// professorService.salvar(p4);

		// // outra opcao
		// // professorRepository.saveAll(Arrays.asList(p1, p2, p3));

		// curso1.setProfessor(p1);
		// curso2.setProfessor(p3);
		// curso3.setProfessor(p2);

		// cursoService.salvar(curso1);
		// cursoService.salvar(curso2);
		// cursoService.salvar(curso3);

		// List<Curso> listaCursos = cursoService.buscarTodosCursos();
		// for (Curso curso : listaCursos) {
		// 	System.out.println(curso.getNome());
		// }

		// Curso curso = cursoService.buscarPorId(1);
		// System.out.println(curso.getNome());

		// Curso cursoAlterado = new Curso();
		// cursoAlterado.setId(1);
		// cursoAlterado.setNome("JavaScript");
		// cursoService.salvarAlteracao(cursoAlterado);

		// cursoService.deletar(1);

		// PROFESSOR
		// Professor professor1 = new Professor();
		// professor1.setNome("Jesus");
		// Professor professor2 = new Professor();
		// professor2.setNome("Leonardo");
		// Professor professor3 = new Professor();
		// professor3.setNome("Bruno");

		// professorService.salvar(professor1);
		// professorService.salvar(professor2);
		// professorService.salvar(professor3);

		// List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		// for (Professor professor : listaProfessores) {
		// 	System.out.println(professor.getNome());
		// }

		// Professor professor = professorService.buscarPorId(1);
		// System.out.println(professor.getNome());

		// Professor professorAlterado = new Professor();
		// professorAlterado.setId(1);
		// professorAlterado.setNome("Junior");
		// professorService.salvarAlteracao(professorAlterado);

		// professorService.deletar(1);

		// AVALIACAO

		Avaliacao avaliacao1 = new Avaliacao();
		
		AlunoCurso alunoCurso1 = new AlunoCurso();
		alunoCurso1.setAluno(aluno1);
		alunoCurso1.setCurso(curso4);

		avaliacao1.setAlunoCurso(alunoCurso1);
		avaliacao1.setConceito("I");

		avaliacaoService.save(avaliacao1);
	}
	
}
