package br.com.clauvane.desafio.portifolio.controller;

import br.com.clauvane.desafio.portifolio.model.entity.Membro;
import br.com.clauvane.desafio.portifolio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/portifolio/membro")
public class MembroController {

    public static final String MEMBRO_LISTAGEM = "membro/listagem";
    public static final String MEMBROS = "membros";

    @Autowired
    private MembroService membroService;

    @GetMapping
    public String listagem(Model model){
        List<Membro> membros = membroService.findAll();
        model.addAttribute(MEMBROS, membros);
        return MEMBRO_LISTAGEM;
    }

}
