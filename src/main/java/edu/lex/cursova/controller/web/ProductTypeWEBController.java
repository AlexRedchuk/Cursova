package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.EditionDirectionForm;
import edu.lex.cursova.form.ProductTypeForm;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ProductTypeForm productTypeForm= new ProductTypeForm();
        model.addAttribute("productTypeForm", productTypeForm);
        return "productTypeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("productTypeForm") ProductTypeForm productTypeForm) {
        ProductType productType = new ProductType();
        productType.setName(productTypeForm.getName());
        productType.setDescription(productTypeForm.getDescription());
        service.save(productType);
        model.addAttribute("productTypes", service.getAll());
        return "redirect:/web/productType/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        ProductType productType = service.get(id);
        ProductTypeForm productTypeForm = new ProductTypeForm();
        productTypeForm.setName(productType.getName());
        productTypeForm.setDescription(productType.getDescription());
        model.addAttribute("productTypeForm", productTypeForm);
        return "productTypeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("productTypeForm")
            ProductTypeForm productTypeForm) {
        ProductType productType = new ProductType();
        productType.setId(id);
        productType.setName(productTypeForm.getName());
        productType.setDescription(productTypeForm.getDescription());
        service.save(productType);
        model.addAttribute("productTypes", service.getAll());
        return "redirect:/web/productType/list";
    }
}