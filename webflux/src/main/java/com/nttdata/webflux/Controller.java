package com.nttdata.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class Controller {
    @GetMapping(path="/numbers", produces="text/event-stream")
    public Flux<Integer> numbers(){
        Flux<Integer> flux=Flux.range(1,30).delayElements(Duration.ofSeconds(1));
        return flux;
    }


    @GetMapping(path = "/numbers-with-subscribers", produces = "text/event-stream")
    public Flux<Integer> numbersWithSubscribers() {

        Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));

        // Suscriptor 1
        flux.subscribe(n -> Suscriber.print(n));

        // Suscriptor 2
        flux.subscribe(n -> System.out.println("Subscriber 2: " + n));

        // Suscriptor 3
        return flux;

    }
}
