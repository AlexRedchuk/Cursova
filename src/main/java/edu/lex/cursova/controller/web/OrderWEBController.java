package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.OrderForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/order")
public class OrderWEBController {
    @Autowired
    OrderServiceImpl service;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @Autowired
    PrinteryServiceImpl printeryService;

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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        OrderForm orderForm = new OrderForm();

        List<String> customerList = customerService.getAll().stream()
                .map(Customer::getName).collect(Collectors.toList());

        List<String> productTypeList = productTypeService.getAll().stream()
                .map(ProductType::getName).collect(Collectors.toList());

        List<String> printeryList = printeryService.getAll().stream()
                .map(Printery::getName).collect(Collectors.toList());

        model.addAttribute("orderForm", orderForm);
        model.addAttribute("customersL", customerList);
        model.addAttribute("productTypesL", productTypeList);
        model.addAttribute("printeriesL", printeryList);
        return "orderAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("orderForm") OrderForm orderForm) {
        Order order = new Order();
        order.setId(null);
        order.setNumberOfOrder(orderForm.getNumberOfOrder());
        Customer customer = customerService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getCustomer()) )
                .findFirst().orElse(new Customer());
        order.setCustomer(customer);
        ProductType productType = productTypeService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getProductType()) )
                .findFirst().orElse(new ProductType());
        order.setProductType(productType);
        Printery printery = printeryService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getPrintery()) )
                .findFirst().orElse(new Printery());
        order.setPrintery(printery);
        service.save(order);
        model.addAttribute("orders", service.getAll());
        return "redirect:/web/order/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        OrderForm orderForm = new OrderForm();
        Order order = service.get(id);
        orderForm.setNumberOfOrder(order.getNumberOfOrder());
        orderForm.setCustomer(order.getCustomer().getName());
        orderForm.setProductType(order.getProductType().getName());
        orderForm.setPrintery(order.getPrintery().getName());

        List<String> customerList = customerService.getAll().stream()
                .map(Customer::getName).collect(Collectors.toList());

        List<String> productTypeList = productTypeService.getAll().stream()
                .map(ProductType::getName).collect(Collectors.toList());

        List<String> printeryList = printeryService.getAll().stream()
                .map(Printery::getName).collect(Collectors.toList());

        model.addAttribute("customersL", customerList);
        model.addAttribute("productTypesL", productTypeList);
        model.addAttribute("printeriesL", printeryList);
        model.addAttribute("orderForm", orderForm);
        return "orderAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("orderForm") OrderForm orderForm) {
        Customer customer = customerService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getCustomer()) )
                .findFirst().orElse(new Customer());
        ProductType productType = productTypeService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getProductType()) )
                .findFirst().orElse(new ProductType());
        Printery printery = printeryService.getAll().stream()
                .filter(item -> item.getName().equals(orderForm.getPrintery()) )
                .findFirst().orElse(new Printery());
        Order orderEdited = new Order();
        orderEdited.setId(id);
        orderEdited.setNumberOfOrder(orderForm.getNumberOfOrder());
        orderEdited.setCustomer(customer);
        orderEdited.setProductType(productType);
        orderEdited.setPrintery(printery);
        service.edit(orderEdited);
        model.addAttribute("orders", service.getAll());
        return "redirect:/web/order/list";
    }
}

