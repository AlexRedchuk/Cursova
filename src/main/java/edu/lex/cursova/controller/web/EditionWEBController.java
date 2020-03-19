package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/edition")
public class EditionWEBController {
    @Autowired
    EditionServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("editions", service.getAll());
        return "editionList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editions", service.getAll());
        return "redirect:/web/edition/list";
    }
}
