package br.com.clauvane.desafio.portifolio.controller;

import br.com.clauvane.desafio.portifolio.model.dto.PessoaDto;
import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import br.com.clauvane.desafio.portifolio.service.PessoaService;
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
@RequestMapping("/portifolio/pessoa")
public class PessoaController {

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada.";
    public static final String PESSOAS = "pessoas";
    public static final String PESSOA_LISTAGEM = "pessoa/listagem";
    public static final String FORM_ACTION = "formAction";

    @Autowired
    private PessoaService pessoaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String listagem(Model model){
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute(PESSOAS, pessoas);
        return PESSOA_LISTAGEM;
    }

    @GetMapping("/salvar")
    public String prepararSalvar(ModelMap model){
      model.addAttribute("pessoa", new Pessoa());
      model.addAttribute(FORM_ACTION, "salvar");

      return "pessoa/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pessoa") PessoaDto pessoaDto, Model model){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        pessoa.setCriadoEm(new Date());
        pessoaService.saveOrUpdate(pessoa);
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute(PESSOAS, pessoas);
        return PESSOA_LISTAGEM;
    }

    @GetMapping("/editar")
    public String prepararEditar(@RequestParam String id, Model model){
        Optional<Pessoa> pessoa = pessoaService.findById(UUID.fromString(id));
        if (!pessoa.isPresent()) {
            throw new IllegalArgumentException(PESSOA_NAO_ENCONTRADA);
        }
        model.addAttribute("pessoa", pessoa.get());
        model.addAttribute(FORM_ACTION, "editar");

        return "pessoa/formulario";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("pessoa") PessoaDto pessoaDto, Model model){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        pessoa.setAtualizadoEm(new Date());
        pessoaService.saveOrUpdate(pessoa);
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute(PESSOAS, pessoas);
        return PESSOA_LISTAGEM;
    }

    @GetMapping("/remover")
    public String remover(@RequestParam String id, Model model){
        Optional<Pessoa> pessoa = pessoaService.findById(UUID.fromString(id));
        if (!pessoa.isPresent()) {
            throw new IllegalArgumentException(PESSOA_NAO_ENCONTRADA);
        }

        pessoaService.delete(pessoa.get());
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute(PESSOAS, pessoas);
        return PESSOA_LISTAGEM;
    }

}
