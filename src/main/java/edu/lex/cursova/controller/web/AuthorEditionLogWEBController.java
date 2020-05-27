package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.model.Edition;
import edu.lex.cursova.service.author.impls.AuthorServiceImpl;
import edu.lex.cursova.service.authorEditionLog.impls.AuthorEditionLogServiceImpl;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/authorEditionLog")
public class AuthorEditionLogWEBController {
    @Autowired
    AuthorEditionLogServiceImpl service;

    @Autowired
    AuthorServiceImpl authorService;


    @Autowired
    EditionServiceImpl editionService;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "authorEditionLogList";
    }


    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<AuthorEditionLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authorEditionLogs", list);
        return "authorEditionLogList";
    }

    @RequestMapping(value = "/list/sortedByAuthor", method = RequestMethod.GET)
    String sortAuthor(Model model){
        List<AuthorEditionLog> list = service.sortByAuthor();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("authorEditionLogs", list);
        model.addAttribute("searchForm", searchForm);
        return "authorEditionLogList";
    }

    @RequestMapping(value = "/list/sortedByEdition", method = RequestMethod.GET)
    String sortEdition(Model model){
        List<AuthorEditionLog> list = service.sortByEdition();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("authorEditionLogs", list);
        model.addAttribute("searchForm", searchForm);
        return "authorEditionLogList";
    }


    @RequestMapping(value = "/list/sortedByAuthor", method = RequestMethod.POST)
    public String searchSortedByAuthor(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<AuthorEditionLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authorEditionLogs", list);
        return "authorEditionLogList";
    }

    @RequestMapping(value = "/list/sortedByEdition", method = RequestMethod.POST)
    public String searchSortedSortedByEdition(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<AuthorEditionLog> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authorEditionLogs", list);
        return "authorEditionLogList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        AuthorEditionLogForm authorEditionLogForm = new AuthorEditionLogForm();

        List<String> authorList = authorService.getAll().stream()
                .map(Author::getFullName).collect(Collectors.toList());

        List<String> editionList = editionService.getAll().stream()
                .map(Edition::getName).collect(Collectors.toList());

        model.addAttribute("authorEditionLogForm", authorEditionLogForm);
        model.addAttribute("authorsL", authorList);
        model.addAttribute("editionsL", editionList);
        return "authorEditionLogAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("authorEditionLogForm")@Valid AuthorEditionLogForm authorEditionLogForm, BindingResult bindingResult) {
        AuthorEditionLog authorEditionLog = new AuthorEditionLog();
        authorEditionLog.setId(null);
        Author author = authorService.getAll().stream()
                .filter(item -> item.getFullName().equals(authorEditionLogForm.getAuthor()) )
                .findFirst().orElse(new Author());
        authorEditionLog.setAuthor(author);
        Edition edition = editionService.getAll().stream()
                .filter(item -> item.getName().equals(authorEditionLogForm.getEdition()) )
                .findFirst().orElse(new Edition());
        authorEditionLog.setEdition(edition);
        authorEditionLog.setAdditionalInformation(authorEditionLogForm.getAdditionalInformation());
        if(bindingResult.hasErrors()){
            if (bindingResult.hasFieldErrors("additionalInfomation")) {
                System.out.println("Validation error(Author Edition log table): Too much additional information");
            }
            return "authorEditionLogAdd";
        }
        service.save(authorEditionLog);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        AuthorEditionLogForm authorEditionLogForm = new AuthorEditionLogForm();
        AuthorEditionLog authorEditionLog = service.get(id);
        authorEditionLogForm.setAuthor(authorEditionLog.getAuthor().getFullName());
        authorEditionLogForm.setEdition(authorEditionLog.getEdition().getName());
        authorEditionLogForm.setAdditionalInformation(authorEditionLog.getAdditionalInformation());
        List<String> authorList = authorService.getAll().stream()
                .map(Author::getFullName).collect(Collectors.toList());

        List<String> editionList = editionService.getAll().stream()
                .map(Edition::getName).collect(Collectors.toList());

        model.addAttribute("authorsL", authorList);
        model.addAttribute("editionsL", editionList);
        model.addAttribute("authorEditionLogForm", authorEditionLogForm);
        return "authorEditionLogAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("authorEditionLogForm")@Valid AuthorEditionLogForm authorEditionLogForm, BindingResult bindingResult) {
        Author author = authorService.getAll().stream()
                .filter(item -> item.getFullName().equals(authorEditionLogForm.getAuthor()) )
                .findFirst().orElse(new Author());
        Edition edition = editionService.getAll().stream()
                .filter(item -> item.getName().equals(authorEditionLogForm.getEdition()) )
                .findFirst().orElse(new Edition());
        AuthorEditionLog authorEditionLogEdited = new AuthorEditionLog();
        authorEditionLogEdited.setId(id);
        authorEditionLogEdited.setAuthor(author);
        authorEditionLogEdited.setEdition(edition);
        authorEditionLogEdited.setAdditionalInformation(authorEditionLogForm.getAdditionalInformation());
        if(bindingResult.hasErrors()){
            if (bindingResult.hasFieldErrors("additionalInformation")) {
                System.out.println("Validation error(Author edition log table): Too much additional information");
            }

            return "authorEditionLogAdd";
        }
        service.edit(authorEditionLogEdited);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }
}
