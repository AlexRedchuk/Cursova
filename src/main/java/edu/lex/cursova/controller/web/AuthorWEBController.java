package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.author.impls.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/author")
public class AuthorWEBController {
    @Autowired
    AuthorServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("authors", service.getAll());
        return "authorList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("authors", service.getAll());
        return "authorList";
    }
}
