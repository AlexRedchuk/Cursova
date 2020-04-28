package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.EditionForm;
import edu.lex.cursova.form.EditionOrderLogForm;
import edu.lex.cursova.model.Edition;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.model.Order;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("editions", service.getAll());
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


        Map<String, String> editionDirectionMap = editionDirectionService.getAll().stream()
                .collect(Collectors.toMap(EditionDirection::getId, EditionDirection::getName));

        List<String> editionDirectionList = editionDirectionService.getAll().stream()
                .map(EditionDirection::getName).collect(Collectors.toList());

        model.addAttribute("editionForm", editionForm);
        model.addAttribute("editionDirections", editionDirectionMap);
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
