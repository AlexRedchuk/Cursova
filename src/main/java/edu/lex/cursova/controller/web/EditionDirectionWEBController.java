package edu.lex.cursova.controller.web;

import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/editionDirection")
public class EditionDirectionWEBController {
    @Autowired
    EditionDirectionServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("editionDirections", service.getAll());
        return "editionDirectionList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editionDirections", service.getAll());
        return "redirect:/web/editionDirection/list";
    }
}