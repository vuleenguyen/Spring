package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by Do My Duyen on 7/28/2017.
 */
@Service
@Primary
@Profile("de")
public class PrimaryGermanyGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Primarer GruSdienst";
    }
}
