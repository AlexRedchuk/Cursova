package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.EditionDirectionForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/editionDirection")
public class EditionDirectionWEBController {
    @Autowired
    EditionDirectionServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionDirections", service.getAll());
        return "editionDirectionList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<EditionDirection> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionDirections", list);
        return "editionDirectionList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<EditionDirection> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editionDirections", list);
        model.addAttribute("searchForm", searchForm);
        return "editionDirectionList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<EditionDirection> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionDirections", list);
        return "editionDirectionList";
    }


    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editionDirections", service.getAll());
        return "redirect:/web/editionDirection/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        EditionDirectionForm editionDirectionForm = new EditionDirectionForm();
        model.addAttribute("editionDirectionForm", editionDirectionForm);
        return "editionDirectionAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("editionDirectionForm") EditionDirectionForm editionDirectionForm) {
        EditionDirection editionDirection = new EditionDirection();
        editionDirection.setName(editionDirectionForm.getName());
        editionDirection.setDescription(editionDirectionForm.getDescription());
        service.save(editionDirection);
        model.addAttribute("editionDirections", service.getAll());
        return "redirect:/web/editionDirection/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        EditionDirection editionDirection = service.get(id);
        EditionDirectionForm editionDirectionForm = new EditionDirectionForm();
        editionDirectionForm.setName(editionDirection.getName());
        editionDirectionForm.setDescription(editionDirection.getDescription());
        model.addAttribute("editionDirectionForm", editionDirectionForm);
        return "editionDirectionAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("editionDirectionForm")
            EditionDirectionForm editionDirectionForm) {
        EditionDirection editionDirection = new EditionDirection();
        editionDirection.setId(id);
        editionDirection.setName(editionDirectionForm.getName());
        editionDirection.setDescription(editionDirectionForm.getDescription());
        service.save(editionDirection);
        model.addAttribute("editionDirections", service.getAll());
        return "redirect:/web/editionDirection/list";
    }
}