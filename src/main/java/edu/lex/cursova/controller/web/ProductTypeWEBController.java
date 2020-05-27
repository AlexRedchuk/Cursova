package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.EditionDirectionForm;
import edu.lex.cursova.form.ProductTypeForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/productType")
public class ProductTypeWEBController {
    @Autowired
    ProductTypeServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("productTypes", service.getAll());
        return "productTypeList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<ProductType> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("productTypes", list);
        return "productTypeList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<ProductType> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("productTypes", list);
        model.addAttribute("searchForm", searchForm);
        return "productTypeList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<ProductType> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("productTypes", list);
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
    String create(Model model, @ModelAttribute("productTypeForm")@Valid ProductTypeForm productTypeForm,
                  BindingResult bindingResult) {
        ProductType productType = new ProductType();
        productType.setName(productTypeForm.getName());
        productType.setDescription(productTypeForm.getDescription());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("name")){
                System.out.println("Validation error(Product type table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("description")){
                System.out.println("Validation error(Product type table): Description is too long");
            }

            return "productTypeAdd";
        }
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
            @Valid ProductTypeForm productTypeForm, BindingResult bindingResult) {
        ProductType productType = new ProductType();
        productType.setId(id);
        productType.setName(productTypeForm.getName());
        productType.setDescription(productTypeForm.getDescription());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("name")){
                System.out.println("Validation error(Product type table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("description")){
                System.out.println("Validation error(Product type table): Description is too long");
            }

            return "productTypeAdd";
        }
        service.save(productType);
        model.addAttribute("productTypes", service.getAll());
        return "redirect:/web/productType/list";
    }
}