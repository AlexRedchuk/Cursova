package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.authorEditionLog.impls.AuthorEditionLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/authorEditionLog")
public class AuthorEditionLogWEBController {
    @Autowired
    AuthorEditionLogServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("authorEditionLogs", service.getAll());
        return "authorEditionLogList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }
}
