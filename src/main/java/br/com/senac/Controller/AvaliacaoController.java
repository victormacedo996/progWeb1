package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Avaliacao;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    AlunoService alunoService;

    @Autowired
    CursoService cursoService;

    @Autowired
    AvaliacaoService avaliacaoService;

    @GetMapping("/adiciona")
    public ModelAndView adiciona(){
        ModelAndView mv = new ModelAndView("avaliacoes/inserir-nota");
        mv.addObject("alunos", alunoService.buscarTodosAlunos());
        mv.addObject("cursos", cursoService.buscarTodosCursos());
        mv.addObject("avaliacao", new Avaliacao());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("avaliacao") Avaliacao avaliacao){
        avaliacao.getAlunoCurso().setAluno(alunoService.buscarAlunoId(avaliacao.getAlunoCurso().getAluno().getId()));
        avaliacao.getAlunoCurso().setCurso(cursoService.buscarCursoId(avaliacao.getAlunoCurso().getCurso().getId()));
        avaliacaoService.save(avaliacao);
        ModelAndView mv = new ModelAndView("avaliacoes/listar-notas");
        mv.addObject("avaliacoes", avaliacaoService.findAll());
        return mv;
    }

    @GetMapping("listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("avaliacoes/listar-notas");
        mv.addObject("avaliacoes", avaliacaoService.findAll());
        return mv;
    }
}
