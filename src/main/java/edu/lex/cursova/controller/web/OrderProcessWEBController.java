package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.EditionOrderLogForm;
import edu.lex.cursova.form.OrderProcessForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import edu.lex.cursova.service.orderProcess.impls.OrderProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/orderProcess")
public class OrderProcessWEBController {
    @Autowired
    OrderProcessServiceImpl service;

    @Autowired
    OrderServiceImpl orderService;

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
        return "redirect:/web/orderProcess/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        OrderProcessForm orderProcessForm = new OrderProcessForm();

        List<String> orderList = orderService.getAll().stream()
                .map(Order::getNumberOfOrder).collect(Collectors.toList());

        model.addAttribute("orderProcessForm", orderProcessForm);
        model.addAttribute("ordersL", orderList);
        return "orderProcessAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("orderProcessForm") OrderProcessForm orderProcessForm) {
        OrderProcess orderProcess = new OrderProcess();
        orderProcess.setId(null);
        Order order = orderService.getAll().stream()
                .filter(item -> item.getNumberOfOrder().equals(orderProcessForm.getOrder()) )
                .findFirst().orElse(new Order());
        orderProcess.setOrder(order);
        orderProcess.setAcceptDate(LocalDateTime.now());
        orderProcess.setCompletionDate(LocalDateTime.now());
        String complitation = orderProcessForm.getIsComplited();

        service.save(orderProcess);
        model.addAttribute("orderProcesses", service.getAll());
        return "redirect:/web/orderProcess/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        OrderProcessForm orderProcessForm = new OrderProcessForm();
        OrderProcess orderProcess = service.get(id);
        orderProcessForm.setOrder(orderProcess.getOrder().getNumberOfOrder());
        List<String> orderList = orderService.getAll().stream()
                .map(Order::getNumberOfOrder).collect(Collectors.toList());
        orderProcessForm.setAcceptDate(LocalDateTime.now());
        orderProcessForm.setCompletionDate(LocalDateTime.now());
        model.addAttribute("ordersL", orderList);
        model.addAttribute("orderProcessForm", orderProcessForm);
        return "orderProcessAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("orderProcessForm") OrderProcessForm orderProcessForm) {

        OrderProcess orderProcessEdited = new OrderProcess();
        orderProcessEdited.setId(id);
        Order order = orderService.getAll().stream()
                .filter(item -> item.getNumberOfOrder().equals(orderProcessForm.getOrder()) )
                .findFirst().orElse(new Order());
        orderProcessEdited.setOrder(order);
        orderProcessEdited.setAcceptDate(LocalDateTime.now());
        orderProcessEdited.setCompletionDate(LocalDateTime.now());
        service.edit(orderProcessEdited);
        model.addAttribute("orderProcesses", service.getAll());
        return "redirect:/web/orderProcess/list";
    }
}
