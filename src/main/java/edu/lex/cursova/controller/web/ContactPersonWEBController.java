package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/contactPerson")
public class ContactPersonWEBController {
    @Autowired
    ContactPersonServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("contactPersons", service.getAll());
        return "contactPersonList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("contactPersons", service.getAll());
        return "contactPersonList";
    }
}