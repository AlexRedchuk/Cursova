package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/printery")
public class PrinteryWEBController {
    @Autowired
    PrinteryServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("printeries", service.getAll());
        return "printeryList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("printeries", service.getAll());
        return "printeryList";
    }
}
