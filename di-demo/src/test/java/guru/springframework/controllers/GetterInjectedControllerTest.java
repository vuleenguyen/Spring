package guru.springframework.controllers;

import guru.springframework.controller.GetterInjectedControler;
import guru.springframework.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
public class GetterInjectedControllerTest {

    private GetterInjectedControler getterInjectedControlerer;

    @Before
    public void setUp() throws Exception {
        this.getterInjectedControlerer = new GetterInjectedControler();
        this.getterInjectedControlerer.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws  Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, getterInjectedControlerer.sayHello());
    }
}
