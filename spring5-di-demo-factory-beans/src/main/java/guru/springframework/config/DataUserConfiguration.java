package guru.springframework.config;

import guru.springframework.models.FakeDataUser;
import guru.springframework.models.FakeJmsData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Do My Duyen on 8/19/2017.
 */
@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class DataUserConfiguration {


    @Value("${guru.username}")
    private String username;

    @Value("${guru.password}")
    private String password;

    @Value("${guru.url}")
    private String url;

    @Value("${guru.jms.username}")
    private String jmsUsername;

    @Value("${guru.jms.password}")
    private String jmsPassword;

    @Value("${guru.jms.url}")
    private String jmsUrl;

    @Bean
    public FakeDataUser fakeDataUser() {
        return new FakeDataUser(this.username,this.password,this.url);
    }

    @Bean
    public FakeJmsData fakeJmsData() {
        return new FakeJmsData(jmsUsername,jmsPassword,jmsUrl);
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

}
