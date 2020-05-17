package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.EditionOrderLogForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import edu.lex.cursova.service.editionOrderLog.impls.EditionOrderLogServiceImpl;
import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("web/editionOrderLog")
public class EditionOrderLogWEBController {
    @Autowired
    EditionOrderLogServiceImpl service;

    @Autowired
    EditionServiceImpl editionService;

    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionOrderLogs", service.getAll());
        return "editionOrderLogList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<EditionOrderLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionOrderLogs", list);
        return "editionOrderLogList";
    }

    @RequestMapping(value = "/list/sortedByOrder", method = RequestMethod.GET)
    String sortOrder(Model model){
        List<EditionOrderLog> list = service.sortByOrder();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editionOrderLogs", list);
        model.addAttribute("searchForm", searchForm);
        return "editionOrderLogList";
    }

    @RequestMapping(value = "/list/sortedByEdition", method = RequestMethod.GET)
    String sortEdition(Model model){
        List<EditionOrderLog> list = service.sortByEdition();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("editionOrderLogs", list);
        model.addAttribute("searchForm", searchForm);
        return "editionOrderLogList";
    }


    @RequestMapping(value = "/list/sortedByOrder", method = RequestMethod.POST)
    public String searchSortedByOrder(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<EditionOrderLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionOrderLogs", list);
        return "editionOrderLogList";
    }

    @RequestMapping(value = "/list/sortedByEdition", method = RequestMethod.POST)
    public String searchSortedSortedByEdition(Model model,
                                              @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<EditionOrderLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("editionOrderLogs", list);
        return "editionOrderLogList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("editionOrderLogs", service.getAll());
        return "redirect:/web/editionOrderLog/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        EditionOrderLogForm editionOrderLogForm = new EditionOrderLogForm();

        List<String> orderList = orderService.getAll().stream()
                .map(Order::getNumberOfOrder).collect(Collectors.toList());

        List<String> editionList = editionService.getAll().stream()
                .map(Edition::getName).collect(Collectors.toList());

        model.addAttribute("editionOrderLogForm", editionOrderLogForm);
        model.addAttribute("ordersL", orderList);
        model.addAttribute("editionsL", editionList);
        return "editionOrderLogAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("editionOrderLogForm") EditionOrderLogForm editionOrderLogForm) {
        EditionOrderLog editionOrderLog = new EditionOrderLog();
        editionOrderLog.setId(null);
        Order order = orderService.getAll().stream()
                .filter(item -> item.getNumberOfOrder().equals(editionOrderLogForm.getOrder()) )
                .findFirst().orElse(new Order());
        editionOrderLog.setOrder(order);
        Edition edition = editionService.getAll().stream()
                .filter(item -> item.getName().equals(editionOrderLogForm.getEdition()) )
                .findFirst().orElse(new Edition());
        editionOrderLog.setEdition(edition);
        service.save(editionOrderLog);
        model.addAttribute("editionOrderLogs", service.getAll());
        return "redirect:/web/editionOrderLog/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        EditionOrderLogForm editionOrderLogForm = new EditionOrderLogForm();
        EditionOrderLog editionOrderLog = service.get(id);
        editionOrderLogForm.setOrder(editionOrderLog.getOrder().getNumberOfOrder());
        editionOrderLogForm.setEdition(editionOrderLog.getEdition().getName());
        List<String> orderList = orderService.getAll().stream()
                .map(Order::getNumberOfOrder).collect(Collectors.toList());

        List<String> editionList = editionService.getAll().stream()
                .map(Edition::getName).collect(Collectors.toList());

        model.addAttribute("ordersL", orderList);
        model.addAttribute("editionsL", editionList);
        model.addAttribute("editionOrderLogForm", editionOrderLogForm);
        return "editionOrderLogAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("editionOrderLogForm") EditionOrderLogForm editionOrderLogForm) {
        Order order = orderService.getAll().stream()
                .filter(item -> item.getNumberOfOrder().equals(editionOrderLogForm.getOrder()) )
                .findFirst().orElse(new Order());
        Edition edition = editionService.getAll().stream()
                .filter(item -> item.getName().equals(editionOrderLogForm.getEdition()) )
                .findFirst().orElse(new Edition());
        EditionOrderLog editionOrderLogEdited = new EditionOrderLog();
        editionOrderLogEdited.setId(id);
        editionOrderLogEdited.setOrder(order);
        editionOrderLogEdited.setEdition(edition);
        service.edit(editionOrderLogEdited);
        model.addAttribute("editionOrderLogs", service.getAll());
        return "redirect:/web/editionOrderLog/list";
    }
}
