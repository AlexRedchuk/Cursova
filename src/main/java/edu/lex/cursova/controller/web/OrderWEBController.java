package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.OrderForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", service.getAll());
        return "orderList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Order> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByCustomer", method = RequestMethod.GET)
    String sortCustomer(Model model){
        List<Order> list = service.sortByCustomer();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("orders", list);
        model.addAttribute("searchForm", searchForm);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByNumberOfOrder", method = RequestMethod.GET)
    String sortNumberOfOrder(Model model){
        List<Order> list = service.sortByNumberOfOrder();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("orders", list);
        model.addAttribute("searchForm", searchForm);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByPrintery", method = RequestMethod.GET)
    String sortPrintery(Model model){
        List<Order> list = service.sortByPrintery();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("orders", list);
        model.addAttribute("searchForm", searchForm);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByType", method = RequestMethod.GET)
    String sortType(Model model){
        List<Order> list = service.sortByType();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("orders", list);
        model.addAttribute("searchForm", searchForm);
        return "orderList";
    }


    @RequestMapping(value = "/list/sortedByCustomer", method = RequestMethod.POST)
    public String searchSortedSortedByCustomer(Model model,
                                           @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Order> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByNumberOfOrder", method = RequestMethod.POST)
    public String searchSortedSortedByNumberOfOrder(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Order> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByPrintery", method = RequestMethod.POST)
    public String searchSortedSortedPrintery(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Order> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "orderList";
    }

    @RequestMapping(value = "/list/sortedByType", method = RequestMethod.POST)
    public String searchSortedSortedByType(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Order> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
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
    String create(Model model, @ModelAttribute("orderForm")@Valid OrderForm orderForm, BindingResult bindingResult) {
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
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("numberOfOrder")){
                System.out.println("Validation error(Order table): Unvalid number of order entered");
            }
            return "error";
        }
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
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("orderForm")@Valid OrderForm orderForm,
                BindingResult bindingResult) {
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
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("numberOfOrder")){
                System.out.println("Validation error(Order table): Unvalid number of order entered");
            }
            return "error";
        }
        service.edit(orderEdited);
        model.addAttribute("orders", service.getAll());
        return "redirect:/web/order/list";
    }
}

