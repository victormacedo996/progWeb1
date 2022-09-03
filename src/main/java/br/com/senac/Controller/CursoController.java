package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
    
    @Autowired
    private CursoService service;

    @GetMapping("listar")
    public ModelAndView listarTodosAlunos(){
        ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
        mv.addObject("cursos", service.buscarTodosCursos());

        return mv;
    }

}
