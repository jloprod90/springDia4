package com.example.webfluxmicro.service;

import com.example.webfluxmicro.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@Service
public class PersonService {
    public Flux<Person> allPersons(){
        Flux<Person> p1= WebClient.create("http://localhost:8080/person1").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> p2= WebClient.create("http://localhost:8080/person2").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> p3= WebClient.create("http://localhost:8080/person3").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> p4= WebClient.create("http://localhost:8080/person4").get().retrieve().bodyToFlux(Person.class);

        Flux <Person> allFlux = Flux.merge(p1,p2,p3,p4);
        return allFlux;
    }
}
