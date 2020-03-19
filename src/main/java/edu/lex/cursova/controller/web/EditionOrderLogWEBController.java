package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.editionOrderLog.impls.EditionOrderLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/editionOrderLog")
public class EditionOrderLogWEBController {
    @Autowired
    EditionOrderLogServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("editionOrderLogs", service.getAll());
        return "editionOrderLogList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editionOrderLogs", service.getAll());
        return "redirect:/web/editionOrderLog/list";
    }
}
