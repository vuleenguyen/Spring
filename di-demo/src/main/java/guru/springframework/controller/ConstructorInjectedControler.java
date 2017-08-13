package guru.springframework.controller;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
@Controller
public class ConstructorInjectedControler {

    private GreetingService greetingService;

    public ConstructorInjectedControler(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
