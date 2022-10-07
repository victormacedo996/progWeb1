package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService service;

    @Autowired
    private TurmaService turmaService;

    @GetMapping("listar") // http://localhost:8080/aluno/listar
    public ModelAndView listarTodosAlunos(){
        ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
        mv.addObject("alunos", service.buscarTodosAlunos());

        return mv;
    }

    @GetMapping("/cadastrar") // http://localhost:8080/aluno/cadastrar
    public ModelAndView cadastrarAluno(){
        ModelAndView mv = new ModelAndView("aluno/cadastrarAluno");
        mv.addObject("aluno", new Aluno());
        mv.addObject("turmas", turmaService.buscarTodosTurmas());
        return mv;
    }

    @PostMapping("/salvar") // http://localhost:8080/aluno/salvar
    public ModelAndView salvarAluno(Aluno aluno){
        service.salvar(aluno);
        return listarTodosAlunos();
    }

    @GetMapping("/alterar/{id}/{nome}") // http://localhost:8080/aluno/alterar/{id}/{nome}
    public ModelAndView alterarAluno(@PathVariable("id") Integer id, @PathVariable("nome") String nome){
        ModelAndView mv = new ModelAndView("aluno/alterarAluno");
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        mv.addObject("aluno", aluno);
        mv.addObject("turmas", turmaService.buscarTodosTurmas());
        return mv;
    }

    @PostMapping("/alterar") // http://localhost:8080/aluno/alterar
    public RedirectView alterarAluno(Aluno aluno){
        service.salvarAlteracao(aluno);
        return (RedirectView) new RedirectView("listar");
    }

    @GetMapping("/deletar/{id}") // http://localhost:8080/aluno/deletar/{id}
    public RedirectView deletarAluno(@PathVariable("id") Integer id){
        service.deletarAlunoId(id);
        return (RedirectView) new RedirectView("/aluno/listar");
    }

}
