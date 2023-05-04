package ufrn.br.aulamvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.aulamvc.model.Postagem;
import ufrn.br.aulamvc.repository.PostRepository;

@Controller
public class PostController {

    PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
        this.repository.doInit();
    }

    @RequestMapping(value = {"/", "/posts"}, method = RequestMethod.GET)
    public String doGet(Model model, HttpServletRequest request){
        model.addAttribute("posts", repository.listAll());
        return "index";
    }

    @RequestMapping(value = "/formCadastro", method = RequestMethod.GET)
    public String doFormPage(Model model){

        Postagem p = new Postagem("NovaPostagem", "NovoAutor");
        model.addAttribute("postagem", p);

        return "formCadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvarPostagem(@ModelAttribute Postagem p){
        repository.save(p);
        return "redirect:/";
    }

    @RequestMapping(value = "/formEditar/{id}", method = RequestMethod.GET)
    public String doEditarPage(Model model, @PathVariable(name = "id") Integer id){

        Postagem p = repository.listAll().get(id);
        model.addAttribute("postagem", p);
        return "formEditar";
    }

    @RequestMapping(value = "/salvarEdit", method = RequestMethod.POST)
    public String doSalvarEditPostagem(@ModelAttribute Postagem p){
        repository.update(p);
        return "redirect:/";
    }
}






