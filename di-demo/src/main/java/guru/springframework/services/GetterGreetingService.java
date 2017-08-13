package guru.springframework.services;

import org.springframework.stereotype.Service;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
@Service
public class GetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - I was injected via the setter";
    }
}
