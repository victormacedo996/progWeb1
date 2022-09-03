package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService service;

    @GetMapping("listar")
    public ModelAndView listarTodosAlunos(){
        ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
        mv.addObject("professores", service.buscarTodosProfessors());

        return mv;
    }

}
