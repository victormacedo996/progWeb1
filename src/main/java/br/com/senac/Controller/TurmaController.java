package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.senac.entity.Turma;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
    
    @Autowired
    private TurmaService service;

    @Autowired
    private CursoService cursoService;

    @GetMapping("listar")
    public ModelAndView listarTodasTurmas(){
        ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
        mv.addObject("turmas", service.buscarTodosTurmas());

        return mv;
    }

    @GetMapping("/cadastrar") // http://localhost:8080/turma/cadastrar
    public ModelAndView cadastrarTurma(){
        ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
        mv.addObject("turma", new Turma());
        mv.addObject("cursos", cursoService.buscarTodosCursos());
        return mv;
    }

    @PostMapping("/salvar") // http://localhost:8080/turma/salvar
    public ModelAndView salvarTurma(Turma Turma){
        service.salvar(Turma);
        return listarTodasTurmas();
    }

    @GetMapping("/alterar/{id}/{nome}") // http://localhost:8080/turma/alterar/{id}/{nome}
    public ModelAndView alterarTurma(@PathVariable("id") Integer id, @PathVariable("nome") String nome) {
        ModelAndView mv = new ModelAndView("turma/alterarTurma");
        Turma turma = new Turma();
        turma.setId(id);
        turma.setNome(nome);
        mv.addObject("turma", turma);
        return mv;
    }

    @PostMapping("/alterar") // http://localhost:8080/turma/alterar
    public RedirectView alterarAluno(Turma turma) {
        service.salvarAlteracao(turma);
        return (RedirectView) new RedirectView("listar");
    }

    @GetMapping("/deletar/{id}") // http://localhost:8080/turma/deletar/{id}
    public RedirectView deletarTurma(@PathVariable("id") Integer id) {
        service.deletarTurmaId(id);
        return (RedirectView) new RedirectView("/turma/listar");
    }

}
