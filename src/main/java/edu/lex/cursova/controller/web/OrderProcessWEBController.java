package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.orderProcess.impls.OrderProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/orderProcess")
public class OrderProcessWEBController {
    @Autowired
    OrderProcessServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("orderProcesses", service.getAll());
        return "orderProcessList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("orderProcesses", service.getAll());
        return "orderProcessList";
    }
}
