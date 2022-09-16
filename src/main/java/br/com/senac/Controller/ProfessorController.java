package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService service;

    @GetMapping("listar")
    public ModelAndView listarTodosProfessores(){
        ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
        mv.addObject("professores", service.buscarTodosProfessors());

        return mv;
    }

    @GetMapping("/cadastrar") // http://localhost:8080/professor/cadastrar
    public ModelAndView cadastrarProfessor(){
        ModelAndView mv = new ModelAndView("Professor/cadastrarProfessor");
        mv.addObject("professor", new Professor());
        return mv;
    }

    @PostMapping("/salvar") // http://localhost:8080/professor/salvar
    public ModelAndView salvarProfessor(Professor Professor){
        service.salvar(Professor);
        return listarTodosProfessores();
    }

}
