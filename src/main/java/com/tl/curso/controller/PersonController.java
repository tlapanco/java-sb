package com.tl.curso.controller;

import com.tl.curso.entities.Person;
import com.tl.curso.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tl
 */
@Controller
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index(Model model) {
        List<Person> peopleList = personService.getAll();
        model.addAttribute("peopleList", peopleList);
        return "people";
    }

    /*Create person */
    @GetMapping("/createPerson")
    public String createPersonForm(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("action", "/savePerson");
        return "createPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute Person person) {
        personService.createPerson(person);
        return "redirect:/";
    }

    /*Edit person*/
    @GetMapping("/editPerson/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("action", "/updatePerson/" + id);
        return "editPerson";
    }

    @PostMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute Person person) {
        personService.updatePerson(id, person);
        return "redirect:/";
    }

    /*Delete person*/
    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/";
    }

}
