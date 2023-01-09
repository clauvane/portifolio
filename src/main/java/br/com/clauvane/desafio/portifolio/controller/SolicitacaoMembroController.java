package br.com.clauvane.desafio.portifolio.controller;

import br.com.clauvane.desafio.portifolio.model.dto.SolicitacaoMembroDto;
import br.com.clauvane.desafio.portifolio.model.entity.SolicitacaoMembro;
import br.com.clauvane.desafio.portifolio.model.enums.StatusSolicitacaoMembro;
import br.com.clauvane.desafio.portifolio.service.SolicitacaoMembroService;
import br.com.clauvane.desafio.portifolio.service.PessoaService;
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
@RequestMapping("/portifolio/solicitacao-membro")
public class SolicitacaoMembroController {

    public static final String SOLICITACAO_MEMBRO_NAO_ENCONTRADO = "Solicitação de Membro não encontrado.";
    public static final String SOLICITACAO_MEMBRO_LISTAGEM = "solicitacao-membro/listagem";
    public static final String SOLICITACAO_MEMBRO_FORMULARIO = "solicitacao-membro/formulario";
    public static final String SOLICITACAO_MEMBRO_SOLICITAR = "solicitacao-membro/solicitar";
    public static final String SOLICITACAO_MEMBROS = "solicitacaoMembros";
    public static final String FORM_ACTION = "formAction";

    @Autowired
    private SolicitacaoMembroService solicitacaoMembroService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PessoaService pessoaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String listagem(Model model){
        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

    @GetMapping("/salvar")
    public String prepararSalvar(ModelMap model){
      model.addAttribute("solicitacaoMembro", new SolicitacaoMembro());
      model.addAttribute("projetos", projetoService.findAll());
      model.addAttribute("pessoas", pessoaService.findAllFuncionarios());
      model.addAttribute(FORM_ACTION, "salvar");

      return SOLICITACAO_MEMBRO_FORMULARIO;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("solicitacaoMembro") SolicitacaoMembroDto solicitacaoMembroDto, Model model){
        SolicitacaoMembro membro = new SolicitacaoMembro();
        BeanUtils.copyProperties(solicitacaoMembroDto, membro);
        membro.setCriadoEm(new Date());
        membro.setStatus(StatusSolicitacaoMembro.SOLICITADO);
        solicitacaoMembroService.saveOrUpdate(membro);
        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

    @GetMapping("/editar")
    public String prepararEditar(@RequestParam String id, Model model){
        Optional<SolicitacaoMembro> solicitacaoMembro = solicitacaoMembroService.findById(UUID.fromString(id));
        if (!solicitacaoMembro.isPresent()) {
            throw new IllegalArgumentException(SOLICITACAO_MEMBRO_NAO_ENCONTRADO);
        }
        model.addAttribute("solicitacaoMembro", solicitacaoMembro.get());
        model.addAttribute("projetos", projetoService.findAll());
        model.addAttribute("pessoas", pessoaService.findAllFuncionarios());
        model.addAttribute(FORM_ACTION, "editar");

        return SOLICITACAO_MEMBRO_FORMULARIO;
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("solicitacaoMembro") SolicitacaoMembroDto solicitacaoMembroDto, Model model){
        SolicitacaoMembro membro = new SolicitacaoMembro();
        BeanUtils.copyProperties(solicitacaoMembroDto, membro);
        membro.setAtualizadoEm(new Date());
        solicitacaoMembroService.saveOrUpdate(membro);
        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

    @GetMapping("/remover")
    public String remover(@RequestParam String id, Model model){
        Optional<SolicitacaoMembro> solicitacaoMembro = solicitacaoMembroService.findById(UUID.fromString(id));
        if (!solicitacaoMembro.isPresent()) {
            throw new IllegalArgumentException(SOLICITACAO_MEMBRO_NAO_ENCONTRADO);
        }

        solicitacaoMembroService.delete(solicitacaoMembro.get());
        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

    @GetMapping("/aprovar")
    public String aprovar(@RequestParam String id, Model model){
        Optional<SolicitacaoMembro> solicitacaoMembroBanco = solicitacaoMembroService.findById(UUID.fromString(id));
        if (!solicitacaoMembroBanco.isPresent()) {
            throw new IllegalArgumentException(SOLICITACAO_MEMBRO_NAO_ENCONTRADO);
        }

        SolicitacaoMembro solicitacaoMembro = solicitacaoMembroBanco.get();
        solicitacaoMembro.setAtualizadoEm(new Date());
        solicitacaoMembro.setStatus(StatusSolicitacaoMembro.APROVADO);
        solicitacaoMembroService.saveOrUpdate(solicitacaoMembro);

        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

    @GetMapping("/reprovar")
    public String reprovar(@RequestParam String id, Model model){
        Optional<SolicitacaoMembro> solicitacaoMembroBanco = solicitacaoMembroService.findById(UUID.fromString(id));
        if (!solicitacaoMembroBanco.isPresent()) {
            throw new IllegalArgumentException(SOLICITACAO_MEMBRO_NAO_ENCONTRADO);
        }

        SolicitacaoMembro solicitacaoMembro = solicitacaoMembroBanco.get();
        solicitacaoMembro.setAtualizadoEm(new Date());
        solicitacaoMembro.setStatus(StatusSolicitacaoMembro.REPROVADO);
        solicitacaoMembroService.saveOrUpdate(solicitacaoMembro);

        List<SolicitacaoMembro> solicitacaoMembros = solicitacaoMembroService.findAll();
        model.addAttribute(SOLICITACAO_MEMBROS, solicitacaoMembros);
        return SOLICITACAO_MEMBRO_LISTAGEM;
    }

}
