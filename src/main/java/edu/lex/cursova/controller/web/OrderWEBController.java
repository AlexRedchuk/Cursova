package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/order")
public class OrderWEBController {
    @Autowired
    OrderServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("orders", service.getAll());
        return "orderList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("orders", service.getAll());
        return "redirect:/web/order/list";
    }
}

