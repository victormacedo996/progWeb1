package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService service;

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
        return mv;
    }

    @PostMapping("/salvar") // http://localhost:8080/aluno/salvar
    public ModelAndView salvarAluno(Aluno aluno){
        service.salvar(aluno);
        return listarTodosAlunos();
    }


}
