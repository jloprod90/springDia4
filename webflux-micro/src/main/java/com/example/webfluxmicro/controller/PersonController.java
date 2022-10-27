package com.example.webfluxmicro.controller;

import com.example.webfluxmicro.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class PersonController {

    @GetMapping("/person1")
    public Flux<Person> personGenerate1(){
        Person karim=new Person("Karim", "Benzema", 34);
        return Flux.just(karim).delayElements(Duration.ofSeconds(5));
    }

    @GetMapping("/person2")
    public Flux<Person> personGenerate2(){
        Person tony=new Person("Toni", "Kross", 32);
        return Flux.just(tony).delayElements(Duration.ofSeconds(5));

    }

    @GetMapping("/person3")
    public Flux<Person> personGenerate3(){
        Person luca=new Person("Luca", "Modric", 37);
       return Flux.just(luca).delayElements(Duration.ofSeconds(5));

    }

    @GetMapping("/person4")
    public Flux<Person> personGenerate4(){
        Person rodrygo=new Person("Rodrygo", "Goes", 20);
       return Flux.just(rodrygo).delayElements(Duration.ofSeconds(5));

    }
}
