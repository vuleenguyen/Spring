package guru.springframework.services;

import org.springframework.stereotype.Service;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus!!!! - Originak";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
