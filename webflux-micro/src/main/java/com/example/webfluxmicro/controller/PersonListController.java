package com.example.webfluxmicro.controller;

import com.example.webfluxmicro.model.Person;
import com.example.webfluxmicro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

@Controller
public class PersonListController {

    @Autowired
    PersonService personService;

    @GetMapping("/personlist")
    public String personList(final Model model) {

        final Flux<Person> personList= personService.allPersons();
        model.addAttribute("personlist", personList);
        return "personList";
    }
}
