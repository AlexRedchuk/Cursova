package edu.lex.cursova.controller.web;

import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/productType")
public class ProductTypeWEBController {
    @Autowired
    ProductTypeServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("productTypes", service.getAll());
        return "productTypeList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("productTypes", service.getAll());
        return "redirect:/web/productType/list";
    }
}