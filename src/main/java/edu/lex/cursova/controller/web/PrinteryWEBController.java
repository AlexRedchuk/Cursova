package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.PrinteryForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/printery")
public class PrinteryWEBController {
    @Autowired
    PrinteryServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("printeries", service.getAll());
        return "printeryList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Printery> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("printeries", list);
        return "printeryList";
    }

    @RequestMapping(value = "/list/sortedByName", method = RequestMethod.GET)
    String sortName(Model model){
        List<Printery> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("printeries", list);
        model.addAttribute("searchForm", searchForm);
        return "printeryList";
    }

    @RequestMapping(value = "/list/sortedByAddress", method = RequestMethod.GET)
    String sortAddress(Model model){
        List<Printery> list = service.sortByAddress();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("printeries", list);
        model.addAttribute("searchForm", searchForm);
        return "printeryList";
    }

    @RequestMapping(value = "/list/sortedByName", method = RequestMethod.POST)
    public String searchSortedByName(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Printery> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("printeries", list);
        return "printeryList";
    }

    @RequestMapping(value = "/list/sortedByAddress", method = RequestMethod.POST)
    public String searchSortedByAddress(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Printery> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("printeries", list);
        return "printeryList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        PrinteryForm printeryForm = new PrinteryForm();
        model.addAttribute("printeryForm", printeryForm);
        return "printeryAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("printeryForm")@Valid PrinteryForm printeryForm, BindingResult bindingResult) {
        Printery printery = new Printery();
        printery.setName(printeryForm.getName());
        printery.setAddress(printeryForm.getAddress());
        printery.setPhoneNumber(printeryForm.getPhoneNumber());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("name")){
                System.out.println("Validation error(Printery table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("address")){
                System.out.println("Validation error(Printery table): Unvalid address entered");
            }
            if(bindingResult.hasFieldErrors("phoneNumber")){
                System.out.println("Validation error(Printery table): Unvalid phone number entered");
            }
            return "printeryAdd";
        }
        service.save(printery);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Printery printery = service.get(id);
        PrinteryForm printeryForm = new PrinteryForm();
        printeryForm.setName(printery.getName());
        printeryForm.setAddress(printery.getAddress());
        printeryForm.setPhoneNumber(printery.getPhoneNumber());
        model.addAttribute("printeryForm", printeryForm);
        return "printeryAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("printeryForm")@Valid PrinteryForm printeryForm,
                BindingResult bindingResult) {
        Printery printery = new Printery();
        printery.setId(id);
        printery.setName(printeryForm.getName());
        printery.setAddress(printeryForm.getAddress());
        printery.setPhoneNumber(printeryForm.getPhoneNumber());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("name")){
                System.out.println("Validation error(Printery table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("address")){
                System.out.println("Validation error(Printery table): Unvalid address entered");
            }
            if(bindingResult.hasFieldErrors("phoneNumber")){
                System.out.println("Validation error(Printery table): Unvalid phone number entered");
            }
            return "printeryAdd";
        }
        service.save(printery);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }
}
