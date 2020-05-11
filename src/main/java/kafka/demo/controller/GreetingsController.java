package kafka.demo.controller;

import kafka.demo.MessageProducer;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/greetings")
public class GreetingsController {

    @Inject
    MessageProducer messageProducer;

    @Get
    public String greet() {
        messageProducer.send("Hello User");
        return "Hello User";
    }
}
