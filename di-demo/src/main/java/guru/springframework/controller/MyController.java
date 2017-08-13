package guru.springframework.controller;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Created by Do My Duyen on 7/27/2017.
 */
@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        System.out.println("hello!!!");
        return greetingService.sayGreeting();
    }
}
