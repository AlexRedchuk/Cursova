package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.EditionForm;
import edu.lex.cursova.form.EditionOrderLogForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("web/edition")
public class EditionWEBController {
    @Autowired
    EditionServiceImpl service;

    @Autowired
    EditionDirectionServiceImpl editionDirectionService;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", service.getAll());
        return "editionList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByEditionCode", method = RequestMethod.GET)
    String sortEditionCode(Model model){
        List<Edition> list = service.sortByEditionCode();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editions", list);
        model.addAttribute("searchForm", searchForm);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByName", method = RequestMethod.GET)
    String sortName(Model model){
        List<Edition> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editions", list);
        model.addAttribute("searchForm", searchForm);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByNumberOfPages", method = RequestMethod.GET)
    String sortNumberOfPages(Model model){
        List<Edition> list = service.sortByNumberOfPages();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editions", list);
        model.addAttribute("searchForm", searchForm);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByCirculation", method = RequestMethod.GET)
    String sortCirculation(Model model){
        List<Edition> list = service.sortByCirculation();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editions", list);
        model.addAttribute("searchForm", searchForm);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByEditionDirection", method = RequestMethod.GET)
    String sortEditionDirection(Model model){
        List<Edition> list = service.sortByEditionDirection();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editions", list);
        model.addAttribute("searchForm", searchForm);
        return "editionList";
    }


    @RequestMapping(value = "/list/sortedByEditionCode", method = RequestMethod.POST)
    public String searchSortedByEditionCode(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByName", method = RequestMethod.POST)
    public String searchSortedSortedByName(Model model,
                                              @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByNubmerOfPages", method = RequestMethod.POST)
    public String searchSortedSortedByNumberOfPages(Model model,
                                           @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByCirculation", method = RequestMethod.POST)
    public String searchSortedSortedByCirculation(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping(value = "/list/sortedByEditionDirection", method = RequestMethod.POST)
    public String searchSortedSortedByEditionDirection(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Edition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editions", list);
        return "editionList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editions", service.getAll());
        return "redirect:/web/edition/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        EditionForm editionForm = new EditionForm();

        List<String> editionDirectionList = editionDirectionService.getAll().stream()
                .map(EditionDirection::getName).collect(Collectors.toList());

        model.addAttribute("editionForm", editionForm);
        model.addAttribute("editionDirectionsL", editionDirectionList);
        return "editionAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("editionForm") EditionForm editionForm) {
        Edition edition = new Edition();
        edition.setId(null);
        edition.setEditionCode(editionForm.getEditionCode());
        edition.setName(editionForm.getName());
        edition.setNumberOfPages(editionForm.getNumberOfPages());
        edition.setCirculation(editionForm.getCirculation());
        EditionDirection editionDirection = editionDirectionService.getAll().stream()
                .filter(item -> item.getName().equals(editionForm.getEditionDirection()) )
                .findFirst().orElse(new EditionDirection());
        edition.setEditionDirection(editionDirection);
        service.save(edition);
        model.addAttribute("editions", service.getAll());
        return "redirect:/web/edition/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        EditionForm editionForm = new EditionForm();
        Edition edition = service.get(id);
        editionForm.setEditionCode(edition.getEditionCode());
        editionForm.setName(edition.getName());
        editionForm.setNumberOfPages(edition.getNumberOfPages());
        editionForm.setCirculation(edition.getCirculation());
        editionForm.setEditionDirection(edition.getEditionDirection().getName());
        List<String> editionDirectionList = editionDirectionService.getAll().stream()
                .map(EditionDirection::getName).collect(Collectors.toList());

        model.addAttribute("editionDirectionsL", editionDirectionList);
        model.addAttribute("editionForm", editionForm);
        return "editionAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("editionorm") EditionForm editionForm) {

        EditionDirection editionDirection = editionDirectionService.getAll().stream()
                .filter(item -> item.getName().equals(editionForm.getEditionDirection()) )
                .findFirst().orElse(new EditionDirection());
        Edition editionEdited = new Edition();
        editionEdited.setId(id);
        editionEdited.setEditionCode(editionForm.getEditionCode());
        editionEdited.setName(editionForm.getName());
        editionEdited.setNumberOfPages(editionForm.getNumberOfPages());
        editionEdited.setCirculation(editionForm.getCirculation());
        editionEdited.setEditionDirection(editionDirection);
        service.edit(editionEdited);
        model.addAttribute("editions", service.getAll());
        return "redirect:/web/edition/list";
    }
}
