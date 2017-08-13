package guru.springframework.controllers;

import guru.springframework.controller.ConstructorInjectedControler;
import guru.springframework.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
public class ConstructorInjectedControllerTest {

    private ConstructorInjectedControler constructorInjectedControler;

    @Before
    public void setUp() throws Exception {
        this.constructorInjectedControler = new ConstructorInjectedControler(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws  Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, constructorInjectedControler.sayHello());
    }
}
