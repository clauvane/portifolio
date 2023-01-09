package br.com.clauvane.desafio.portifolio.controller;

import br.com.clauvane.desafio.portifolio.model.dto.ProjetoDto;
import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import br.com.clauvane.desafio.portifolio.model.enums.StatusProjeto;
import br.com.clauvane.desafio.portifolio.service.ProjetoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/portifolio/projeto")
public class ProjetoController {

    public static final String PROJETO_NAO_ENCONTRADO = "Projeto não encontrado.";
    public static final String PROJETOS = "projetos";
    public static final String PROJETO_LISTAGEM = "projeto/listagem";
    public static final String FORM_ACTION = "formAction";

    @Autowired
    private ProjetoService projetoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String listagem(Model model){
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute(PROJETOS, projetos);
        return PROJETO_LISTAGEM;
    }

    @GetMapping("/salvar")
    public String prepararSalvar(ModelMap model){
      model.addAttribute("projeto", new Projeto());
      model.addAttribute(FORM_ACTION, "salvar");

      return "projeto/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("projeto") ProjetoDto projetoDto, Model model){
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoDto, projeto);
        projeto.setCriadoEm(new Date());
        projeto.setStatus(StatusProjeto.EM_ANALISE);
        projetoService.saveOrUpdate(projeto);
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute(PROJETOS, projetos);
        return PROJETO_LISTAGEM;
    }

    @GetMapping("/editar")
    public String prepararEditar(@RequestParam String id, Model model){
        Optional<Projeto> projeto = projetoService.findById(UUID.fromString(id));
        if (!projeto.isPresent()) {
            throw new IllegalArgumentException(PROJETO_NAO_ENCONTRADO);
        }
        model.addAttribute("projeto", projeto.get());
        model.addAttribute(FORM_ACTION, "editar");

        return "projeto/formulario";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("projeto") ProjetoDto projetoDto, Model model){
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoDto, projeto);
        projeto.setAtualizadoEm(new Date());
        projetoService.saveOrUpdate(projeto);
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute(PROJETOS, projetos);
        return PROJETO_LISTAGEM;
    }

    @GetMapping("/remover")
    public String remover(@RequestParam String id, Model model){
        Optional<Projeto> projeto = projetoService.findById(UUID.fromString(id));
        if (!projeto.isPresent()) {
            throw new IllegalArgumentException(PROJETO_NAO_ENCONTRADO);
        }

        projetoService.delete(projeto.get());
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute(PROJETOS, projetos);
        return PROJETO_LISTAGEM;
    }

}
