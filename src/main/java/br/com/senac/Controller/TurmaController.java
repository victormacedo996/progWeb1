package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
    
    @Autowired
    private TurmaService service;

    @GetMapping("listar")
    public ModelAndView listarTodosAlunos(){
        ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
        mv.addObject("turmas", service.buscarTodosTurmas());

        return mv;
    }

}
