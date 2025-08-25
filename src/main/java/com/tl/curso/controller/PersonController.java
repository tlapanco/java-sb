package com.tl.curso.controller;

import com.tl.curso.entities.Person;
import com.tl.curso.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}
