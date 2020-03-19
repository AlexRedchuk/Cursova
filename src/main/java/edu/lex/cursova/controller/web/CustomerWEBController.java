package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/customer")
public class CustomerWEBController {
    @Autowired
    CustomerServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customer/list";
    }
}