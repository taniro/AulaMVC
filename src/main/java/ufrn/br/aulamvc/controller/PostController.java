package ufrn.br.aulamvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.aulamvc.model.Post;
import ufrn.br.aulamvc.repository.PostRepository;

import java.io.IOException;
import java.util.List;

@Controller
public class PostController {

    PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String doGet(Model model){

        Post p = new Post("Hello", "Taniro");
        model.addAttribute("post", p);
        repository.save(p);
        return "index";
    }
}
