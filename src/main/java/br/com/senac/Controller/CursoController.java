package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("listar")
    public ModelAndView listarTodosCursos() {
        ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
        mv.addObject("cursos", service.buscarTodosCursos());
        return mv;
    }

    @GetMapping("/cadastrar") // http://localhost:8080/curso/cadastrar
    public ModelAndView cadastrarCurso() {
        ModelAndView mv = new ModelAndView("curso/cadastrarCurso");
        mv.addObject("professores", professorService.buscarTodosProfessors());
        mv.addObject("curso", new Curso());
        return mv;
    }

    @PostMapping("/salvar") // http://localhost:8080/curso/salvar
    public ModelAndView salvarCurso(Curso curso) {
        service.salvar(curso);
        return listarTodosCursos();
    }

    @GetMapping("/alterar/{id}/{nome}") // http://localhost:8080/curso/alterar/{id}/{nome}
    public ModelAndView alterarCurso(@PathVariable("id") Integer id, @PathVariable("nome") String nome) {
        ModelAndView mv = new ModelAndView("curso/alterarCurso");
        Curso curso = new Curso();
        curso.setId(id);
        curso.setNome(nome);
        mv.addObject("professores", professorService.buscarTodosProfessors());
        mv.addObject("curso", curso);
        return mv;
    }

    @PostMapping("/alterar") // http://localhost:8080/curso/alterar
    public RedirectView alterarCurso(Curso curso) {
        service.salvarAlteracao(curso);
        return (RedirectView) new RedirectView("listar");
    }

    @GetMapping("/deletar/{id}") // http://localhost:8080/curso/deletar/{id}
    public RedirectView deletarCurso(@PathVariable("id") Integer id) {
        service.deletarCursoId(id);
        return (RedirectView) new RedirectView("/curso/listar");
    }

}
